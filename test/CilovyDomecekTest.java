import model.BarvaFigurky;
import model.CilovyDomecek;
import model.Figurka;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CilovyDomecekTest {

    private List<Figurka> figurky;

    @Test
    void jeVolno() {
        BarvaFigurky bf = new BarvaFigurky(1, 10);
        CilovyDomecek cd = new CilovyDomecek(4, bf);
        cd.vlozFigurku(1, new Figurka(bf));
        assertTrue(cd.jeVolno(0));
        assertFalse(cd.jeVolno(1));
    }

    @Test
    void vlozFigurku() {
        BarvaFigurky bf = new BarvaFigurky(1, 10);
        CilovyDomecek cd = new CilovyDomecek(4, bf);
        assertEquals(1, cd.vlozFigurku(1, new Figurka(bf)));
    }

    @Test
    void jePlno() {
        BarvaFigurky bf = new BarvaFigurky(1, 10);
        CilovyDomecek cd = new CilovyDomecek(2, bf);
        assertEquals(false, cd.jePlno());
    }
}