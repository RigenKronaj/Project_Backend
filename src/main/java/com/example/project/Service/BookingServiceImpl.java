package com.example.project.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.example.project.Model.Booking;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class BookingServiceImpl implements BookingService {

    private Map<Integer, Booking> bookings = new HashMap<Integer, Booking>();
    private AtomicLong counter = new AtomicLong();

    public BookingServiceImpl() {
        bookings.put((int)counter.incrementAndGet(), new Booking(counter.intValue(), 1001, "2/5/2022", "12/5/2022"));
        bookings.put((int)counter.incrementAndGet(), new Booking(counter.intValue(), 1002, "29/4/2022", "6/5/2022"));
        bookings.put((int)counter.incrementAndGet(), new Booking(counter.intValue(), 1002, "4/5/2022", "10/5/2022"));
        bookings.put((int)counter.incrementAndGet(), new Booking(counter.intValue(), 1001, "28/4/2022", "11/5/2022"));
        bookings.put((int)counter.incrementAndGet(), new Booking(counter.intValue(), 1001, "28/4/2022", "15/5/2022"));
        bookings.put((int)counter.incrementAndGet(), new Booking(counter.intValue(), 1002, "25/4/2022", "1/5/2022"));
    }

    @Override
    public Collection<Booking> getBookings(Integer UID) {
        Map<Integer, Booking> filteredBookings = new HashMap<Integer, Booking>();

        for(Map.Entry<Integer, Booking> el : bookings.entrySet()){
            if(el.getValue().getUID().equals(UID))
                filteredBookings.put(el.getKey(), el.getValue());
        }

        return filteredBookings.values();
    }

    @Override
    public Collection<Booking> getAllBookings() {
        return bookings.values();
    }

    @Override
    public void addBooking(Booking booking) {
        if(bookings.containsKey(booking.getId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Article already exists");

        bookings.put(booking.getId(), booking);
    }

    @Override
    public void cancelReservation(Integer id) {
        bookings.remove(id);
    }

}
