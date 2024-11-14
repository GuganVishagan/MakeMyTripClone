package org.example.Model;
import java.util.Date;
import java.time.LocalTime;
import java.util.Map;


public class Flight {
    private Date date;
    private String src;
    private String dest;
    private LocalTime start;
    private LocalTime end;
    private Aircraft aircraft;

    public Flight(Date date, String src, String dest, LocalTime start, LocalTime end, Aircraft aircraft){
        this.date = date;
        this.src = src;
        this.dest = dest;
        this.start = start;
        this.end = end;
        this.aircraft = aircraft;
    }

    public boolean cancelForCustomer(Customer customer){
        Map<String, Seat> seats = this.getAircraft().getSeats();
        for(Seat seat: seats.values()){
            if(customer == seat.getCustomer())
                seat.setCustomer(null);
        }
        return true;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

}
