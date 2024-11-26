package org.example.Services;

import org.example.Model.Seat;
import org.example.Model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeatManagerImpl implements  SeatManager {
    public Map<String, Seat> seats;
    public SeatManagerImpl() {
        this.seats = new HashMap<>();
    }

    @Override
    public boolean fixSeats(Seat seat, User user) {
        seat.setCustomer(user);
        seats.putIfAbsent(seat.getSeatId(), seat);
        return true;
    }

    @Override
    public boolean cancelSeats(Seat seat) {
        seats.remove(seat.getSeatId());
        seat.setCustomer(null);
        return true;
    }

    @Override
    public List<Seat> viewAllSeatsForCustomer(User user) {
        List<Seat> filteredSeats = new ArrayList<>();
        for(Seat seat : seats.values()) {
            if(seat.getCustomer().equals(user)) {
                filteredSeats.add(seat);
            }
        }
        return filteredSeats;
    }

    @Override
    public boolean isSeatBooked(Seat seat) {
        return seats.containsKey(seat.getSeatId());
    }


}
