package world.ucode.GameProcess;

import javafx.animation.AnimationTimer;
import world.ucode.Controlers.GameController;

public class Timer extends AnimationTimer {
    @Override
    public void handle(long l) {
        doHandle();
    }
    private void doHandle() {
        GameController game = Main.loader3.getController();
        if (game.thirst <= 0) {
            stop();
            System.exit(0);
        }
        else {
            System.out.println("ok");
            game.hunger -= 0.0005;
            game.health -= 0.0003;
            game.cleanless -= 0.0005;
            game.happiness -= 0.0002;
            game.thirst -= 0.0005;
            game.hungerBar.setProgress(game.hunger);
            game.healthBar.setProgress(game.health);
            game.thirstBar.setProgress(game.thirst);
            game.cleanlessBar.setProgress(game.cleanless);
            game.happinessBar.setProgress(game.happiness);
        }
    }
}
