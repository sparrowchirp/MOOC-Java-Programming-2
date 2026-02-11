
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Book> books = new ArrayList<>();

            while (true) {
                System.out.print("Input the name of the book, empty stops: ");
                String input = scanner.nextLine();
                
                if (input.isEmpty()) {
                    break;
                }

                System.out.print("Input the age recommendation: ");
                int recommendedAge = Integer.valueOf(scanner.nextLine());
                books.add(new Book(input, recommendedAge));
            }
            System.out.println(books.size() + " books in total.");

            Comparator<Book> comparator = Comparator.comparing(Book::getRecommendedAge)
            .thenComparing(Book::getName);
            Collections.sort(books, comparator);
            System.out.println("Books:");
            books.stream().forEach(System.out::println);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    
    }

}
