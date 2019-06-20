package kr.ac.jejunu.tlog;

import kr.ac.jejunu.tlog.property.FileUploadProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties({
        FileUploadProperties.class
})
public class TlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(TlogApplication.class, args);
    }

}
