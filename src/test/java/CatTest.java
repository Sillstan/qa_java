import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    // определение переменных для тестов
    private Cat cat;

    // создание мока класса Feline для тестов
    @Mock
    Feline feline;

    // создание объекта класса Cat с моком
    @Before
    public void setUp() {
        cat = new Cat(feline);
    }

    // проверка метода getSound
    @Test
    public void testGetSound() {
        String expected = "Мяу";
        String actual = cat.getSound();
        assertEquals(expected, actual);
    }

    // проверка метода getFood
    @Test
    public void testGetFood() throws Exception {
            cat.getFood();
            Mockito.verify(feline).eatMeat();
    }
}
