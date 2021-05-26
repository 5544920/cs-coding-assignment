package com.cs.assignment.logservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cs.assignment.logservice.service.LogProcessingService;

@SpringBootApplication
public class LogServiceApplication implements CommandLineRunner {
	@Autowired
	private LogProcessingService logProcessingService;

	public static void main(String[] args) {
		SpringApplication.run(LogServiceApplication.class, args);
	}

	// Put your logic here.
	@Override
	public void run(String... args) throws Exception {

			logProcessingService.saveProcessedLogData();
		}

		//exit(0);
	}


