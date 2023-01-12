package com.day13_Workshop.addressBook;

import java.io.File;

import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// main file for initialisating Spring Boot App
@SpringBootApplication
public class AddressBookApplication {

	public static void main(String[] args) {
		
		SpringApplication app = new SpringApplication(AddressBookApplication.class);
		
		// getting value of option --dataDir
		DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);
		String pathName = appArgs.getOptionValues("dataDir").get(0);

		// if value is not null, create directory and exit
		if (null != pathName) { // put null first to prevent null point exception
			System.out.println("Found: --dataDir"); // REMOVE
			System.out.println("pathName: " + pathName); // REMOVE
			// create path object
			File dir = new File(pathName);
			// create folder with path
			dir.mkdirs();
		} else { // else exit
			System.exit(1);
		}
		
		app.run(args);
	}
}
