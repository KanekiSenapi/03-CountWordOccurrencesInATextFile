package pl.aogiri.challenges.CountWordOccurrencesInATextFile;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Counter {

    private static BufferedReader br;

    public Counter() {
    }

    public static int countWords(File file) throws IOException {

        readFile(file);

        String line;
        int count = 0;

        while ((line = br.readLine()) != null)
            count += line.split(" ").length;
        return count;
    }

    public static int countWord(File file, String word) throws IOException {
        readFile(file);

        String line;
        int count = 0;

        while ((line = br.readLine()) != null)
            for (String x : line.split(" ")) {
                if (x.equalsIgnoreCase(word))
                    count++;
            }
        return count;
    }

    public static HashMap<String, Integer> countWords(File file, String[] words) throws IOException {
        readFile(file);

        String line;
        HashMap<String, Integer> counter = new LinkedHashMap<>();
        for (String word : words) {
            counter.put(word, 0);
        }
        while ((line = br.readLine()) != null)
            for (String x : line.split(" "))
                for (String word : words)
                    if (x.equalsIgnoreCase(word)) {
                        word = word.toLowerCase();
                        counter.replace(word, (counter.get(word) + 1));
                    }

        return counter;
    }

    public static HashMap<String, Integer> countEachWord(File file) throws IOException {
        readFile(file);

        String line;
        HashMap<String, Integer> counter = new LinkedHashMap<>();
        Integer exist;
        while ((line = br.readLine()) != null)
            for (String word : line.split(" ")) {
                word = word.toLowerCase();
                if ((exist = counter.putIfAbsent(word, 1)) != null)
                    counter.replace(word, (exist + 1));
            }


        return counter;
    }

    private static void readFile(File file) {
        try {
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }


}
