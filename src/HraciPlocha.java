import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

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
    //public void nasad(BarvaFigurky barvaFigurky){}

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
        for(Figurka f : hraciPole){
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
