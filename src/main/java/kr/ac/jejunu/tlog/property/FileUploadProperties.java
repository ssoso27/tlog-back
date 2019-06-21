package kr.ac.jejunu.tlog.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

// POJO class
@ConfigurationProperties(prefix="file")
public class FileUploadProperties {
    private String uploadDir; // 필드명은 카멜케이스로 표기됨
    private String imagePreurl;

    public String getUploadDir() {
        return uploadDir;
    }

    public String getImagePreurl() {
        return imagePreurl;
    }

    public void setImagePreurl(String imagePreurl) {
        this.imagePreurl = imagePreurl;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}
