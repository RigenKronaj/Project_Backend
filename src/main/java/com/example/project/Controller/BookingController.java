package com.example.project.Controller;

import com.example.project.Model.Booking;
import com.example.project.Service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin (origins = "http://localhost:3000")
@RestController
public class BookingController {

    @Autowired
    BookingService bookingService;

    @RequestMapping(value = "/booking/{uid}", method = RequestMethod.GET)
    public ResponseEntity<Object> getBookings(@PathVariable("uid") Integer UID) {
        return new ResponseEntity<>(bookingService.getBookings(UID), HttpStatus.OK);
    }

    @RequestMapping(value = "/booking", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllBookings() {
        return new ResponseEntity<>(bookingService.getAllBookings(), HttpStatus.OK);
    }

    @RequestMapping(value = "/booking", method = RequestMethod.POST)
    public ResponseEntity<Object> createBooking(@RequestBody Booking booking) {
        bookingService.addBooking(booking);
        return new ResponseEntity<>("Booking has been added successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/booking/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteBooking(@PathVariable("id") Integer id) {
        bookingService.cancelReservation(id);
        return new ResponseEntity<>("Booking has been removed.", HttpStatus.OK);
    }
    
}
