/**package com.example.demo.User;

//import com.example.demo.Product.Product;
//import com.example.demo.Product.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner CommandLineRunner(
            UserRepository repository){
        return args -> {
            User Ayala = new User("Ayala",
                    "Rubinshtein",
                    "8806",
                    "3128806@gmail.com",
                    "female"
            );
            User Sara = new User("Sara",
                    "Viner",
                    "999",
                    "sara@gmail.com",
                    "female"
            );
            repository.saveAll(
                    List.of(Ayala, Sara)
            );
        };
    }
    @Bean
    CommandLineRunner CommandLineRunner(
            ProductRepository repository){
        return args -> {
            Product ring = new Product("ring",
                    8806,
                    "3128806@gmail.com",
                    "This is product"
            );
            Product necklace = new Product("necklace",
                    8806,
                    "3128806@gmail.com",
                    "This is product"
            );
            repository.saveAll(
                    List.of(ring, necklace)
            );
        };
    }
}*/