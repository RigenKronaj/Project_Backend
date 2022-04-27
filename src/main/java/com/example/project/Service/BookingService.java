package com.example.project.Service;

import java.util.Collection;

import com.example.project.Model.Booking;

public interface BookingService {
    public abstract void addBooking(Booking booking);
    public abstract void cancelReservation(Integer id);
    public abstract Collection<Booking> getBookings(Integer UID);
    public abstract Collection<Booking> getAllBookings();
}
