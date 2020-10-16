package world.ucode.Controlers;

import javafx.animation.AnimationTimer;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import world.ucode.GameProcess.Main;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PetController implements Initializable {
    @FXML
    public ImageView imgView;
    @FXML
    public Button nextButton;

    public final Image[] imgs = new Image[3];
    private int index = 0;
    private BooleanProperty running = new SimpleBooleanProperty();
    private DoubleProperty time = new SimpleDoubleProperty();


    public PetController() throws IOException {
        imgs[0] = new Image("/images/pet1.png");
        imgs[1] = new Image("/images/pet2.png");
        imgs[2] = new Image("/images/pet3.png");
    }
    @FXML
    public void prevClicked() {
        if (index != 0) {
            index = index - 1;
        }
        else {
            index = 2;
        }
        imgView.setImage(imgs[index]);
    }
    @FXML
    public void nextClicked() {
        if (index != 2) {
            index = index + 1;
        }
        else {
            index = 0;
        }
        imgView.setImage(imgs[index]);
    }
    @FXML
    public void next() throws Exception {
        Main main = new Main();
        Main.state = Main.States.Game;
        main.start(Main.currentStage);
        GameController game = Main.loader3.getController();
        game.setImage(imgs[index]);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
