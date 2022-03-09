package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class StaffEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int balance = 0;

    @OneToOne(cascade = {CascadeType.ALL})
    private BasketEntity basket;

    public StaffEntity() {
    }

    public StaffEntity(String name, BasketEntity basket) {
        this.name = name;
        this.basket = basket;
    }

    public StaffEntity(String name, int balance, BasketEntity basket) {
        this.name = name;
        this.balance = balance;
        this.basket = basket;
    }

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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public BasketEntity getBasket() {
        return basket;
    }

    public void setBasket(BasketEntity basket) {
        this.basket = basket;
    }
}
