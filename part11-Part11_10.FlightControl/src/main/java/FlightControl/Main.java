package FlightControl;

import java.util.Scanner;

import FlightControl.controls.AssetControl;
import FlightControl.controls.UserInterface;

public class Main {

    public static void main(String[] args) {
        // Write the main program here. It is useful to create some classes of your own.
        Scanner scanner = new Scanner(System.in);
        AssetControl flightControl = new AssetControl();
        UserInterface ui = new UserInterface(scanner, flightControl);
        ui.start();
    }
}