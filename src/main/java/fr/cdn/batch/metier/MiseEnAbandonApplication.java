package fr.cdn.batch.metier;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableBatchProcessing
@EnableAutoConfiguration
@SpringBootApplication
public class MiseEnAbandonApplication {
	public static void main(String[] args) {
		SpringApplication.run(MiseEnAbandonApplication.class, args);
	}

}
