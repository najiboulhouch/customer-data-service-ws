package net.najiboulhouch.customerdataservice;

import net.najiboulhouch.customerdataservice.entities.Customer;
import net.najiboulhouch.customerdataservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerDataServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args -> {
				customerRepository.save(Customer.builder().name("TEST1").email("test1@gmail.com").build());
				customerRepository.save(Customer.builder().name("TEST2").email("test2@gmail.com").build());
				customerRepository.save(Customer.builder().name("TEST3").email("test3@gmail.com").build());
		};
	}

}
