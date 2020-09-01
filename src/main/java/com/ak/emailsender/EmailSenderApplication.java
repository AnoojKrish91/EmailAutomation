package com.ak.emailsender;

import com.ak.emailsender.controller.WeeklyEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@EnableAutoConfiguration
public class EmailSenderApplication implements CommandLineRunner {

    public static void main( String[] args )
    {
        SpringApplication.run(EmailSenderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started Run thread");
    }
}

