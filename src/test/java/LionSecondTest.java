import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionSecondTest {
    // определение констант для тестов
    private static final String MALE = "Самец";
    private static final String FEMALE = "Самка";
    // определение переменных для тестов
    private Lion lion;
    private Feline feline;
    private String sex;
    private boolean hasMane;

    // создание мока класса Feline для тестов
    @Before
    public void setUp() {
        feline = Mockito.mock(Feline.class);
    }

    // конструктор класса
    public LionSecondTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    // параметры для тестов
    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][] {
                {MALE, true},
                {FEMALE, false}
        };
    }

    // проверка метода doesHaveMane
    @Test
    public void testSecondDoesHaveMane() throws Exception {
            lion = new Lion(sex, feline);
            boolean actual = lion.doesHaveMane();
            assertEquals(hasMane, actual);
    }
}
