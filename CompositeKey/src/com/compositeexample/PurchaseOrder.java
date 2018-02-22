package com.compositeexample;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
 
@Entity
@Table(name = "PURCHASE_ORDERS")
public class PurchaseOrder {
     
    private String street;
    private String city;
    @Column(name = "ITEMNAME")
    private String itemName;
     
    @Id
    @AttributeOverrides({
    @AttributeOverride(name = "street",
    column = @Column(name="STREET")),
    @AttributeOverride(name = "city",
    column = @Column(name="CITY"))
    })
     
    public String getItemName() {
        return itemName;
    }
     
    public String getStreet() {
        return street;
    }
 
    public void setStreet(String street) {
        this.street = street;
    }
 
    public String getCity() {
        return city;
    }
 
    public void setCity(String city) {
        this.city = city;
    }
 
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
     
}