package MovieTicketBookingSystem.models;

import java.util.List;

public class Booking {
    private String bookingId;
    private static int lastBookingId = 0;
    private Show show;
    private List<Seat> seats;
    private String user;
    private BookingStatus bookingStatus;


    public Booking(Show show, List<Seat> seats, String user) {
        lastBookingId = lastBookingId+1;
        bookingId = String.valueOf(lastBookingId);
        this.show = show;
        this.seats = seats;
        this.user = user;
        this.bookingStatus = BookingStatus.CREATED;
    }

    public boolean isConfirmed() {
        return this.bookingStatus==BookingStatus.CONFIRMED;
    }

    public void confirmBooking() {
        if (this.bookingStatus != BookingStatus.CREATED) {
            return;
        }
        this.bookingStatus = BookingStatus.CONFIRMED;
    }

    public void expireBooking() {
        if (this.bookingStatus != BookingStatus.CREATED) {
            return;
        }
        this.bookingStatus = BookingStatus.EXPIRED;
    }

    public String getBookingId() {
        return bookingId;
    }

    public Show getShow() {
        return show;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public String getUser() {
        return user;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }
}
