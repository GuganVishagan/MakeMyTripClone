package org.example.Model;
import java.util.Date;
import java.util.List;

public class System {
    private List<Flight> flights;
    private static System instance;

public System(){
}

public static System getInstance(){
    if(instance == null)
        instance = new System();
    return instance;
}

public List<Flight> fetchFlights(String src, String dest, Date date){
    List<Flight> filteredFlights = new ArrayList<Flight>();
    for(Flight flight : flights){
        if(flight.date == date && (flight.src.equals(src) && flight.dest.equals(dest))) {
            filteredFlights.add(flight);
        }
    }
    return filteredFlights;
}

public boolean fixSeats(Aircraft aircraft, Seat seat){
    aircraft.fixSeats(seat, seat.getCustomer());
    return true;
}
}
