package org.example.Services;

import org.example.Enums.Role;
import org.example.Model.Flight;
import org.example.Model.User;

import java.util.ArrayList;
import java.util.List;

public class AdminManagerImpl implements AdminManager {
    private List<Flight> flights;
    public UserManager userManager;

    public AdminManagerImpl(UserManager userManager) {
        this.flights = new ArrayList<>();
        this.userManager = userManager;
    }

    @Override
    public boolean addFlight(Flight flight, User user) {
        if(this.userManager.getUserRole(user) == Role.Admin){
            this.flights.add(flight);
            System.out.println("Added flight " + flight);
            return true;
        }
        System.out.println("Invalid User Role, Can't add flight");
        return false;
    }

    @Override
    public boolean deleteFlight(Flight flight, User user) {
        if(this.userManager.getUserRole(user) == Role.Admin){
            this.flights.remove(flight);
            System.out.println("Removed flight " + flight);
            return true;
        }
        System.out.println("Invalid User Role, Can't remove flight");
        return false;
    }

    @Override
    public List<Flight> getAllFlights() {
        System.out.println("Get all flights");
        return this.flights;
    }

    @Override
    public List<Flight> getParticularFlights(Flight flight) {
        List<Flight> particularFlights = new ArrayList<>();
        for(Flight currentFlight : this.flights){
            if(flight.getDest().equals(currentFlight.getDest()) && flight.getSrc().equals((currentFlight.getSrc())) && flight.getDepartureTime().equals(currentFlight.getDepartureTime())){
                particularFlights.add(currentFlight);
            }
        }
        System.out.println("Get the particular flights");
        return particularFlights;
    }


}
