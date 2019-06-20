package kr.ac.jejunu.tlog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FileDTO {
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;
}
