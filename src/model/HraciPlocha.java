package model;

import java.util.*;

public class HraciPlocha {

    private Map<BarvaFigurky, StartovniDomecek> startovniDomecekMap = new HashMap<>();
    private Map<BarvaFigurky, CilovyDomecek> cilovyDomecekMap = new HashMap<>();
    private Map<BarvaFigurky, Figurka> nasazeneFigurky = new HashMap<>();
    private List<Figurka> hraciPole = new ArrayList<>();


    public HraciPlocha(int pocetHracu, int pocetFigurek, int pocetMeziPoli){

        for(int i=0;i<pocetHracu;i++){

            //Vytvoření startovních a cílových domečků
            BarvaFigurky barvaFigurky = new BarvaFigurky(i*pocetMeziPoli, pocetHracu*pocetMeziPoli);
            StartovniDomecek startovniDomecek = new StartovniDomecek(pocetFigurek, barvaFigurky);
            startovniDomecekMap.put(barvaFigurky, startovniDomecek);

            CilovyDomecek cilovyDomecek = new CilovyDomecek(pocetFigurek, barvaFigurky);
            cilovyDomecekMap.put(barvaFigurky, cilovyDomecek);
        }
        //Vytvoření hracího pole
        for (int x=0;x<pocetMeziPoli*pocetHracu;x++) {
            hraciPole.add(x,null);
        }

    }
    //Nasazení figurky na správné místo
    //public void nasad(model.BarvaFigurky barvaFigurky){}

        public static int[] indexPole(int x){
        int[] sX = {19,69,119,169,219,219,219,219,219,269,319,319,319,319,319,369,419,469,519,519,519,469,419,369,319,319,319,319,319,269,219,219,219,219,219,169,119,69,19,19};
        int[] sY = {215,215,215,215,215,165,115,65,15,15,15,65,115,165,215,215,215,215,215,265,315,315,315,315,315,365,415,465,515,515,515,465,415,365,315,315,315,315,315,265};
        int[] souradnice = new int [2];
        souradnice[0] = sX[x];
        souradnice[1] = sY[x];
        return souradnice;
    }

    public static int hod() {
        Random generator = new Random();
        int a = generator.nextInt(6) + 1;
        return a;
    }


    public int nasad(Figurka figurka){
        int nasazeni=figurka.getBarvaFigurky().getStart();
        Figurka a = hraciPole.get(nasazeni);
        if(hraciPole.get(nasazeni)!=null){
            startovniDomecekMap.get(a.getBarvaFigurky()).vratFigurku(a);
        }
        hraciPole.set(nasazeni, figurka);
        int ok = 1;
        return ok;
    }

    //Posunutí figurky o daný počet míst
    public int posunFigurku(Figurka figurka, int pocetPoli){
        int staraPozice = hraciPole.indexOf(figurka);
        int novaPozice = staraPozice + pocetPoli;
        Figurka a = hraciPole.get(novaPozice);
        if(a!=null){
            startovniDomecekMap.get(a.getBarvaFigurky()).vratFigurku(a);
            if(a==hraciPole.get(staraPozice)){}
            else{
                hraciPole.set(novaPozice, figurka);
                hraciPole.set(staraPozice, null);
            }
        }
        int ok = 1;
        return ok;
    }
    //public void posunFigurku(int  odkud, int pocetPoli){}

    //Zjištění, se kterými figurkami může hráč hrát
    public List<Figurka> vratMozneFigurky(BarvaFigurky barvaFigurky, int pocetPoli){
        List<Figurka> figurky = new ArrayList<>();
        for(Figurka f : hraciPole){ //při každém průchodu (pro každý prvek projít)
            if ((f.getBarvaFigurky()==barvaFigurky)&&(muzuPohyb(f,pocetPoli))) figurky.add(f);
        }
        return null;
    }

    private boolean muzuPohyb(Figurka f, int pocetPoli){
        boolean vysledek = false;
        Figurka figurkaPredeMnou = hraciPole.get(hraciPole.indexOf(f)+pocetPoli);
        if(figurkaPredeMnou==null) vysledek = true;
        else if(figurkaPredeMnou.getBarvaFigurky()!=f.getBarvaFigurky()) vysledek = true;
        return vysledek;
    }


}