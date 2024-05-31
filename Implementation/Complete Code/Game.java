package model;

import java.util.HashSet;
import java.util.Set;
import java.util.Random;

public class Game {
    private String currentWord;
    private int attemptsLeft;
    private Set<Character> guessedLetters;
    private WordDatabase wordDatabase;

    public Game() {
        wordDatabase = new WordDatabase();
        guessedLetters = new HashSet<>();
    }

    public void startNewGame() {
        currentWord = wordDatabase.getRandomWord();
        attemptsLeft = 6;
        guessedLetters.clear();
    }

    public boolean guessLetter(char letter) {
        guessedLetters.add(letter);
        if (!currentWord.contains(String.valueOf(letter))) {
            attemptsLeft--;
        }
        return currentWord.contains(String.valueOf(letter));
    }

    public boolean isGameOver() {
        return attemptsLeft <= 0 || getCurrentWordStatus().equals(currentWord);
    }

    public String getCurrentWordStatus() {
        StringBuilder status = new StringBuilder();
        for (char letter : currentWord.toCharArray()) {
            if (guessedLetters.contains(letter)) {
                status.append(letter);
            } else {
                status.append("_");
            }
        }
        return status.toString();
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }
}
