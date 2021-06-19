package com.example.pagila.controller;

import com.example.pagila.model.Customer;
import com.example.pagila.model.Film;
import com.example.pagila.model.Rental;
import com.example.pagila.repository.CustomerRepository;
import com.example.pagila.repository.InventoryRepository;
import com.example.pagila.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@Service
public class CustomerService  {
    private final CustomerRepository customerRepository;
    private final InventoryRepository inventoryRepository;
    private final RentalRepository rentalRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository,InventoryRepository inventoryRepository,RentalRepository rentalRepository){
        this.customerRepository = customerRepository;
        this.inventoryRepository = inventoryRepository;
        this.rentalRepository = rentalRepository;
    }

    public JSONObject getFilm(Integer customer_id, Integer film_id)
    {
        JSONObject films = new JSONObject();
        JSONArray filmArray = new JSONArray();
        Customer customer = customerRepository.getById(customer_id);
        Film film = inventoryRepository.getById(film_id);
        Rental rental = new Rental(customer,film);
        rentalRepository.save(rental);

        JSONObject filmJSON = new JSONObject();
        filmJSON.put("inventory_id",rental.getInventory_id());
        filmJSON.put("customer_id",rental.getCustomer_id());
        filmArray.add(filmJSON);

        films.put("borrowers",filmArray);
        return films;
    }
    public JSONObject getBorrower(Integer customer_id)
    {

        JSONObject films = new JSONObject();
        JSONArray filmArray = new JSONArray();
        JSONObject filmJSON = new JSONObject();

        for(Rental r : rentalRepository.findAll())
        {
            if(r.getCustomer_id().equals(customer_id))
            {
                filmJSON.put("inventory_id", r.getInventory_id());
                filmJSON.put("customer_id", r.getCustomer_id());
                filmJSON.put("rental_date", r.getRental_date());
                filmArray.add(filmJSON);
                films.put("borrowers", filmArray);
            }
        }
        return films;
    }
    public JSONObject returnFilm(Integer customer_id, Integer film_id)
    {
        JSONObject films = new JSONObject();
        JSONArray filmArray = new JSONArray();
        JSONObject filmJSON = new JSONObject();
        for(Rental r : rentalRepository.findAll())
        {
            if(r.getCustomer_id().equals(customer_id) && r.getInventory_id().equals(film_id))
            {
                rentalRepository.delete(r);
                filmJSON.put("inventory_id", r.getInventory_id());
                filmJSON.put("customer_id", r.getCustomer_id());
                filmJSON.put("rental_date", r.getRental_date());
                filmArray.add(filmJSON);
                films.put("returned", filmArray);
            }
        }
        return  films;
    }



}
