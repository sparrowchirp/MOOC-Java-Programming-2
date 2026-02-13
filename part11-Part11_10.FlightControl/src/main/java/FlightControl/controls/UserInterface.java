package FlightControl.controls;

import java.util.Scanner;

import FlightControl.domain.Flight;
import FlightControl.domain.Plane;

public class UserInterface {
    private AssetControl assets;
    private Scanner scanner;

    public UserInterface(Scanner scanner, AssetControl assets) {
        this.scanner = new Scanner(System.in);
        this.assets = new AssetControl();
    }

    public void start() {
        startAssetControl();
        startFlightControl();
    }

    private void startAssetControl() {

        System.out.println("Airport Asset Control");
        System.out.println("--------------------");
        System.out.println();

        while(true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Add an airplane");
            System.out.println("[2] Add a flight");
            System.out.println("[x] Exit Airport Asset Control");

            System.out.print("> ");
            String command = scanner.nextLine();

            if(command.equals("x")) {
                break;
            } else if (command.equals("1")) {
                addPlane();
            } else if (command.equals("2")) {
                addFlight();
            } else {
                System.out.println("Unknown command");
            }
        }
    }

    private void addPlane() {
        System.out.print("Give the airplane id: ");
        String id = scanner.nextLine().toUpperCase();
        System.out.print("Give the airplane capacity: ");
        int capacity = Integer.valueOf(scanner.nextLine());

        this.assets.addPlane(id, capacity);
    }

    private void addFlight() {
        System.out.print("Give the airplane id: ");
        String id = scanner.nextLine().toUpperCase();
        System.out.print("Give the departure airport id: ");
        String depatureID = scanner.nextLine().toUpperCase();
        System.out.print("Give the target airport id: ");
        String destinationID = scanner.nextLine().toUpperCase();

        this.assets.addFlight(id, depatureID, destinationID);
    }

    private void startFlightControl() {
        System.out.println("Flight Control");
        System.out.println("------------");
        System.out.println();

        while(true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Print airplanes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print airplane details");
            System.out.println("[x] Quit");

            System.out.print("> ");
            String command = scanner.nextLine();

            if(command.equals("x")) {
                break;
            } else if (command.equals("1")) {
                printPlanes();
            } else if (command.equals("2")) {
                printFlights();
            } else if (command.equals("3")) {
                printAirplaneDetails();
            } else {
                System.out.println("Unknown command");
            }
        }
    }

    public void printFlights() {
        for (Flight temp : this.assets.getFlights()) {
            System.out.println(temp);
        }
    }

    public void printPlanes() {
        for (Plane temp : this.assets.getPlanes()) {
            System.out.println(temp);
        }
    }

    public void printAirplaneDetails() {
        System.out.print("Give the airplane id: ");
        String id = scanner.nextLine();
        System.out.println(this.assets.airplaneDetails(id));
        System.out.println();

    }
}
