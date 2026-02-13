package FlightControl.domain;

public class Flight {
    private Plane plane;
    private Place depature;
    private Place destination;
    
    public Flight(Plane plane, Place depature, Place destination) {
        this.plane = plane;
        this.depature = depature;
        this.destination = destination;
    }

    public String toString() {
        return this.plane.getId() + " (" + this.plane.getCapacity() +  " capacity)" + 
                " (" + this.depature.getId() + "-" + this.destination.getId() + ")";
    }
    
}
