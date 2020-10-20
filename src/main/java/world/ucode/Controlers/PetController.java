package world.ucode.Controlers;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import world.ucode.module.DB;
import world.ucode.module.Main;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PetController implements Initializable {
    @FXML
    public ImageView imgView;
    @FXML
    public Button nextButton;
    @FXML
    public TextField name;

    public final Image[] imgs = new Image[3];
    private int index = 0;

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
        save();
    }
    public void save() throws SQLException, ClassNotFoundException {
        String petName = name.getText();
        DB data = new DB();
        data.getConnection(petName);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        imgs[0] = new Image("/images/pet1.png");
        imgs[1] = new Image("/images/pet2.png");
        imgs[2] = new Image("/images/pet3.png");
    }
}
