package FlightControl.domain;

public class Place {
    private String id;
    
    public String getId() {
        return id;
    }

    public Place(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Place)) return false;

        Place other = (Place) obj;
        return id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
