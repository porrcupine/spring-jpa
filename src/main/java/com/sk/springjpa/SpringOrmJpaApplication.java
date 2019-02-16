package com.sk.springjpa;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;


@SpringBootApplication
public class SpringOrmJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOrmJpaApplication.class, args);



		try {
			Console.main(args);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

