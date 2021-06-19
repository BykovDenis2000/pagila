package com.example.pagila;

import com.example.pagila.controller.CustomerService;
import com.example.pagila.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class PagilaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PagilaApplication.class, args);
    }


}
