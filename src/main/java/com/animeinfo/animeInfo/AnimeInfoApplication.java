package com.animeinfo.animeInfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@SpringBootApplication(
	scanBasePackages = {
		"com.animeinfo.*",
		"com.animeinfo.animeInfo.*",
		"com.animeinfo.api.*"
	}
)
@EntityScan(basePackageClasses = { Jsr310JpaConverters.class },
	basePackages = {
		"com.animeinfo.animeInfo.*",
		"com.animeinfo.api.*"
	}
)
public class AnimeInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimeInfoApplication.class, args);
	}

}
