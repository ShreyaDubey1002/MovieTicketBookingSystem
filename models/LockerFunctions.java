package MovieTicketBookingSystem.models;

import java.util.List;

public interface LockerFunctions {
    public void lockSeats(Show show, List<Seat> seats, String user);
    public void unlockSeats(Show show, List<Seat> seats, String user);
    public boolean validateLocks(Show show, Seat seat, String user);
}
