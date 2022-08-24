package com.example.cashedandcustomer.Models;


import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "client")
@XmlAccessorType(XmlAccessType.NONE)
@Document(expiry = 0)
public class Client {
    @XmlElement(name="id")
    private Long id;
    @XmlElement(name="balance")
    private Balance balance;


    public Client(Long id, Balance balance) {
        this.id = id;
        this.balance = balance;
    }

    public Client() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public String toString(){
        return getId() + " " + getBalance();
    }
}
