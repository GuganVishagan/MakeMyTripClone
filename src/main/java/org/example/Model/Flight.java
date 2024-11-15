package org.example.Model;
import java.time.LocalDateTime;
import java.util.Date;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;


public class Flight {
    public String flightId;
    public String src;
    public String dest;
    public LocalDateTime departureTime;
    public LocalDateTime arrivalTime;
    Map<String, Seat> seats;

    public Flight(String flightId, String src, String dest, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        this.flightId = flightId;
        this.src = src;
        this.dest = dest;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.seats = new HashMap<>();
    }


    public String getDest() {
        return dest;
    }

    public String getSrc() {
        return src;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public String getFlightId() {
        return flightId;
    }

    public Map<String, Seat> getFlightSeats() {
        return seats;
    }
}
