
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BooksFromFile {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here

    }

    // public static List<Book> readBooks(String file) {
    //     List<Book> books = new ArrayList<>();

    //     try {
    //         Files.lines(Paths.get(file))
    //             .map(row -> row.split(","))
    //             .filter(parts -> parts.length > 3)
    //             .map(parts -> new Book(parts[0], Integer.valueOf(parts[1]), Integer.valueOf(parts[2]), parts[3]))
    //             .forEach(book -> books.add(book));
    //     } catch (Exception e) {
    //         System.out.println(e);
    //     }
    //     return books;
    // }

    public static List<Book> readBooks(String file) {
        try (Stream<String> lines = Files.lines(Paths.get(file))) {
            return lines.map(row -> row.split(","))
                        .filter(parts -> parts.length > 3)
                        .map(parts -> new Book(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), parts[3]))
                        .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println(e);
            return new ArrayList<>();
        }
    }
    

}
