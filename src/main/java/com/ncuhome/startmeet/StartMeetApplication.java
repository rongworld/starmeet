package com.ncuhome.startmeet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class StartMeetApplication {
	public static void main(String[] args) {
		SpringApplication.run(StartMeetApplication.class, args);
	}
}
