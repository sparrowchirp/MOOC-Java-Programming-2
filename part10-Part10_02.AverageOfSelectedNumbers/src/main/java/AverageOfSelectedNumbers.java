
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // toteuta ohjelmasi tänne
        ArrayList<String> numbers = new ArrayList<>();
        
        while(true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            numbers.add(input);
        }

        double average = 0.0;
        System.out.println("Print average of positive or negative answers? p/n");
        String command = scanner.nextLine();
        if (command.equals("p")) {
            average = numbers.stream()
            .mapToInt(Integer::valueOf)
            .filter(n -> n > 0)
            .average()
            .orElse(0.0);
            System.out.println("Average of the positive numbers: " + average);

        } else if (command.equals("n")) {
            average = numbers.stream()
            .mapToInt(Integer::valueOf)
            .filter(n -> n < 0)
            .average()
            .orElse(0.0);
            System.out.println("Average of the negative numbers: " + average);
        }

    }
}
