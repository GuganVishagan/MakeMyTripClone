package org.example.Model;

import org.example.Enums.SeatType;

public class Seat {
    private SeatType seatType;
    private final String id;
    public User customer;

    public Seat(SeatType type, final String id) {
        this.seatType = type;
        this.id = id;
    }

    public SeatType getType() {
        return seatType;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User user){
        this.customer = user;
    }

    public String getSeatId(){
        return id;
    }
}

