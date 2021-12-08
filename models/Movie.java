package MovieTicketBookingSystem.models;

public class Movie {
    private String movieId;
    private static int lastMovieId = 0;
    private String movieName;
    String production;

    public Movie(String movieName) {
        lastMovieId = lastMovieId + 1;
        this.movieId = String.valueOf(lastMovieId);
        this.movieName = movieName;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getProduction() {
        return production;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setProduction(String production) {
        this.production = production;
    }
}
