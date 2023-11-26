import com.example.Animal;
import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

public class CheckLion{
    @Mock
    Feline feline;
    Lion lionSpy = Mockito.spy(Lion.class);


    // Проверка - есть ли у Льва львята?
    @Test
    public void haveKingKittens() {
        feline.getKittens(1);
        Mockito.verify(feline).getKittens(1);
    }

    // проверил неизвестный вид животного.
    @Test
    public void whoIsIt() throws Exception {
        Animal.getFood("Водоплавающее");
        Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", lionSpy.getFood());
    }

    // проверил, хищник ли лев.
    @Test
    public void whoIsLion()  throws Exception{
        Animal.getFood("Хищник");
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lionSpy.getFood());
    }
}