import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegistry {

    private HashMap<LicensePlate, String> registry;

    public VehicleRegistry() {
        this.registry = new HashMap<>();
    }

    public boolean add (LicensePlate licensePlate, String owner) {
        if (this.registry.containsKey(licensePlate)) {
            return false;
        }
        this.registry.put(licensePlate, owner);
        return true;
    }

    public String get(LicensePlate licensePlate) {
        return this.registry.get(licensePlate);
    }

    public boolean remove(LicensePlate licensePlate) {
        if (this.registry.containsKey(licensePlate)) {
            this.registry.remove(licensePlate);
            return true;
        }
        return false;
    }

    public void printLicensePlates() {
        for(LicensePlate temp : registry.keySet()) {
            System.out.println(temp);
        }
    }

    public void printOwners() {
        ArrayList<String> owners = new ArrayList<>();

        for(String temp : registry.values()) {
            if (owners.contains(temp)) {
                continue;
            }
            owners.add(temp);
            System.out.println(temp);
        }
    }
    
}
