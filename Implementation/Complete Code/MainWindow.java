package gui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import model.Game;
import util.Statistics;

public class MainWindow {
    private BorderPane mainLayout;
    private Label wordLabel;
    private TextField guessInput;
    private Label attemptsLabel;
    private Label statsLabel;
    private Game game;
    private Statistics statistics;

    public MainWindow() {
        game = new Game();
        statistics = new Statistics();
        mainLayout = new BorderPane();
        initializeUI();
        startNewGame();
    }

    private void initializeUI() {
        VBox topSection = new VBox();
        wordLabel = new Label();
        guessInput = new TextField();
        Button guessButton = new Button("Zgadnij");
        attemptsLabel = new Label();
        Button newGameButton = new Button("Nowa Gra");
        statsLabel = new Label("Statystyki");

        guessButton.setOnAction(e -> handleGuess());
        newGameButton.setOnAction(e -> startNewGame());

        topSection.getChildren().addAll(wordLabel, guessInput, guessButton, attemptsLabel, newGameButton, statsLabel);
        mainLayout.setTop(topSection);
    }

    private void handleGuess() {
        String input = guessInput.getText();
        if (input.length() == 1) {
            char guessedLetter = input.charAt(0);
            boolean correct = game.guessLetter(guessedLetter);
            updateUI();
            if (game.isGameOver()) {
                if (correct) {
                    statistics.recordWin();
                } else {
                    statistics.recordLoss();
                }
                statsLabel.setText(statistics.getStatistics());
            }
        }
        guessInput.clear();
    }

    private void startNewGame() {
        game.startNewGame();
        updateUI();
    }

    private void updateUI() {
        wordLabel.setText(game.getCurrentWordStatus());
        attemptsLabel.setText("Pozostałe próby: " + game.getAttemptsLeft());
    }

    public BorderPane getMainLayout() {
        return mainLayout;
    }
}
