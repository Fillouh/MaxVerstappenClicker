module org.fillouh.maxverstappenclicker {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.desktop;


    opens org.fillouh.maxverstappenclicker to javafx.fxml;
    exports org.fillouh.maxverstappenclicker;
}