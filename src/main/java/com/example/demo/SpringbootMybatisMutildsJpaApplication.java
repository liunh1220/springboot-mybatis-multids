package com.example.demo;

import com.example.demo.base.db.DynamicDataSourceRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({DynamicDataSourceRegister.class})
@SpringBootApplication
public class SpringbootMybatisMutildsJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisMutildsJpaApplication.class, args);
	}
}
