BorderPane mainLayout = new BorderPane();
VBox topSection = new VBox();
Label wordLabel = new Label();
TextField guessInput = new TextField();
Button guessButton = new Button("Guess");
Label attemptsLabel = new Label();
Button newGameButton = new Button("New Game");
Label statsLabel = new Label("Statistics");

topSection.getChildren().addAll(wordLabel, guessInput, guessButton, attemptsLabel, newGameButton, statsLabel);
mainLayout.setTop(topSection);
