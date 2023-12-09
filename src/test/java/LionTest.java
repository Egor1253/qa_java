import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Spy
    Lion lionSpy;

    // проверка- вызвали метод getKittens 3 раза.
    @Test
    public void haveKingKittens() {
        lionSpy.getKittens();
        lionSpy.getKittens();
        lionSpy.getKittens();
        Mockito.verify(lionSpy, Mockito.times(3)).getKittens();
    }

    // проверил неизвестный вид животного.
    @Test
    public void whoIsIt() throws Exception {
        doThrow(new IOException("Неизвестный вид животного, используйте значение Травоядное или Хищник"))
                .when(lionSpy).getFood("Водоплавающее");

        // Убедимся, что при вызове метода с "Водоплавающее" выбрасывается исключение
        IOException exception = assertThrows(IOException.class, () -> lionSpy.getFood("Водоплавающее"));

        // Убедимся, что текст сообщения об ошибке соответствует ожиданиям
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", lionSpy.getFood());
    }

    // проверил, хищник ли лев.
    @Test
    public void whoIsLion() throws Exception {
        when(lionSpy.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lionSpy.getFood("Хищник"));
    }
}

