package org.example.Services;

import org.example.Model.Flight;
import org.example.Model.Seat;
import org.example.Model.User;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BookingManagerImpl implements BookingManager {

    public SeatManager seatManager;
    public AdminManager adminManager;
    private final Lock seatLock = new ReentrantLock();

    public BookingManagerImpl(SeatManager seatManager, AdminManager adminManager) {
        this.seatManager = seatManager;
        this.adminManager = adminManager;
    }

    @Override
    public boolean bookFlight(Flight flight, Seat seat, User user) {
        if(!adminManager.isFlightAvailable(flight)){
            System.out.println("Flight not available.");
            return false;
        }
        seatLock.lock();
        try{
            if(seatManager.isSeatBooked(seat)){
                System.out.println("Seat already booked.");
                return false;
            }
            if(seatManager.fixSeats(seat, user)){
                System.out.println("Seat booked successfully for " + user.getName());
                return true;
            }
        }
        finally {
            seatLock.unlock();
        }
        System.out.println("Seat booking failed");
        return false;
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
