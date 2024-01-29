import com.example.Animal;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.junit.Assert.assertEquals;

public class AnimalTest {
    // определение констант для тестов
    private static final String FALSE_KIND = "Всеядный";
    private static final String EXCEPTION_TEXT = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
    private static final String ANIMALS_FAMALYS = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
    // определение переменных для тестов
    private Animal animal;

    // создание экземпляра Animal для тестов
    @Before
    public void setUp() {
        animal = new Animal();
    }

    // проверка метода getFood на выброс ожидаемого исключения
    @Test
    public void testGetFoodException() {
        Throwable throwable = catchThrowable(() -> {
            animal.getFood(FALSE_KIND);
        });
        assertThat(throwable).isInstanceOf(Exception.class).hasMessage(EXCEPTION_TEXT);
    }

    // проверка метода getFamaly
    @Test
    public void testGetFamily() {
        String actual = animal.getFamily();
        assertEquals(ANIMALS_FAMALYS, actual);
    }
}
