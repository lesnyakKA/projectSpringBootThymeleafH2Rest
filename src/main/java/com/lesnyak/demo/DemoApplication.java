package com.lesnyak.demo;

import com.lesnyak.demo.entity.Customer;
import com.lesnyak.demo.repository.CustomerRepository;
import com.lesnyak.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class  DemoApplication implements CommandLineRunner {

	@Autowired
	private CustomerService customerService;

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		customerService.save(new Customer("Ivan", "Butusov", "Butusov@mail.ru"));
//		customerService.save(new Customer("Stepan", "Bedonov", "Bedonov@mail.ru"));
//		customerService.save(new Customer("Alex", "Starbaks", "Starbaks@mail.ru"));
//		customerService.save(new Customer("Egor", "Letov", "Letov@mail.ru"));
//		customerService.save(new Customer("Zanud", "Postepenov", "Postepenov@mail.ru"));
	}
}
