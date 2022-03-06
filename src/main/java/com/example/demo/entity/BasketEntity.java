package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class BasketEntity {
    @Id
    @GeneratedValue
    private long id;
    private long amount = 0;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAmount() {
        return amount;
    }

    public void add(long amt) {
        this.amount = this.amount + amt;
    }

    public void substract(long amt) {
        this.amount = this.amount - amt;
    }
}
