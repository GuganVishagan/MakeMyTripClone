package org.example.Services;

import org.example.Model.Seat;
import org.example.Model.User;

import java.util.HashMap;
import java.util.Map;

public class SeatManagerImpl implements  SeatManager {
    public SeatManagerImpl() {
    }

    @Override
    public boolean fixSeats(Seat seat, User user) {
        seat.setCustomer(user);
        return true;
    }

    @Override
    public boolean cancelSeats(Seat seat) {
        seat.setCustomer(null);
        return true;
    }
}
