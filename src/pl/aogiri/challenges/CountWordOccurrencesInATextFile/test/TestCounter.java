package pl.aogiri.challenges.CountWordOccurrencesInATextFile.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.aogiri.challenges.CountWordOccurrencesInATextFile.Counter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class TestCounter {

    @Test
    public void WordsInFile() throws IOException {
        File file = new File("test.txt");

        final int excepted = 14;

        final int actual = Counter.countWords(file);

        Assertions.assertEquals(excepted, actual);
    }

    @Test
    public void WordInFile() throws IOException {
        File file = new File("test.txt");
        final int excepted = 2;

        final int actual = Counter.countWord(file, "fearless");

        Assertions.assertEquals(excepted, actual);
    }

    @Test
    public void EachWordOfArrayInFile() throws IOException {
        File file = new File("test.txt");
        final HashMap<String, Integer> excepted = new LinkedHashMap<>();
        excepted.put("fearless", 2);
        excepted.put("dad", 0);

        final String[] x = {"fearless", "dad"};
        final HashMap<String, Integer> actual = Counter.countWords(file, x);

        Assertions.assertEquals(excepted, actual);
    }

    @Test
    public void CountEachWordInFile() throws IOException {
        File file = new File("test.txt");
        final HashMap<String, Integer> excepted = new LinkedHashMap<>();
        excepted.put("nail", 1);
        excepted.put("war", 1);
        excepted.put("fearless", 2);
        excepted.put("chilly", 2);
        excepted.put("minor", 1);
        excepted.put("wet", 2);
        excepted.put("strengthen", 1);
        excepted.put("sink", 1);
        excepted.put("perfect", 1);
        excepted.put("early", 1);
        excepted.put("test", 1);

        final HashMap<String, Integer> actual = Counter.countEachWord(file);

        Assertions.assertEquals(excepted, actual);
    }
}
