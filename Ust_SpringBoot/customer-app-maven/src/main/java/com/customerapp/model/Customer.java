package com.customerapp.model;
public class Customer implements Comparable<Customer>{
    private String name;
    private int id;
    private String email;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Customer() {

    }
    public Customer(String name, int id, String email) {
        super();
        this.name = name;
        this.id = id;
        this.email = email;
    }
   
    public String toString() {
        return "Customer [name=" + name + ", id=" + id + ", email=" + email + "]";
    }

    //sorting by id
    //@Override
    //public int compareTo(Customer c) {
    //    return this.id-c.id;
    //}

    //sorting by name

    public int compareTo(Customer c) {
        return this.name.compareTo(c.name);
    }


}
