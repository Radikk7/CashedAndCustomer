package com.example.cashedandcustomer.Models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="List")
@XmlAccessorType(XmlAccessType.FIELD)
public class CollectionClient {
    @XmlElement(name = "item")
    private List<Client> item;

    public CollectionClient(List<Client> item) {
        this.item = item;
    }

    public CollectionClient() {
    }

    public List<Client> getItem() {
        return item;
    }

    public void setItem(List<Client> item) {
        this.item = item;
    }

    public String toString(){
        return getItem() + " ";
    }
}
