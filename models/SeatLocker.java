package MovieTicketBookingSystem.models;

public class SeatLocker {
    String seatLockerId;
    private static int lastShowId = 0;
    Seat seat;
    Show show;
    String lockedBy;

    public SeatLocker(Show show, Seat seat, String lockedBy) {
        lastShowId = lastShowId+1;
        this.seatLockerId = String.valueOf(lastShowId);
        this.seat = seat;
        this.show = show;
        this.lockedBy = lockedBy;
    }

    public String getSeatLockerId() {
        return seatLockerId;
    }

    public Seat getSeat() {
        return seat;
    }

    public Show getShow() {
        return show;
    }

    public String getLockedBy() {
        return lockedBy;
    }
}
