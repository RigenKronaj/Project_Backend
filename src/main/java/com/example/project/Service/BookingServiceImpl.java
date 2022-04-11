package com.example.project.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.example.project.Model.Booking;

public class BookingServiceImpl implements BookingService {

    private Map<Integer, Booking> bookings = new HashMap<Integer, Booking>();
    private AtomicLong counter = new AtomicLong();
    
    public BookingServiceImpl() {
        try(BufferedReader br = new BufferedReader(new FileReader("data.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(", ");
                Booking booking = new Booking((int)counter.incrementAndGet(), Integer.parseInt(values[7]), values[0], values[5], values[6], Boolean.parseBoolean(values[4]));
                bookings.put(counter.intValue(), booking);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void setReservation() {
    }

    @Override
    public void cancelReservation() {
    }
    
}
