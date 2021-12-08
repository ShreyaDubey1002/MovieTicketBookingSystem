package MovieTicketBookingSystem.models;

import ParkingLotManagementSystem.models.Address;

import java.util.HashMap;

public class Theatre extends AbstractTheatre {
    String theatreId;
    private static int lastShowId = 0;
    HashMap<String, Screen> screens;
    Address address;

    public Theatre(HashMap<String, Screen> screens, Address address) {
        lastShowId = lastShowId+1;
        theatreId = String.valueOf(lastShowId);
        this.screens = screens;
        this.address = address;
    }

    public Theatre() {
        lastShowId = lastShowId+1;
        theatreId = String.valueOf(lastShowId);
        this.screens = new HashMap<String, Screen>();
        this.address = new Address();
    }

    public void addScreen(Screen screen) {
        screens.put(screen.getScreenId(), screen);
    }
}
