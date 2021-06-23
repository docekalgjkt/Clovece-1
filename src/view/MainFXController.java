package view;

import javafx.fxml.FXML;

import javafx.scene.canvas.Canvas;

public class MainFXController {

    @FXML
    Canvas platno;

    public void kresli(){
        platno.getGraphicsContext2D().fillRect(100,100,100,20);
    }
}
