import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    // определение констант для тестов
    private static final String EXPECTED = "Кошачьи";
    private static final int DEFAULT_KITTENS_COUNT = 1;
    private static final int KITTENS_COUNT = 2;

    // создание шпиона класса Feline
    @Spy
    private Feline feline;

    // проверка метода eatMeat
    @Test
    public void testEatMeat() throws Exception {
            feline.eatMeat();
            Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    // проверка метода getFamaly
    @Test
    public void testGetFamily() {
        String actual = feline.getFamily();
        Mockito.verify(feline, Mockito.times(1)).getFamily();
        assertEquals(EXPECTED, actual);
    }

    // проверка метода getKittens с дефолтным значением 1
    @Test
    public void testDefaultGetKittens() {
        int actual = feline.getKittens();
        Mockito.verify(feline).getKittens(DEFAULT_KITTENS_COUNT);
        assertEquals(DEFAULT_KITTENS_COUNT, actual);
    }

    // проверка метода getKittens с заданным значением
    @Test
    public void testGetKittens() {
        int actual = feline.getKittens(KITTENS_COUNT);
        Mockito.verify(feline).getKittens(Mockito.anyInt());
        assertEquals(KITTENS_COUNT, actual);
    }
}
