package com.example.personal;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class PersonalApplication {


	public static void main(String[] args) {
		SpringApplication.run(PersonalApplication.class, args);
	}


	 @Bean
    public CommandLineRunner demo(PersonalRepository repository) {
		return args -> {

			// save a few customers
      repository.save(new Personal("Jack", "Bauer"));
      repository.save(new Personal("Chloe", "O'Brian"));
      repository.save(new Personal("Kim", "Bauer"));
      repository.save(new Personal("David", "Palmer"));
      repository.save(new Personal("Michelle", "Dessler"));

      // fetch all customers
      System.out.println("Personal found with findAll():");
      System.out.println("-------------------------------");
      for (Personal personal : repository.findAll()) {
        System.out.println(personal.toString());
      }
      System.out.println("");

      // fetch an individual customer by ID
      /*Personal personal = repository.findById(1L);
      System.out.println("Personal found with findById(1L):");
      System.out.println("--------------------------------");
      System.out.println(personal.toString());
      System.out.println("");*/

      // fetch customers by last name
      /*System.out.println("Personal found with findByLastName('Bauer'):");
      System.out.println("--------------------------------------------");
      repository.findByApellidoPaterno("Bauer").forEach(bauer -> {
        System.out.println(bauer.toString());
      });*/


      System.out.println("");

		};
	}

}
