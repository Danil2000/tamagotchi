package world.ucode.Controlers;

import javafx.fxml.FXML;
import world.ucode.module.Main;

public class EndController {
    @FXML
    public void newGame() throws Exception {
        Main main = new Main();
        Main.state = Main.States.NewPet;
        main.start(Main.currentStage);
    }
    public void exit() {
        System.exit(0);
    }
}