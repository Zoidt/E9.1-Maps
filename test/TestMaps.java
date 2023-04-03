import collections.set.Set;
import collections.set.SimpleSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMaps {

    @Test
    public void testPhoneMnemonics() {
        assertEquals("(366) 227-7889", Mnemonics.toNumber("(foo) bar-quuz"));
    }

    @Test
    public void testPhoneMnemonicsOptional() {
        assertEquals("mapsareawesome", Mnemonics.fromDigits("6 2 7 7777 2 777 33 2 9 33 7777 666 6 33"));
    }

    @Test
    public void testWordCounterFile() {
        WordCounter wordCounter = new WordCounter();
        wordCounter.countWordsInFile("data/welcome.txt");

        assertEquals(5, wordCounter.getCountOf("programming"));
        assertEquals(1, wordCounter.getCountOf("maps"));
        assertEquals(0, wordCounter.getCountOf("foo"));
        assertEquals(5, wordCounter.getCountOf("Programming"));
        assertEquals(5, wordCounter.getCountOf("PrOgRaMming"));
    }

    @Test
    public void testWordPopularFileOptional() {
        WordCounter wordCounter = new WordCounter();
        wordCounter.countWordsInFile("data/welcome.txt");

        Set<String> popularWords = wordCounter.popularWords(2);
        System.out.println(popularWords);

        assertTrue(popularWords.contains("programming"));
        assertTrue(popularWords.contains("data"));
        assertTrue(popularWords.contains("algorithms"));

        assertFalse(popularWords.contains("java"));
        assertFalse(popularWords.contains("gained"));
    }

    @Test
    public void testWordCounterURL() {
        WordCounter wordCounter = new WordCounter();
        wordCounter.countWordsInUrl("http://classics.mit.edu/Plato/republic.mb.txt");
        throw new RuntimeException("Write the test...");
    }

    @Test
    public void testSetIntersection() {
        Set<String> s1 = new SimpleSet<>("a b c d e f h".split(" "));
        Set<String> s2 = new SimpleSet<>("a c d e g".split(" "));
        Set<String> s3 = new SimpleSet<>("a b d f g".split(" "));

        Set<Set<String>> sets = new SimpleSet<>(new Set[] { s1, s2, s3 });

        Set<String> result = SetUtils.intersection(sets);
        Set<String> expected = new SimpleSet<>("a d".split(" "));

        assertEquals(expected, result);
    }

    //    @Test
    //    public void testSetIntersectionCapacity() {
    //        Set<String> s1 = new SimpleSet<>("a b c d e f h".split(" "));
    //        Set<String> s2 = new SimpleSet<>("a c d e g".split(" "));
    //        Set<String> s3 = new SimpleSet<>("a b d f g".split(" "));
    //
    //        Set<Set<String>> sets = new SimpleSet<>(new Set[] { s1, s2, s3 });
    //
    //        Set<String> result = SetUtils.intersection(sets);
    //
    //        // the set capacity is the maximum number of elements of the input sets
    //        assertEquals(2, ((SimpleSet<String>) result).getCapacity());
    //    }

}
