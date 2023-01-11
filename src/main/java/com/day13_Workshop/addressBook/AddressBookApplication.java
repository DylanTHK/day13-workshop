package com.day13_Workshop.addressBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AddressBookApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AddressBookApplication.class);
		System.out.println("running app");
		
		// print out args with --dataDir=/opt/tmp/data
		System.out.println("Testing psvm");
		for (String s : args) {
			System.out.println("Java Args: " + s);
		}
		app.run(args);

	}

}
