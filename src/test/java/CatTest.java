import com.example.Cat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Cat cat;
    Cat catSpy = Mockito.spy(Cat.class);

    // проверяю: что говорит кот.
    @Test
    public void catSays() {
        System.out.println(cat.getSound());
        Mockito.when(cat.getSound()).thenReturn("Мяу");
        assertEquals("Мяу", cat.getSound());
        System.out.println(cat.getSound());
    }

    // Проверяю: Хищник ли кот?
    @Test
    public void whoIsCat() throws Exception {
        catSpy.getFood();
        Mockito.verify(cat, Mockito.times(1)).getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }

}
