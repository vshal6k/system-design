package mycarrentalsystem.searchmanagement;

import java.util.HashMap;

import mycarrentalsystem.locationmanagement.Location;

public class SearchUtility {
    HashMap<Integer, Location> locations;

    public Location getLocation(int locationId) {
        if (!locations.containsKey(locationId))
            return null;
        else
            return locations.get(locationId);
    }

}
