package world.ucode.Controlers;

import javafx.fxml.FXML;
import world.ucode.GameProcess.Main;

public class MainController {
    @FXML
    public void onClicked() throws Exception {
       Main main = new Main();
       Main.state = Main.States.NewPet;
       main.start(Main.currentStage);
    }
    public void exit() {
        System.exit(1);
    }
}
