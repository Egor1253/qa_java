import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Spy
    public Cat cat = new Cat(new Feline());
    // проверяю: что говорит кот.
    @Test
    public void catSays() {
        cat.getSound();
        assertEquals("Мяу", cat.getSound());
        System.out.println(cat.getSound());
    }

    // Проверяю: Хищник ли кот?
    @Test
    public void whoIsCat() throws Exception {
        cat.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
        System.out.println(cat.getFood());
    }

}
