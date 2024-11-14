package org.example.Model;

import java.util.Map;

public class Customer {
    public String id;
    public String name;
    public String email;
    public System system;

    public Customer(String id, String name, String email, System system){
        this.id = id;
        this.name = name;
        this.email = email;
        this.system = system;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public boolean fixSeat(Flight flight, Seat seat){
        return flight.getAircraft().fixSeats(seat, this);
    }

    public boolean cancelBooking(Flight flight){
       flight.cancelForCustomer(this);
       return true;
    }

}
