package MovieTicketBookingSystem.utilities;

import MovieTicketBookingSystem.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookingService {
    private Lock lock;
    private HashMap<String, Booking> bookings;

    public BookingService (Lock lock) {
        this.lock = lock;
        this.bookings = new HashMap<>();
    }

    public Booking createBooking(Show show, List<Seat> seats, String user) {
        if (isAnySeatBooked(show, seats)) {
            System.out.println("Some seats are already booked.");
            return null;
        }
        lock.lockSeats(show, seats, user);
        Booking booking = new Booking(show, seats, user);
        bookings.put(booking.getBookingId(), booking);
        return booking;
    }

    public void confirmBooking(Booking booking, String user) {
        if (booking.getBookingStatus() != BookingStatus.CREATED) {
            System.out.println("Can't confirm, booking is expired");
            return;
        }
        System.out.println("Here!!");
        if (!booking.getUser().equals(user)) {
            System.out.println("Wrong user confirming the booking.");
            return;
        }
        for (Seat seat : booking.getSeats()) {
            if (!lock.validateLocks(booking.getShow(), seat, user)) {
                System.out.println("Locks incorrectly held, can't confirm the booking.");
                return;
            }
        }
        System.out.println("Booked tickets : " + booking.getBookingId());
        booking.confirmBooking();
    }

    public void expireBooking(Booking booking, String user) {
        System.out.println("booking.status : " + booking.getBookingStatus());
        if (!booking.getUser().equals(user)) {
            System.out.println("Wrong user expiring the booking.");
            return;
        }
        bookings.remove(booking);
        booking.expireBooking();
    }

    public List<Seat> getAllSeats (Show show) {
        List<Seat> seats =  new ArrayList<>();
        for (Booking booking : bookings.values()) {
            if (booking.getShow().equals(show)) {
                seats.addAll(booking.getSeats());
            }
        }
        return seats;
    }

    public List<Seat> getBookedSeats (Show show) {
        List<Seat> seats =  new ArrayList<>();
        for (Booking booking : bookings.values()) {
            if (booking.getShow().equals(show) && booking.getBookingStatus() == BookingStatus.CONFIRMED) {
                seats.addAll(booking.getSeats());
            }
        }
        return seats;
    }

    public boolean isAnySeatBooked(Show show, List<Seat> seats) {
        List<Seat> bookedSeats = getBookedSeats(show);
        for (Seat seat : seats) {
            if (bookedSeats.contains(seat))
                return true;
        }
        return false;
    }
}
