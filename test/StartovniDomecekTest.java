import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class StartovniDomecekTest {

    private LinkedList<Figurka> figurky = new LinkedList<>();

    @Test
    void jePrazdny() {
        BarvaFigurky bf = new BarvaFigurky(1,10);
        StartovniDomecek sd = new StartovniDomecek(1, bf);
        sd.nasadFigurku();
        assertTrue(sd.jePrazdny());
        sd.vratFigurku(new Figurka(bf));
        assertFalse(sd.jePrazdny());
        System.out.println(sd);
    }
}