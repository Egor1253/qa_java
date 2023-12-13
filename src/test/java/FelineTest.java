import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static java.util.List.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class FelineTest {


    @Spy
    private Feline feline;

    @Test
    public void whoIsFeline() throws Exception {
        feline.getFood("Хищник");
        assertEquals(of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    // проверяю что возвращается Кошачьи, при вызове семейства.
    @Test
    public void felineGetFamily() {
        feline.getFamily();
        assertEquals("Кошачьи", feline.getFamily());
    }

    //проверка - кошки заводят котят: 1.
    @Test
    public void felineGetKittens() {
        feline.getKittens();
        assertEquals(1, feline.getKittens());
        System.out.println(feline.getKittens());
    }
}
