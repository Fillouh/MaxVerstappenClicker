package org.fillouh.maxverstappenclicker;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class MainController implements Initializable{
    @FXML
    private Label counterLabel;

    @FXML
    private AnchorPane gamePane;

    @FXML
    private AnchorPane menuPane;

    @FXML
    private Button playButton;

    @FXML
    private Hyperlink credits;

    @FXML
    public AnchorPane mainPane;


    private Integer counter=0;
    private GameLoop gameLoop;
    private List<Node> objects;


    public void play(){
        menuPane.setVisible(false);
        gamePane.setVisible(true);
        gameLoop = new GameLoop(this);
        Thread thread=new Thread(gameLoop);
        thread.start();

    }

    public void draw(){
        counterLabel.toFront();
        MaxVerstappen mv=new MaxVerstappen();
        objects.add(mv);
        gamePane.getChildren().add(mv);
        ++counter;
        counterLabel.setText(counter.toString());

    }

    public void link(){
        String url="https://github.com/fillouh";
        try {
            URI uri = new URI(url);
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(uri);
            } else {
                System.err.println("Desktop non supportato. Non posso aprire il browser.");
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void quit(GameLoop gameLoop){
        gamePane.setVisible(false);
        menuPane.setVisible(true);
        for(Node n: objects){
            gamePane.getChildren().remove(n);
        }
        counter=0;
        counterLabel.setText(counter.toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        objects=new ArrayList<>();

    }
}