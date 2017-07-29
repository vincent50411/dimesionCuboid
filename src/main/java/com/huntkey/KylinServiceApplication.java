package com.huntkey;

import com.huntkey.dto.ApplicationDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class KylinServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KylinServiceApplication.class, args);
	}
}
