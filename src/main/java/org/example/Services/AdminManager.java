package org.example.Services;

import org.example.Model.Flight;
import org.example.Model.User;

import java.util.List;
import java.util.Map;

public interface AdminManager {
    boolean addFlight(Flight flight, User user);
    boolean deleteFlight(Flight flight, User user);
    boolean isFlightAvailable(Flight flight);
    List<Flight> getAllFlights();
    List<Flight> getParticularFlights(Flight flight);
}
