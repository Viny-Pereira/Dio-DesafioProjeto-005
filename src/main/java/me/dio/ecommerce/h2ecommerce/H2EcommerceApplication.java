package me.dio.ecommerce.h2ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class H2EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(H2EcommerceApplication.class, args);
	}

}
