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

    public ParametrizedLionTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters // добавил аннотацию
    public static Object[] getLionData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"invalidValue", false},
        };
    }


    @Test
    public void testLion() throws Exception {
        if ("invalidValue".equals(sex)) {
            try {
                new Lion(sex, Mockito.mock(Feline.class));
                Assert.fail("Expected an exception");
            } catch (Exception e) {
                Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
            }
        } else {
            Lion lion = new Lion(sex, Mockito.mock(Feline.class));
            Assert.assertEquals(hasMane, lion.doesHaveMane());
        }
    }
}
