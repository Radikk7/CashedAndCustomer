package com.example.cashedandcustomer.Models;


import org.springframework.data.couchbase.core.mapping.Document;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Balance")
@XmlAccessorType(XmlAccessType.NONE)
@Document(expiry = 0)
public class Balance {
    @XmlElement(name="id")
    private Long id;
    @XmlElement(name="value")
    private int value;


    public Balance() {
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
    public String toString(){
        return getId() + " " + getValue();
    }

}