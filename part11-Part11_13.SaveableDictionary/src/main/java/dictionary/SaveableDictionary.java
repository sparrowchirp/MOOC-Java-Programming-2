package dictionary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SaveableDictionary {

    private Map<String, String> words;
    private String file;

    public SaveableDictionary() {
        this.words = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this();
        this.file = file;
    }

    public void add(String words, String translation) {
        if (this.words.containsKey(words)) return;
        this.words.put(words, translation);
        this.words.put(translation, words);
    }

    public String translate(String word) {
            return this.words.get(word);
    }

    public void delete(String word) {
        String removed = this.words.remove(word);
        if (removed != null) {
            this.words.remove(removed);
        }
    }

    public boolean load() {
        try(BufferedReader reader = Files.newBufferedReader(Path.of(this.file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    this.add( parts[0],  parts[1]);
                }
            }
        } catch(IOException e) {
            System.out.println("File not found");
            return false;
        }
        return true;
    }

    public boolean save() {
        Set<String> saved = new HashSet<>();
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(this.file))) {
            for (Map.Entry<String,String> temp : this.words.entrySet()) {

                String word = temp.getKey();
                String translation = temp.getValue();

                if (saved.contains(word)) continue;
                saved.add(translation);
                saved.add(word);
                
                writer.write(word + ":" + translation + "\n");
            }
            return true;
        } catch (IOException e) {
            System.out.println("Can not create file");
            e.printStackTrace();
            return false;
        }
    }
    
}
