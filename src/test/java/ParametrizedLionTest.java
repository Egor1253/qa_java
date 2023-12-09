import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;


@RunWith(Parameterized.class)
public class ParametrizedLionTest {
    private final String sex;
    private final boolean hasMane;

    public ParametrizedLionTest(String sex, boolean hasMane) throws Exception {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters // добавил аннотацию
    public static Object[] getLionData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},

        };
    }

    // Проверка, что лев - самец (параметризированный тест).
    @Test
    public void isLionMan() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(sex, feline);
        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", hasMane, lion.doesHaveMane());
    }
}
