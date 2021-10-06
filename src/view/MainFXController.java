package view;

import javafx.fxml.FXML;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;

public class MainFXController {

    @FXML
    Canvas platno;

    public void kresli(){
        platno.getGraphicsContext2D().fillRect(100,100,100,20);
    }

    public void hriste(){
        int b = 50;
        platno.getGraphicsContext2D().setFill(Color.GRAY);
        for(int a = 19; a < 520; a = a + b){
            platno.getGraphicsContext2D().fillOval(a,215,30,30);
            platno.getGraphicsContext2D().fillOval(a,322,30,30);
            platno.getGraphicsContext2D().fillOval(215,a,30,30);
            platno.getGraphicsContext2D().fillOval(322,a,30,30);
        }
        platno.getGraphicsContext2D().fillOval(19,269,30,30);
        platno.getGraphicsContext2D().fillOval(519,269,30,30);
        platno.getGraphicsContext2D().fillOval(269,19,30,30);
        platno.getGraphicsContext2D().fillOval(269,519,30,30);
        platno.getGraphicsContext2D().setFill(Color.LIGHTGRAY);
        platno.getGraphicsContext2D().fillOval(268,214,32,32);
        platno.getGraphicsContext2D().fillOval(268,321,32,32);
        platno.getGraphicsContext2D().fillOval(214,268,32,32);
        platno.getGraphicsContext2D().fillOval(321,268,32,32);
    }

    public void hod(){
        int a = app.Main.hod();
        String b = Integer.toString(a);
        platno.getGraphicsContext2D().setFill(Color.LIGHTPINK);
        platno.getGraphicsContext2D().fillRect(263,258,40,40);
        platno.getGraphicsContext2D().setFont(Font.font(40));
        platno.getGraphicsContext2D().setFill(Color.BLACK);
        platno.getGraphicsContext2D().fillText(b,273,297);
    }
}
