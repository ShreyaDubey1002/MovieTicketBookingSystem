package MovieTicketBookingSystem.utilities;

import MovieTicketBookingSystem.models.Booking;
import MovieTicketBookingSystem.models.Lock;

import java.util.HashMap;

public class Payment {
    HashMap<Booking, Integer> failedBookings;
    int maxRetries;
    private Lock lock;
    BookingService bookingService;

    public Payment(BookingService bookingService, Lock lock) {
        failedBookings = new HashMap<Booking, Integer>();
        maxRetries = 0;
        this.bookingService = bookingService;
        this.lock = lock;
    }

    public void processFailedPayments(Booking booking, String user) {
        if (!failedBookings.containsKey(booking)) {
            failedBookings.put(booking, 0);
        }
        int retries = failedBookings.get(booking);
        failedBookings.put(booking, retries+1);
        System.out.println("retries : " + retries + " , maxRetries : " + maxRetries);
        if (retries >= maxRetries) {
            lock.unlockSeats(booking.getShow(), booking.getSeats(), booking.getUser());
            bookingService.expireBooking(booking, user);
        }
    }
}
