package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class StaffEntity {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToOne(cascade = {CascadeType.ALL})
    private BasketEntity basket;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BasketEntity getBasket() {
        return basket;
    }

    public void setBasket(BasketEntity basket) {
        this.basket = basket;
    }
}
