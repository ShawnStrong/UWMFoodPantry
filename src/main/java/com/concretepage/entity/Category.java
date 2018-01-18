package com.concretepage.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// @Entity - This is a bean. Beans are the guys that live between Java and MySQL. A bean object in Java
// (usually) represents a row in a table. Every variable in here is collected by Spring at runtime and
// compiled into a bean called 'Partner'. Pretty neat, huh?
@Entity
public class Category {
    @Id
    @GeneratedValue
    private int category_id;

    private String category_name;

    private String category_size;

    private float category_weight;

    private int category_quantity;

    private String user_name;

    public Category() {}

    public Category(int id, String name, String size,
               float weight) {
        this.category_id = id;
        this.category_name = name;
        this.category_size = size;
        this.category_weight = weight;
    }

    public Category(int id, String name, String size,
                    float weight, int quantity, String userName) {
        this.category_id = id;
        this.category_name = name;
        this.category_size = size;
        this.category_weight = weight;
        this.category_quantity = quantity;
        this.user_name = userName;
    }

    public int getId() {
        return category_id;
    }

    public void setId(int id) {
        this.category_id = id;
    }

    public String getName() {
        return category_name;
    }

    public void setName(String name) {
        this.category_name = name;
    }

    public String getSize() {
        return category_size;
    }

    public void setSize(String size) {
        this.category_size = size;
    }

    public float getWeight() {
        return category_weight;
    }

    public void setWeight(float weight) {
        this.category_weight = weight;
    }

    public int getQuantity() { return category_quantity; }

    public void setQuantity( int quantity ) { this.category_quantity=quantity; }

    public String getUserName() { return user_name; }

    public void setUserName( String userName) { this.user_name=userName; }
}