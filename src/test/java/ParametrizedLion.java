import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;


    @RunWith(Parameterized.class)
    public class ParametrizedLion {
        private final String sex;
        private final boolean hasMane;

        public ParametrizedLion(String sex, boolean hasMane) throws Exception {
            this.sex = sex;
            this.hasMane = hasMane;
        }

        @Parameterized.Parameters // добавил аннотацию
        public static Object[] getLionData() {
            return new Object[][]{
                    {"Самец", true},
                    {"Самка", false},
                    {"Огурец", false},
            };
        }

        // Проверка, что лев - самец (параметризированный тест).
        @Test
        public void isLionMan() throws Exception {
            Lion lion = new Lion("Самец"); //создали объект
            Lion lionSpy = Mockito.spy(lion); //создали шпион объекта
            lionSpy.lionMan(sex, hasMane);
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", "Самец", lionSpy.doesHaveMane());
        }
}
