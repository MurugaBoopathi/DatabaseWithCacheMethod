package com.example.dbcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DatabaseWithCacheMethodsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseWithCacheMethodsApplication.class, args);
	}
}
