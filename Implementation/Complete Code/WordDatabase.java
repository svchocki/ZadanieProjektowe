package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordDatabase {
    private List<String> words;

    public WordDatabase() {
        words = new ArrayList<>();
        loadWords();
    }

    private void loadWords() {
        words.add("komputer");
        words.add("zamek");
        words.add("lampa");
        words.add("kontroler");
        words.add("ksiazka");
        words.add("algorytm");
        words.add("technologia");
        words.add("kontynent");
        words.add("telewizor");
        words.add("nauka");
    }

    public String getRandomWord() {
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }

    public void addWord(String word) {
        words.add(word);
    }
}
