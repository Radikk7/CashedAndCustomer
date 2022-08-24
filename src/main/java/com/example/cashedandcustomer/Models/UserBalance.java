package com.example.cashedandcustomer.Models;

import javax.persistence.*;

@Entity
public class UserBalance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int value;

    public UserBalance(Long id, int value) {
        this.id = id;
        this.value = value;
    }

    public UserBalance() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
