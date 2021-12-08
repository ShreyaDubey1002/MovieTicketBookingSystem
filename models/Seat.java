package MovieTicketBookingSystem.models;

public class Seat {
    private String seatId;
    private static int lastSeatId = 0;
    private int rowNo;
    private int seatNo;

    public Seat() {
        lastSeatId = lastSeatId+1;
        this.seatId = String.valueOf(lastSeatId);
    }

    public String getSeatId() {
        return seatId;
    }
}
