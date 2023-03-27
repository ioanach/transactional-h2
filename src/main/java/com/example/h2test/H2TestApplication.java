package com.example.h2test;

import com.example.h2test.service.PaymentsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class H2TestApplication {

    public static void main(String[] args) {

        SpringApplication.run(H2TestApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(PaymentsService service) {
//        return args -> {
//            System.out.println("Number of payments in DB: "+ service.getNumberOfPayments());
////            service.saveTenPayments();
//            System.out.println("Number of payments in DB: "+ service.getNumberOfPayments());
//        };
//    }
}
