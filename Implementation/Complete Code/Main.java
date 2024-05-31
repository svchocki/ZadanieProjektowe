package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import gui.MainWindow;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        MainWindow mainWindow = new MainWindow();
        BorderPane root = mainWindow.getMainLayout();
        Scene scene = new Scene(root, 800, 600);
        
        primaryStage.setTitle("Gra w wisielca");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
