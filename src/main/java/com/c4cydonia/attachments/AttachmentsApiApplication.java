package com.c4cydonia.attachments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(
        exclude = {DataSourceAutoConfiguration.class},
        scanBasePackages = {"com.c4cydonia.attachments"}
)
@RestController
public class AttachmentsApiApplication {

    @GetMapping("/")
    @ResponseBody
    public String hello() {
        return "Hello from attachments metadata API";
    }

    public static void main(String[] args) {
        SpringApplication.run(AttachmentsApiApplication.class, args);
    }

}
