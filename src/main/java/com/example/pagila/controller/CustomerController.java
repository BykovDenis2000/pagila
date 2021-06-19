package com.example.pagila.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {

    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping("/getfilm")
    @ResponseBody
    public JSONObject getFilm(@RequestParam(value="customer_id",required = false) Integer customer_id,
                              @RequestParam(value="inventory_id",required = false) Integer inventory_id)
    {
        return customerService.getFilm(customer_id,inventory_id);
    }

    @GetMapping("/getborrower")
    @ResponseBody
    public JSONObject getBorrower(@RequestParam(value="customer_id",required = false) Integer customer_id)
    {
        return customerService.getBorrower(customer_id);
    }

    @PostMapping("/returnfilm")
    @ResponseBody
    public JSONObject returnFilm(@RequestParam(value="customer_id",required = false) Integer customer_id,
                              @RequestParam(value="inventory_id",required = false) Integer inventory_id)
    {
        return customerService.returnFilm(customer_id,inventory_id);
    }

}
