package org.example.Model;

import java.util.HashMap;
import java.util.Map;

public class Aircraft {
    private Map<String, Seat> seats;
    private String id;

    public Aircraft(Map<String, Seat> seats, String id) {
        this.seats = new HashMap<>();
        this.id = id;
    }

    public boolean fixSeats(Seat seat, Customer customer) {
        seat.setCustomer(customer);
        return true;
    }

    public Map<String, Seat> getSeats() {
        return seats;
    }
}
