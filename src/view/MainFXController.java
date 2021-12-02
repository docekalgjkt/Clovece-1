package view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import model.Figurka;
import model.HraciPlocha;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MainFXController {

    @FXML
    Canvas platno;

    @FXML
    AnchorPane plocha;

    LinkedList<Circle> figZ = new LinkedList<>();
    LinkedList<Color> barvy = new LinkedList<>();
    Circle fig;


    public void figurky(){
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
    }


    public void kresli(){
        platno.getGraphicsContext2D().fillRect(100,100,100,20);
    }

    public void hriste(){

        barvy.add(Color.BLUE);
        barvy.add(Color.GREEN);
        barvy.add(Color.RED);
        barvy.add(Color.YELLOW);


        int b = 50;
        platno.getGraphicsContext2D().setFill(Color.GRAY);
        for(int d=0;d<40;d++){
            platno.getGraphicsContext2D().fillOval(HraciPlocha.indexPole(d)[0],HraciPlocha.indexPole(d)[1],30,30);
        }
        platno.getGraphicsContext2D().setFill(Color.BLACK); //startovni policka
        platno.getGraphicsContext2D().fillOval(19,215,30,30);
        platno.getGraphicsContext2D().fillOval(519,316,30,30);
        platno.getGraphicsContext2D().fillOval(319,15,30,30);
        platno.getGraphicsContext2D().fillOval(219,515,30,30);


        //domecky
        platno.getGraphicsContext2D().setFill(Color.BLUE); //leva
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


        LinkedList<Color> barvy = new LinkedList<>();
        barvy.add(Color.BLUE);
        barvy.add(Color.GREEN);
        barvy.add(Color.RED);
        barvy.add(Color.YELLOW);


        //FIGURKY
                for(int x = 0; x < 4; x++){
            Circle kol = new Circle();
            kol.setFill(barvy.get(x));
            kol.setRadius(15);
            figZ.add(kol);
            plocha.getChildren().add(kol);
            kol.setLayoutX(HraciPlocha.indexDomecku(x)[0]);
            kol.setLayoutY(HraciPlocha.indexDomecku(x)[1]);
            kol.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    fig = kol;
                    nasadFig();
                }
            });
        }
    }


    public void dsc(){
        platno.getGraphicsContext2D().setFill(Color.PURPLE);
        for(int d=0;d<40;d++){
            platno.getGraphicsContext2D().fillOval(HraciPlocha.indexPole(d)[0],HraciPlocha.indexPole(d)[1],30,30);
        }
    }

    public void nasadFig(){
        if(fig.getFill()==Color.BLUE){
            fig.setLayoutX(HraciPlocha.indexPole(0)[0]);
            fig.setLayoutY(HraciPlocha.indexPole(0)[1]);
        }
        else if(fig.getFill()==Color.GREEN){
            fig.setLayoutX(HraciPlocha.indexPole(10)[0]);
            fig.setLayoutY(HraciPlocha.indexPole(10)[1]);
        }
        else if(fig.getFill()==Color.RED){
            fig.setLayoutX(HraciPlocha.indexPole(20)[0]);
            fig.setLayoutY(HraciPlocha.indexPole(20)[1]);
        }
        else {
            fig.setLayoutX(HraciPlocha.indexPole(30)[0]);
            fig.setLayoutY(HraciPlocha.indexPole(30)[1]);
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