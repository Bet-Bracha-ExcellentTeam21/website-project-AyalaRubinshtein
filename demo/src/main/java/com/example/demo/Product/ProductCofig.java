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
            Product classicDiamondRing = new Product("classic diamond ring",
                    "ring",
                    250,
                    "assets/img/h.jpg",
                    "This is very nice ring "
            );
            Product earring = new Product("earring",
                    "watch",
                    250,
                    "assets/img/f.jpg",
                    "This is nice earring"
            );
            Product blueRing = new Product("blue ring",
                    "ring",
                    380,
                    "assets/img/j.jpg",
                    "This is blue diamond ring"
            );
            repository.saveAll(
                    List.of(ringRole, necklace1, bracelets, smartWatch, classicDiamondRing, earring, blueRing)
            );
        };
    }
}