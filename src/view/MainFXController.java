package view;

import javafx.fxml.FXML;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import model.HraciPlocha;

import java.util.LinkedList;
import java.util.Random;

public class MainFXController {

    @FXML
    Canvas platno;

    @FXML
    AnchorPane plocha;

    LinkedList<Circle> figZ = new LinkedList<>();


    /*public void figurky(){
        for(int x = 0; x < 4; x++){
            for(int y = 0; y < 200; y += 50){
                Circle kol = new Circle();
                kol.setFill(Color.YELLOW);
                kol.setRadius(30);
                kol.setLayoutX(30);
                kol.setLayoutY(30+y);
                figZ.add(kol);
                plocha.getChildren().add(kol);
            }
        }
    }*/


    public void kresli(){
        platno.getGraphicsContext2D().fillRect(100,100,100,20);
    }

    public void hriste(){
        int b = 50;
        platno.getGraphicsContext2D().setFill(Color.GRAY);
        for(int d=0;d<40;d++){
            platno.getGraphicsContext2D().fillOval(HraciPlocha.indexPole(d)[0],HraciPlocha.indexPole(d)[1],30,30);
        }



        //domecky
        platno.getGraphicsContext2D().setFill(Color.BLUE); //leva
        platno.getGraphicsContext2D().fillOval(19,215,30,30);
        for(int i = 69; i < 250; i += 50){
            platno.getGraphicsContext2D().fillOval(i, 265, 30, 30);
        }


        platno.getGraphicsContext2D().setFill(Color.RED); //prava
        platno.getGraphicsContext2D().fillOval(519,316,30,30);
        for(int i = 319; i < 500; i += 50){
            platno.getGraphicsContext2D().fillOval(i, 265, 30, 30);
        }

        platno.getGraphicsContext2D().setFill(Color.GREEN); //horni
        platno.getGraphicsContext2D().fillOval(319,15,30,30);
        for(int i = 65; i < 250; i += 50){
            platno.getGraphicsContext2D().fillOval(268, i, 30, 30);
        }

        platno.getGraphicsContext2D().setFill(Color.YELLOW); //dolni
        platno.getGraphicsContext2D().fillOval(219,515,30,30);
        for(int i = 315; i < 500; i += 50){
            platno.getGraphicsContext2D().fillOval(268, i, 30, 30);
        }
    }


    public void dsc(){
        platno.getGraphicsContext2D().setFill(Color.PURPLE);
        for(int d=0;d<40;d++){
            platno.getGraphicsContext2D().fillOval(HraciPlocha.indexPole(d)[0],HraciPlocha.indexPole(d)[1],30,30);
        }
    }

    public void hod(){
        int a = HraciPlocha.hod();
        String b = Integer.toString(a);
        platno.getGraphicsContext2D().setFill(Color.LIGHTPINK);
        platno.getGraphicsContext2D().fillRect(263,258,40,40);
        platno.getGraphicsContext2D().setFont(Font.font(40));
        platno.getGraphicsContext2D().setFill(Color.BLACK);
        platno.getGraphicsContext2D().fillText(b,273,297);
    }


    /*public void hod() {
        int a = app.Main.hod();
        String b = Integer.toString(a);
        platno.getGraphicsContext2D().setFill(Color.GRAY);
        platno.getGraphicsContext2D().fillRect(200,200,10,10);
        platno.getGraphicsContext2D().fillText(b,200, 200);
    }*/
}