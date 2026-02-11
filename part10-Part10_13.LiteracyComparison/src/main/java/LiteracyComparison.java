
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LiteracyComparison {
    
    public static void main(String[] args) {

        List<Statistics> stats = new ArrayList<>();

        // try (BufferedReader read = new BufferedReader(new FileReader("literacy.csv"))) {
        //     String line;
        
        //     while ((line = read.readLine())!= null) {
                
        //         String[] parts = line.split(",");
        //         String country = parts[3].trim();
        //         String year = parts[4].trim();
        //         String sex = parts[2].trim().replace(" (%)", "");
        //         double literacyRate = Double.valueOf(parts[5].trim());

        //         Statistics stat = new Statistics(country, year, sex, literacyRate);
        //         stats.add(stat);
        //     }
        // } 
        // catch (Exception e){
        //     System.out.println(e);
        // }

        // stats.stream().sorted((s1, s2) -> Double.compare(s1.getLiteracyRate(), s2.getLiteracyRate()))
        //             .forEach(System.out::println);

        try (Stream<String> lines = Files.lines(Paths.get("literacy.csv"))) {    
           
            stats = (lines.map(row -> row.split(","))
                        .map(parts-> new Statistics(
                            parts[3].trim(), 
                            parts[4].trim(), 
                            parts[2].trim().replace(" (%)", ""), 
                            Double.valueOf(parts[5].trim()))))
                        .sorted(Comparator.comparingDouble(Statistics::getLiteracyRate))
                        .collect(Collectors.toList());
        } catch (Exception e){
            System.out.println(e);
        }
        
        stats.forEach(System.out::println);
    }
}

