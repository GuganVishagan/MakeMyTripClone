package org.example.Services;
import org.example.Model.Seat;
import org.example.Model.User;

import java.util.List;

public interface SeatManager {

    public boolean fixSeats(Seat seat, User user);
    public boolean cancelSeats(Seat seat);
    public boolean isSeatBooked(Seat seat);
    public List<Seat> viewAllSeatsForCustomer(User user);
}
