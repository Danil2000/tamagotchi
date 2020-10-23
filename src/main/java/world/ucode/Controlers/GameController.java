package world.ucode.Controlers;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.WindowEvent;
import world.ucode.module.DB;
import world.ucode.module.Main;
import world.ucode.module.Timer;
import world.ucode.Interfaces.IPet;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class GameController implements Initializable, IPet {
    public static double health = 0.8;
    public static double happiness = 0.7;
    public static double hunger = 0.5;
    public static double thirst = 0.5;
    public static double cleanless = 0.9;
    private DB db = new DB();

    private AnimationTimer timer = new Timer();

    @FXML
    public ImageView img;
    @FXML
    public ProgressBar healthBar;
    @FXML
    public ProgressBar happinessBar;
    @FXML
    public ProgressBar hungerBar;
    @FXML
    public ProgressBar thirstBar;
    @FXML
    public ProgressBar cleanlessBar;

    private String petName;

    @FXML
    public void setImage(Image image, String name) {
        img.setImage(image);
        this.petName = name;
        Main.currentStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                try {
                    db.updateTable(petName);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }

    @FXML
    @Override
    public void play() {
        happiness += 0.02;
        happinessBar.setProgress(happiness);
    }
    @FXML
    @Override
    public void feed() {
        hunger += 0.06;
        hungerBar.setProgress(hunger);
    }
    @FXML
    @Override
    public void give_water() {
        thirst += 0.06;
        thirstBar.setProgress(thirst);
    }

    @FXML
    @Override
    public void give_medicine() {
        health += 0.06;
        if (health >= 1) {
            return;
        }
        healthBar.setProgress(health);
    }

    @FXML
    @Override
    public void clean_up() {
        cleanless += 0.03;
        cleanlessBar.setProgress(cleanless);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        healthBar.setProgress(health);
        happinessBar.setProgress(happiness);
        hungerBar.setProgress(hunger);
        thirstBar.setProgress(thirst);
        cleanlessBar.setProgress(cleanless);
        timer.start();
    }
}
