import com.example.Animal;
import com.example.Cat;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CheckCat {
    @Mock
    Cat cat;
    Cat CatSpy = Mockito.spy(Cat.class);
    // проверяю: что говорит кот.
    @Test
    public void catSays() {
        System.out.println(cat.getSound());
        Mockito.when(cat.getSound()).thenReturn("Мяу");
        // теперь при вызове getSound() всегда будет возвращаться Мяу
        System.out.println(cat.getSound());
    }

    // Проверяю: Хищник ли кот?
    @Test
    public void whoIsCat()  throws Exception{
        Animal.getFood("Хищник");
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), CatSpy.getFood());
    }

}
