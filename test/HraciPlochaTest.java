import model.BarvaFigurky;
import model.Figurka;
import model.HraciPlocha;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HraciPlochaTest {

    @Test
    void testNasad() {
        HraciPlocha hp = new HraciPlocha(1,1,10);
        BarvaFigurky bf = new BarvaFigurky(1,10);
        Figurka figurka = new Figurka(bf);
        hp.nasad(figurka);
        assertEquals(1, hp.nasad(figurka));
    }

    @Test
    void testPosunFigurku() {
    }

    @Test
    void vratMozneFigurky() {
    }
}