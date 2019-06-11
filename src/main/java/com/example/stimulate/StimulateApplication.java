package com.example.stimulate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.stimulate.dao")
public class StimulateApplication {

	public static void main(String[] args) {
		SpringApplication.run(StimulateApplication.class, args);
		System.out.println("===================项目启动");
	}

}
