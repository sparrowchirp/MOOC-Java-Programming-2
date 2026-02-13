package FlightControl.controls;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import FlightControl.domain.Flight;
import FlightControl.domain.Place;
import FlightControl.domain.Plane;

public class AssetControl {
    private HashMap<String, Plane> planes;
    private HashMap<String, Place> places;
    private ArrayList<Flight> flights;

    public AssetControl() {
        this.planes = new HashMap<>();
        this.places = new HashMap<>();
        this.flights = new ArrayList<>();
    }

    public Collection<Plane> getPlanes() {
        return this.planes.values();
    }

    public List<Flight> getFlights() {
        return Collections.unmodifiableList(flights);
    }

    public void addPlane(String id, int capacity) {
        Plane plane = new Plane(id, capacity);
        this.planes.put(id, plane);
    }

    public void addFlight(String planeID, String departureID, String destinationID) {
        Plane plane = this.planes.get(planeID);
        if (plane == null) {
            throw new IllegalArgumentException("Plane not found: " + planeID);
        }

        Place departure = this.places.computeIfAbsent(departureID, Place::new);
        Place destination = this.places.computeIfAbsent(destinationID, Place::new);

        Flight flight = new Flight(plane, departure, destination);
        this.flights.add(flight);
    }

    public String airplaneDetails(String id) {
        Plane plane = this.planes.get(null);

        if (plane == null) {
            return "No such plane is found";
        }
        return plane.toString();
    }

    
}
