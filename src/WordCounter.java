import collections.map.Entry;
import collections.map.HashMap;
import collections.map.Map;
import collections.set.Set;
import collections.set.SimpleSet;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WordCounter {

    private static Set<String> stopWords;

    static {
        stopWords = new SimpleSet<>(130);

        // Stop words from https://gist.github.com/sebleier/554280
        Scanner scanner = scanFile("data/stopwords.txt");

        while (scanner.hasNext()) {
            stopWords.add(scanner.next());
        }
    }

    private Map<String, Integer> wordCount;

    /**
     * Create a scanner from a URL.
     *
     * @param url
     * @return
     */
    private static Scanner scanUrl(String url) {
        try {
            URL theUrl = new URL(url);
            HttpURLConnection http = (HttpURLConnection) theUrl.openConnection();
            return new Scanner(http.getInputStream());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Create a scanner from a file.
     *
     * @param fileName
     * @return
     */
    private static Scanner scanFile(String fileName) {
        try {
            return new Scanner(new FileReader(fileName));
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Create a word counter.
     */
    public WordCounter() {
        wordCount = new HashMap<>();
    }

    /**
     * Return all words counted, not including stop words
     *
     * @return
     */
    public Set<String> getWords() {
        return wordCount.keys();
    }

    /**
     * Return the number of occurrences of word.
     *
     * @param word
     * @return
     */
    public int getCountOf(String word) {
        word = word.toLowerCase();
        return wordCount.containsKey(word) ? wordCount.get(word) : 0;
    }

    /**
     * Read the content of the file and count the words. Removes punctuation and does not count stop words.
     *
     * @param fileName
     */
    public void countWordsInFile(String fileName) {
        // TODO
        Scanner scanner = scanFile(fileName);
        scanner.useDelimiter("[\\p{Punct}\\s]+");
        // Map words to their counts
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
            // Only accept words that are not stop words
            if (!stopWords.contains(word)) {

                // If encounter word that is already in map, override it with count + 1
                if (wordCount.containsKey(word)) {
                    wordCount.put(word, wordCount.get(word) + 1);
                }
                else {
                    // If encounter word that is not in map, add it to map with count 1
                    wordCount.put(word, 1);
                }
            }
        }
        
        // Close the scanner
        scanner.close();
    }

    /**
     * Read the content of the URL and count the words. Removes punctuation and does not count stop words.
     *
     * @param url
     */
    public void countWordsInUrl(String url) {
        // TODO
    }

    /**
     * Return the words that appear n times or more in the count.
     *
     * @param n
     * @return
     */
    public Set<String> popularWords(int n) {
        // TODO

        return null;
    }

}
