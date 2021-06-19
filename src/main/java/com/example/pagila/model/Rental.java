package com.example.pagila.model;

import javax.persistence.*;
import java.util.Date;
import org.apache.commons.lang3.time.DateUtils;

@Entity
@Table(name="rental")
public class Rental {
    @Id
    @Column(name = "rental_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rental_id;

    @Column(name="rental_date")
    private Date rental_date;

    @Column(name="inventory_id")
    private Integer inventory_id;

    @Column(name="customer_id")
    private Integer customer_id;

    @Column(name="return_date")
    private Date return_date;

    @Column(name="staff_id")
    private Integer staff_id;

    @Column(name="last_update")
    private Date last_update;

    public Rental() {}

    public Rental(Customer customer, Film film)
    {
        this.rental_date = new Date();
        this.inventory_id = film.getId();
        this.customer_id = customer.getId();
        this.return_date = DateUtils.addMonths(new Date(),1);
        this.staff_id = film.getStore_id();
        this.last_update = new Date();
    }


    public Integer getRental_id() {
        return rental_id;
    }

    public void setRental_id(Integer rental_id) {
        this.rental_id = rental_id;
    }

    public Date getRental_date() {
        return rental_date;
    }

    public void setRental_date(Date rental_date) {
        this.rental_date = rental_date;
    }

    public Integer getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(Integer inventory_id) {
        this.inventory_id = inventory_id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public Integer getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(Integer staff_id) {
        this.staff_id = staff_id;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }
}
