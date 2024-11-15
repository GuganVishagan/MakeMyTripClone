package org.example.Services;
import org.example.Model.Seat;
import org.example.Model.User;
public interface SeatManager {

    public boolean fixSeats(Seat seat, User user);
    public boolean cancelSeats(Seat seat);
}
