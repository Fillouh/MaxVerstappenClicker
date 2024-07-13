package org.fillouh.maxverstappenclicker;

import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.EventListener;

public class GameLoop implements Runnable {

    private volatile boolean running = true;
    private final int targetFps = 60;
    private final long targetTime = 1000000000 / targetFps;
    private MainController mainController;

    public GameLoop(MainController mainController) {
        this.mainController = mainController;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        long startTime;
        long elapsedTime;
        long waitTime;
        Media audio=new Media(getClass().getResource("assets/audio2.mp3").toExternalForm());
        MediaPlayer mediaPlayer=new MediaPlayer(audio);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        AnchorPane mainPane=mainController.mainPane;

        mainPane.getScene().setOnKeyPressed(event -> {
            if (event.getCode().toString().equalsIgnoreCase("Q")) {
                setRunning(false);
                mainController.quit(this);
                mediaPlayer.stop();
            }
        });


        while (running) {
            startTime = System.nanoTime();
            mediaPlayer.play();
            elapsedTime = System.nanoTime() - startTime;
            waitTime = targetTime - elapsedTime / 1000000;



            if (waitTime > 0) {
                try {
                    Thread.sleep(waitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

