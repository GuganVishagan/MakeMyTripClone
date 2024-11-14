package org.example.Model;

public class Seat {
    private Type type;
    private String id;
    public Customer customer;
    private int price;

    public Seat(Type type, String id){
        this.type = type;
        this.id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Type getType() {
        return type;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getSeatId(){
        return id;
    }
}

enum Type{
    Economy,
    Premium,
    Emergency
}
