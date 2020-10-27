package world.ucode.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private Parent root;
    public static Stage currentStage;
    public static enum States {
        StartGame,
        NewPet,
        Game,
        EndGame
    };
    public static FXMLLoader loader;

    public static FXMLLoader loader2;
    public static FXMLLoader loader3;
    public static FXMLLoader loader4;

    public static States state = States.StartGame;

    @Override
    public void start(Stage primaryStage) throws Exception {
        switch (state) {
            case StartGame:
                loader = new FXMLLoader(getClass().getResource("/fxml/start.fxml"));
                root = loader.load();
                break;
            case NewPet:
                loader2 = new FXMLLoader(getClass().getResource("/fxml/newPet.fxml"));
                root = loader2.load();
                break;
            case Game:
                loader3 = new FXMLLoader(getClass().getResource("/fxml/game.fxml"));
                root = loader3.load();
                break;
            case EndGame:
                loader4 = new FXMLLoader(getClass().getResource("/fxml/endGame.fxml"));
                root = loader4.load();
                break;
            default:
                return;
        }
        //root = loader.load();
        currentStage = primaryStage;
        currentStage.setScene(new Scene(root));
        currentStage.setMinWidth(540);
        currentStage.setMinHeight(300);
        currentStage.setResizable(true);
        currentStage.setTitle("Tamagotchi");
        currentStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
