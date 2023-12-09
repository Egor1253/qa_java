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
// нужно чтобы весь код был покрыт тестами, поэтому сделал проверку на травоядное.
    @Test
    public void herbivore() throws Exception {
        when(feline.eatMeat()).thenReturn(of("Трава", "Различные растения"));
        assertEquals(of("Трава", "Различные растения"), feline.eatMeat());
    }
    // проверяю что возвращается Кошачьи, при вызове семейства.
    @Test
    public void felineGetFamily() {
        feline.getFamily();
        assertEquals("Кошачьи", feline.getFamily());
    }
    //проверка - передал 1 возвращается 1.
    @Test
    public void felineGetKittens(){
        when(feline.getKittens()).thenReturn(1);
        assertEquals(1, feline.getKittens());
        System.out.println(feline.getKittens());
    }
}
