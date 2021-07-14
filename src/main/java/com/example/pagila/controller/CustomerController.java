package com.example.pagila.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Set;

@Validated
@Controller
public class CustomerController {

    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping("/getfilm")
    @ResponseBody
    public JSONObject getFilm(@RequestParam(value="customer_id",required = false) @Min(1) @Max(10) Integer customer_id,
                              @RequestParam(value="inventory_id",required = false) @Min(1) @Max(4581) Integer inventory_id)
    {
        if(customer_id<=0)
            throw new IllegalArgumentException("customer_id must be greater than 0");
        if(inventory_id<=0)
            throw new IllegalArgumentException("inventory_id must be greater than 0") ;

        return customerService.getFilm(customer_id,inventory_id);
    }

    @GetMapping("/getborrower")
    @ResponseBody
    public JSONObject getBorrower(@RequestParam(value="customer_id",required = false) @Min(1) @Max(10) Integer customer_id)
    {
        if(customer_id<=0)
            throw new IllegalArgumentException("customer_id must be greater than 0");

        return customerService.getBorrower(customer_id);
    }

    @PostMapping("/returnfilm")
    @ResponseBody
    public JSONObject returnFilm(@RequestParam(value="customer_id",required = false) @Min(1) @Max(10) Integer customer_id,
                              @RequestParam(value="inventory_id",required = false) @Min(1) @Max(4581) Integer inventory_id)
    {
        if(customer_id<=0)
            throw new IllegalArgumentException("customer_id must be greater than 0");
        if(inventory_id<=0)
            throw new IllegalArgumentException("inventory_id must be greater than 0") ;

        return customerService.returnFilm(customer_id,inventory_id);
    }

}
