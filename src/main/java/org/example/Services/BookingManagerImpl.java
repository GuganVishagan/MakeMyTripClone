package org.example.Services;

import org.example.Model.Flight;
import org.example.Model.Seat;
import org.example.Model.User;

import java.util.List;

public class BookingManagerImpl implements BookingManager {

    public SeatManager seatManager;
    public AdminManager adminManager;

    public BookingManagerImpl(SeatManager seatManager, AdminManager adminManager) {
        this.seatManager = seatManager;
        this.adminManager = adminManager;
    }

    @Override
    public boolean bookFlight(Flight flight, Seat seat, User user) {
        List<Flight> filteredFlights = this.adminManager.getParticularFlights(flight);
        if(filteredFlights.contains(flight)) {
            if(this.seatManager.fixSeats(seat, user)){
                System.out.println("Fixed Seats");
                return true;
            }
            else{
                System.out.println("Seats not Available.");
                return false;
            }

        }else{
            System.out.println("Flight not available");
            return false;
        }
    }

    @Override
    public boolean cancelFlight(Flight flight, Seat seat) {
        List<Flight> filteredFlights = this.adminManager.getParticularFlights(flight);
        if(filteredFlights.contains(flight)) {
            if(this.seatManager.cancelSeats(seat)){
                System.out.println("Cancelled Seats");
                return true;
            }
            else{
                System.out.println("Not able to cancel Seats");
                return false;
            }

        }else{
            System.out.println("Flight not available");
            return false;
        }
    }
}
