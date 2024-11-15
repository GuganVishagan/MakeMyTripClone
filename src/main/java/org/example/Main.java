package org.example;

import org.example.Enums.Role;
import org.example.Enums.SeatType;
import org.example.Model.*;
import org.example.Services.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManagerImpl();

        User user1 = new User("Vishal", "vishal@gmail.com", "21/08/1996", "1", Role.Admin, "vishal@123");
        userManager.registerUser(user1);
        userManager.login("vishal@gmail.com", "vishal@123");

        AdminManager adminManager = new AdminManagerImpl(userManager);
        Flight flight1 = new Flight("101","PNQ", "BNG", LocalDateTime.of(2024, 10, 25, 15, 30), LocalDateTime.of(2024, 10, 26, 15, 30)) ;
        Flight flight2 = new Flight("102","BNG", "PNQ", LocalDateTime.of(2024, 9, 25, 15, 30), LocalDateTime.of(2024, 9, 26, 15, 30)) ;
        Flight flight3 = new Flight("103","LND", "MUM", LocalDateTime.of(2024, 8, 25, 15, 30), LocalDateTime.of(2024, 8, 26, 15, 30)) ;
        Flight flight4 = new Flight("104","PNQ", "DEL", LocalDateTime.of(2024, 7, 25, 15, 30), LocalDateTime.of(2024, 7, 26, 15, 30)) ;
        Flight flight5 = new Flight("105","PZD", "NYK", LocalDateTime.of(2024, 6, 25, 15, 30), LocalDateTime.of(2024, 6, 26, 15, 30)) ;

        adminManager.addFlight(flight1, user1);
        adminManager.addFlight(flight2, user1);
        adminManager.addFlight(flight3, user1);
        adminManager.addFlight(flight4, user1);
        adminManager.addFlight(flight5, user1);

        adminManager.getAllFlights().forEach(flight -> System.out.println(flight.flightId + " " + flight.src + " " + flight.dest ));

        User customer1 = new User("Komal", "komal@gmail.com", "21/08/1996", "1", Role.Admin, "komal@123");
        userManager.registerUser(customer1);
        userManager.login("komal@gmail.com", "komal@123");

        SeatManager seatManager = new SeatManagerImpl();
        Seat seatForCustomer1 = new Seat(SeatType.Economy, "1-A");



        BookingManager bookingManager = new BookingManagerImpl(seatManager, adminManager);

        bookingManager.bookFlight(flight2, seatForCustomer1, customer1);
    }
}
