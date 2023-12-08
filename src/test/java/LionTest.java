import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Lion lionSpy = Mockito.spy(Lion.class);

    // Проверка - есть ли у Льва львята?
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
    }

    // проверил, хищник ли лев.
    @Test
    public void whoIsLion() throws Exception {
        when(lionSpy.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
    }
}
