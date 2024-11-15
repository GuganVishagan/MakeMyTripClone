package org.example.Services;

import org.example.Model.Flight;
import org.example.Model.User;

import java.util.List;

public interface AdminManager {
    boolean addFlight(Flight flight, User user);
    boolean deleteFlight(Flight flight, User user);
    List<Flight> getAllFlights();
    List<Flight> getParticularFlights(Flight flight);
}
