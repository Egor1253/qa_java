import com.example.Lion;
import org.junit.Test;

import static java.util.List.of;
import static org.junit.Assert.*;

public class LionTest {
      Lion lion = new Lion();
    // проверка- есть ли у льва львята.
    @Test
    public void haveKingKittens() {
        lion.getKittens(0);
        assertEquals(0, lion.getKittens(0));
        System.out.println("Котят у льва: " + lion.getKittens(0));
    }

    // проверил, хищник ли лев.
    @Test
    public void whoIsLion() throws Exception {
        lion.getFood("Хищник");
        assertEquals(of("Животные", "Птицы", "Рыба"), lion.getFood("Хищник"));
    }
}

