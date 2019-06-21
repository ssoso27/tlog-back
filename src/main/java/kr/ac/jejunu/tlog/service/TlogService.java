package kr.ac.jejunu.tlog.service;

import kr.ac.jejunu.tlog.dto.TlogDTO;
import kr.ac.jejunu.tlog.entity.Hashtag;
import kr.ac.jejunu.tlog.entity.Tlog;
import kr.ac.jejunu.tlog.repository.HashtagRepository;
import kr.ac.jejunu.tlog.repository.TlogRepository;
import kr.ac.jejunu.tlog.util.FileUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Service
public class TlogService {

    @Autowired
    TlogRepository repository;

    @Autowired
    HashtagRepository hashtagRepo;

    @Autowired
    FileUploader fileUploader;

    public List<Tlog> list(Sort sort) {
        return repository.findAll(sort);
    }

    public Long create(TlogDTO tlogDTO) {
        String savedFileName = "";

        if (tlogDTO.getBackgroundImg() != null) {
            savedFileName = fileUploader.saveFile(tlogDTO.getBackgroundImg());
        }

        // Tlog 저장
        Tlog tlog = tlogDTO.toTlog();
        tlog.setBackgroundImg(savedFileName);
        repository.save(tlog);

        // 해시태그 저장
        if (tlogDTO.getHashtags() != null) {
            ArrayList<Hashtag> hashtagList = new ArrayList<Hashtag>();
            for (String hashtag: tlogDTO.getHashtags()) {
                hashtagList.add(Hashtag.builder().tlog(tlog).content(hashtag).build());
            }
            hashtagRepo.saveAll(hashtagList);
        }

        return tlog.getId();
    }

    public TlogDTO get(Long id) {
        Tlog tlog = repository.findById(id).orElse(null);

        List<Hashtag> hashtagList = hashtagRepo.findAllByTlogId(tlog.getId());
        ArrayList<String> contents = new ArrayList<String>();
        for (Hashtag hashtag: hashtagList) {
            contents.add(hashtag.getContent());
        }
        String[] hashtags = new String[contents.size()];
        hashtags = contents.toArray(hashtags);

        return tlog.toDTO(hashtags);
    }
}
