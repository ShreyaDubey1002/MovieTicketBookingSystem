package MovieTicketBookingSystem.models;

import java.util.HashMap;

public class Screen {
    String screenId;
    private static int lastScreenId = 0;
    private HashMap<String, Seat> seats;
    private HashMap<String, Show> shows;
    Theatre theatre;

    public Screen(HashMap<String, Seat> seats, HashMap<String, Show> shows, Theatre theatre) {
        lastScreenId = lastScreenId+1;
        screenId = String.valueOf(lastScreenId);
        this.seats = seats;
        this.shows = shows;
        this.theatre = theatre;
    }

    public Screen(Theatre theatre) {
        lastScreenId = lastScreenId+1;
        screenId = String.valueOf(lastScreenId);
        this.seats = new HashMap<String, Seat>();
        this.shows = new HashMap<String, Show>();
        this.theatre = theatre;
    }

    public HashMap<String, Seat> getSeats() {
        return seats;
    }

    public String getScreenId() {
        return screenId;
    }

    public void addSeat(Seat seat) {
        seats.put(seat.getSeatId(), seat);
    }
    public void addShow(Show show) {
        shows.put(show.getShowId(), show);
    }
}
