package world.ucode.Controlers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import world.ucode.GameProcess.Main;
import world.ucode.Interfaces.IPet;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable, IPet {
    public double health = 0.8;
    public double happiness = 0.7;
    public double hunger = 0.5;
    public double thirst = 0.5;
    public double cleanless = 0.9;

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

    @FXML
    public void setImage(Image image) {
        img.setImage(image);
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
        PetController game = Main.loader2.getController();
        game.timer.stop();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        healthBar.setProgress(health);
        happinessBar.setProgress(happiness);
        hungerBar.setProgress(hunger);
        thirstBar.setProgress(thirst);
        cleanlessBar.setProgress(cleanless);
    }
}
