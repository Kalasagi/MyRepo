package com.myproject.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.myproject.rest.util.MangaWikipediaUtil;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(final String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
		
		MangaWikipediaUtil.parse("datasThePromisedNeverland");
	}
}
