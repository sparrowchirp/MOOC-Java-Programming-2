
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReadingFilesPerLine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test the method here
        String name = "file.txt";
        read(name);


    }

    public static List<String> read(String name) {
        List<String> read = new ArrayList<>();

        try {
            Files.lines(Paths.get(name)).forEach(row -> read.add(row));
        } catch (Exception e) {
            System.out.println(e);
        }
        return read;
    }

}
