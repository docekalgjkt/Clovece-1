package model;

import java.util.ArrayList;
import java.util.List;

public class CilovyDomecek {

    private List<Figurka> figurky;
    private BarvaFigurky barvaFigurky;
    private int pocet;

    public CilovyDomecek(int pocet, BarvaFigurky barvaFigurky){
        figurky = new ArrayList<>(pocet);
        this.pocet = pocet;
        this.barvaFigurky= barvaFigurky;
        for(int i=0;i<pocet;i++){
            figurky.add(i,null);
        }
    }

    public boolean jeVolno(int pozice){
        if(figurky.get(pozice)==null){
            return true;
        }
        return false;
    }

    public int vlozFigurku(int pozice, Figurka figurka){
        if (jeVolno(pozice)){
            figurky.set(pozice, figurka);
        }
        int ok = 1;
        return ok;
    }

    public boolean jePlno() {
        if(figurky.contains(null)){
            return false;
        }
        return true;
    }

    public List<Figurka> getFigurkyKPohybu(){
        List<Figurka> figurkaList = new ArrayList<>();
        for (Figurka f:figurky){
            for (int i=figurky.indexOf(f);i<pocet;i++) {
                if (figurky.get(i)==null) figurkaList.add(f);
            }
        }
        return figurkaList;
    }

}
