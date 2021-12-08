package MovieTicketBookingSystem.models;

public class Show {
    private String showId;
    private static int lastShowId = 0;
    private int startTime;
    private Long duration;
    private Movie movie;
    Screen screen;

    public Show(int startTime, Long duration, Movie movie, Screen screen) {
        lastShowId = lastShowId+1;
        this.showId = String.valueOf(lastShowId);
        this.startTime = startTime;
        this.duration = duration;
        this.movie = movie;
        this.screen = screen;
        screen.addShow(this);
    }

    public String getShowId() {
        return showId;
    }

    public static int getLastShowId() {
        return lastShowId;
    }

    public int getStartTime() {
        return startTime;
    }

    public Long getDuration() {
        return duration;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }
}
