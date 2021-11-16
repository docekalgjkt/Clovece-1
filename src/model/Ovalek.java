package model;


import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import view.MainFXController;

public class Ovalek {

    int x;
    int y;
    int rozmerX;
    int rozmerY;
    Color barva;

    public Ovalek(int x, int y, int rozmerX, int rozmerY, Color barva, BarvaFigurky barvaFigurky){


        rozmerX = 30;
        rozmerY = 30;
        Circle kol = new Circle();
        AnchorPane p = new AnchorPane();
        p.getChildren().add(kol);
        kol.setLayoutX(30);
        kol.setLayoutY(30);
    }

    public void poloha(int x, int y){

    }
}
