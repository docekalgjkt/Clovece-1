package model;

import java.util.LinkedList;

public class StartovniDomecek {

    private LinkedList<Figurka> figurky = new LinkedList<>();

    public StartovniDomecek(int pocet, BarvaFigurky barvaFigurky){
        for(int i=0;i<=pocet;i++){
            figurky.addFirst(new Figurka(barvaFigurky));
        }
    }

    public Figurka nasadFigurku(){
        if(!jePrazdny()) return figurky.removeFirst();
        else return null;
    }

    public void vratFigurku(Figurka figurka){figurky.addFirst(figurka);}

    public boolean jePrazdny() {
        if(figurky.isEmpty()){return true;}
        else{return false;}
    }

    public int zbyvaFigurek() {
        if (jePrazdny()) {
            return 0;
        }
        return figurky.size();
    }

    /*public String toString(){
        String dom ="";
        int b = 1;
        for(int a=0; a < figurky.size(); a++){
            if(figurky.get(a)!=null) {
                dom += b + " | ";
            }
            else{
                dom += "0 | ";
            }
        }
        return dom;
    }*/

}
