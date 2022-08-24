package com.example.cashedandcustomer.Models;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "list")
@XmlAccessorType(XmlAccessType.NONE)
public class CollectionBalance {
    @XmlElement(name = "value")
    private int value;

    public CollectionBalance(int value) {
        this.value = value;
    }

    public CollectionBalance() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

