package org.example.Services;

import org.example.Model.Flight;
import org.example.Model.Seat;
import org.example.Model.User;

public interface BookingManager {
    boolean bookFlight(Flight flight, Seat seat, User user);
    boolean cancelFlight(Flight flight, Seat seat);
}
