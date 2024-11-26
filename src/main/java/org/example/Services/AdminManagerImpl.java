package org.example.Services;

import org.example.Enums.Role;
import org.example.Model.Flight;
import org.example.Model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdminManagerImpl implements AdminManager {
    public Map<String, Flight> flights;
    public UserManager userManager;

    public AdminManagerImpl(UserManager userManager) {
        this.flights = new HashMap<>();
        this.userManager = userManager;
    }

    @Override
    public boolean addFlight(Flight flight, User user) {
        if(this.userManager.getUserRole(user) == Role.Admin){
            this.flights.putIfAbsent(flight.getFlightId(), flight);
            System.out.println("Added flight " + flight);
            return true;
        }
        System.out.println("Invalid User Role, Can't add flight");
        return false;
    }

    @Override
    public boolean deleteFlight(Flight flight, User user) {
        if(this.userManager.getUserRole(user) == Role.Admin){
            this.flights.remove(flight.getFlightId());
            System.out.println("Removed flight " + flight);
            return true;
        }
        System.out.println("Invalid User Role, Can't remove flight");
        return false;
    }

    @Override
    public List<Flight> getAllFlights() {
        System.out.println("Get all flights");
        return this.flights.values().stream().collect(Collectors.toList());
    }

    @Override
    public List<Flight> getParticularFlights(Flight flight) {
        List<Flight> particularFlights = new ArrayList<>();
        for(Flight currentFlight : this.flights.values()){
            if(currentFlight.getFlightId().equals(flight.getFlightId())){
                particularFlights.add(currentFlight);
            }
        }
        System.out.println("Get the particular flights");
        return particularFlights;
    }

    @Override
    public boolean isFlightAvailable(Flight flight) {
        return this.flights.containsKey(flight.getFlightId());
    }


}
