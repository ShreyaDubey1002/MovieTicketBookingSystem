package MovieTicketBookingSystem.models;

import java.util.HashMap;
import java.util.List;

public class Lock implements LockerFunctions {

    HashMap<Show, HashMap<Seat, SeatLocker>> lockers;

    public Lock() {
        this.lockers = new HashMap<>();
    }

    @Override
    public synchronized void lockSeats(Show show, List<Seat> seats, String user) {
        for (Seat seat : seats) {
            if (isSeatLocked(show, seat)) {
                System.out.println("Seats are locked");
                throw new RuntimeException();
            }
        }
        for (Seat seat : seats) {
            lockSeat(show, seat, user);
        }
    }

    @Override
    public void unlockSeats(Show show, List<Seat> seats, String user) {
        for (Seat seat : seats) {
            if (validateLocks(show, seat, user)) {
                unlockSeat(show, seat);
            }
        }
    }

    @Override
    public boolean validateLocks(Show show, Seat seat, String user) {
        if (isSeatLocked(show, seat) &&
                lockers.get(show).get(seat).getLockedBy().equalsIgnoreCase(user)) {
            return true;
        }
        return false;
    }

    public void lockSeat(Show show, Seat seat, String user) {
        if (!lockers.containsKey(show)) {
            lockers.put(show, new HashMap<>());
        }
        SeatLocker seatLocker =  new SeatLocker(show, seat, user);
        lockers.get(show).put(seat, seatLocker);
    }

    public void unlockSeat(Show show, Seat seat) {
        if (!lockers.containsKey(show)) {
            return;
        }
        lockers.get(show).remove(seat);
    }

    public boolean isSeatLocked(Show show, Seat seat) {
        if (lockers.containsKey(show) && lockers.get(show).containsKey(seat))
            return true;
        return false;
    }

}
