package world.ucode.view;

import javafx.animation.AnimationTimer;
import world.ucode.Controlers.GameController;

public class Timer extends AnimationTimer {
    @Override
    public void handle(long l) {
        try {
            doHandle();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void doHandle() throws Exception {
        GameController game = Main.loader3.getController();
        if (game.thirst <= 0 || game.health <= 0 || game.cleanless <= 0 || game.happiness <= 0 || game.hunger <= 0) {
            stop();
            Main main = new Main();
            Main.state = Main.States.EndGame;
            main.start(Main.currentStage);
        }
        else {
            game.hunger -= 0.0005;
            game.health -= 0.0005;
            game.cleanless -= 0.0002;
            game.happiness -= 0.0002;
            game.thirst -= 0.0002;
            game.setProgressBars(game.hunger, game.cleanless, game.health, game.thirst, game.happiness);
        }
    }
}
