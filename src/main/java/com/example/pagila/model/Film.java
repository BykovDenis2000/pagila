package com.example.pagila.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="inventory")
public class Film {
    @Id
    @Column(name = "inventory_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "film_id")
    private Integer film_id;

    @Column(name = "store_id")
    private Integer store_id;

    @Column(name = "last_update")
    private Date last_update;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFilm_id() {
        return film_id;
    }

    public void setFilm_id(Integer film_id) {
        this.film_id = film_id;
    }

    public Integer getStore_id() {
        return store_id;
    }

    public void setStore_id(Integer store_id) {
        this.store_id = store_id;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", film_id=" + film_id +
                ", store_id=" + store_id +
                ", last_update=" + last_update +
                '}';
    }
}
