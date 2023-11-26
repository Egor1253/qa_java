import com.example.Animal;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static java.util.List.*;


@RunWith(MockitoJUnitRunner.class)
public class CheckFeline {


    @Mock
    Feline feline;
    Feline felineSpy = Mockito.spy(Feline.class);

    @Test
    public void whoIsFeline()  throws Exception{
        Animal.getFood("Хищник");
        Assert.assertEquals(of("Животные", "Птицы", "Рыба"), felineSpy.eatMeat());
    }

    @Test
    public void herbivore()  throws Exception{
        Animal.getFood("Травоядное");
        Mockito.when(feline.eatMeat()).thenReturn(of("Трава", "Различные растения"));
        Assert.assertEquals(of("Трава", "Различные растения"), feline.eatMeat());
    }
}
