package com.example.personal;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PersonalApplication {


	public static void main(String[] args) {
		SpringApplication.run(PersonalApplication.class, args);
	}

  @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


	 @Bean
    public CommandLineRunner demo(PersonalRepository repository) {
		return args -> {

			// save a few customers
      /*repository.save(new Personal("Jack", "Bauer","JackB","qwerty"));
      repository.save(new Personal("Chloe", "O'Brian","ChloeO","qwerty"));
      repository.save(new Personal("Kim", "Bauer","KimB","qwerty"));
      repository.save(new Personal("David", "Palmer","DavidP","qwerty"));
      repository.save(new Personal("Michelle", "Dessler","MichelleD","qwerty"));*/

      System.out.println("______________________________________________________");

		};
	}

}
