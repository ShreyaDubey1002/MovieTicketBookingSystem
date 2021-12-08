package MovieTicketBookingSystem.driver;

import MovieTicketBookingSystem.models.*;
import MovieTicketBookingSystem.utilities.BookingService;
import MovieTicketBookingSystem.utilities.Payment;

import java.util.ArrayList;
import java.util.List;


public class Driver {
    public static void main(String[] args) {
        Theatre theatre = new Theatre();
        Screen screen1 = new Screen(theatre);
        screen1.addSeat(new Seat());
        theatre.addScreen(screen1);
        Screen screen2 = new Screen(theatre);
        theatre.addScreen(screen2);
        Seat seat1 = new Seat();
        Seat seat2 = new Seat();
        Seat seat3 = new Seat();
        Seat seat4 = new Seat();
        Seat seat5 = new Seat();

        screen1.addSeat(seat1);
        screen1.addSeat(seat2);
        screen1.addSeat(seat3);

        screen2.addSeat(seat4);
        screen2.addSeat(seat5);

        Lock lock = new Lock();
        BookingService bookingService =  new BookingService(lock);
        Payment payment =  new Payment(bookingService, lock);
        Movie movie1 = new Movie("Hero");
        Movie movie2 = new Movie("Hero2");
        Show show1 = new Show(1, 200L, movie1, screen1);
        Show show2 = new Show(3, 300L, movie2, screen2);
        List<Seat> seats11 = new ArrayList<>();
        seats11.add(seat1);
        seats11.add(seat2);
        List<Seat> seats12 = new ArrayList<>();
        seats12.add(seat4);
        seats12.add(seat5);
        Booking booking1 = bookingService.createBooking(show1, seats11, "Shreya");
        System.out.println("Booked tickets : " + booking1.getBookingId());
        payment.processFailedPayments(booking1, "Shreya");
        /*
        payment.processFailedPayments(booking1, "Shreya");
        payment.processFailedPayments(booking1, "Shreya");
        payment.processFailedPayments(booking1, "Shreya");
        */
        bookingService.confirmBooking(booking1, "Shreya");
        Booking booking2 = bookingService.createBooking(show2, seats12, "Shreya3");
        System.out.println("Booked tickets : " + booking2.getBookingId());
        bookingService.confirmBooking(booking2, "Shreya3");
    }
}
