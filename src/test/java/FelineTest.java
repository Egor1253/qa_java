import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static java.util.List.*;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class FelineTest {


    @Spy
    private Feline feline;

    @Test
    public void whoIsFeline() throws Exception {
        feline.getFood("Хищник");
        Assert.assertEquals(of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void herbivore() throws Exception {
        feline.getFood("Травоядное");
        when(feline.eatMeat()).thenReturn(of("Трава", "Различные растения"));
        Assert.assertEquals(of("Трава", "Различные растения"), feline.eatMeat());
    }

    @Test
    public void felineGetFamily() {
        feline.getFamily();
        Mockito.verify(feline).getFamily();
    }
    @Test
    public void felineGetKittens(){
        when(feline.getKittens()).thenReturn(1);
        Assert.assertEquals(1, feline.getKittens());
        System.out.println(feline.getKittens());
    }
}
