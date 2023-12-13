import com.example.Feline;
import com.example.Lion;
import org.junit.Test;

import static java.util.List.of;
import static org.junit.Assert.*;

public class LionTest {
      Lion lion = new Lion("Самец", new Feline());

    public LionTest() throws Exception {
    }

    // проверка- есть ли у льва львята.
    @Test
    public void haveKingKittens() {
        assertEquals(1, lion.getKittens());
        System.out.println("Котят у льва: " + lion.getKittens());
    }

    // проверил, хищник ли лев.
    @Test
    public void whoIsLion() throws Exception {
        assertEquals(of("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}

