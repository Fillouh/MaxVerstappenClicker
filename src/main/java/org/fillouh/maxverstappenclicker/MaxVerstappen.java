package org.fillouh.maxverstappenclicker;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.random.RandomGenerator;

public class MaxVerstappen extends ImageView {
    double x1,y1,x2,y2;
    private RandomGenerator rnd=RandomGenerator.getDefault();

    public MaxVerstappen() {
        this.setImage(new Image("org/fillouh/maxverstappenclicker/assets/max2.png"));
        x1=rnd.nextDouble(0,400);
        x2= rnd.nextDouble(0,400);
        y1=rnd.nextDouble(0,250);
        y2= rnd.nextDouble(0,400);
        this.setLayoutX(x2-x1);
        this.setLayoutY(y2-y1);
    }
}
