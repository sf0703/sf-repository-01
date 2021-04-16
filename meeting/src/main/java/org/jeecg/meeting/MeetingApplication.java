package org.jeecg.meeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class MeetingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeetingApplication.class, args);
    }

}
