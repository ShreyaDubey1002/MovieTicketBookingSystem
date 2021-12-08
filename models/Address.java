package MovieTicketBookingSystem.models;

public class Address {
    private String zipcode;
    private static int lastZipcode = 0;
    private String city;
    private String country;
    Address() {
        lastZipcode = lastZipcode+1;
        this.zipcode = String.valueOf(lastZipcode);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
