package com.revature.foodstuff;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FoodStuffApplication {


	public static void main(String[] args) {
		SpringApplication.run(FoodStuffApplication.class, args);

	}

}
