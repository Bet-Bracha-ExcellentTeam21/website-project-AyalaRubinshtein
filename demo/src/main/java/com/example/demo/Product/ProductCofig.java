package com.example.demo.Product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductCofig {

    @Bean
    CommandLineRunner CommandLineRunner(ProductRepository repository){
        return args -> {
            Product ringRole = new Product("ring role",
                     "ring",
                     19.9,
                     "assets/img/bootstrap-ring.png",
                     "This is product"
                     );
            Product necklace1 = new Product("woman necklace",
                    "necklace",
                    100,
                    "assets/img/bootstrap-templates.png",
                    "This is product"
            );
            Product bracelets = new Product("bracelets",
                    "bracelet",
                    80,
                    "assets/img/b.jpg",
                    "This is very nice product"
            );
            Product smartWatch = new Product("smart watch",
                    "watch",
                    250,
                    "assets/img/carousel1.png",
                    "This is smart watch"
            );
            repository.saveAll(
                    List.of(ringRole, necklace1, bracelets, smartWatch)
            );
        };
    }
}