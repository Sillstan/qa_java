import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    // определение констант для тестов
    private static final String MALE = "Самец";
    private static final String FALSE_SEX = "Оно";
    private static final String EXCEPTION_TEXT = "Используйте допустимые значения пола животного - самец или самка";
    // определение переменных для тестов
    private Lion lion;

    // создание мока класса Feline для тетсов
    @Mock
    private Feline feline;

    // проверка метода getKittens
    @Test
    public void testGetKittens() throws Exception {
            lion = new Lion(MALE, feline);
            lion.getKittens();
            Mockito.verify(feline).getKittens();
    }

    // проверка метода doesHaveMane на выброс ожидаемого исключения
    @Test
    public void testDoesHaveMane() {
        Throwable throwable = catchThrowable(() -> {
            lion = new Lion(FALSE_SEX, feline);
        });
        assertThat(throwable).isInstanceOf(Exception.class).hasMessage(EXCEPTION_TEXT);
    }

    // проверка метода getFood
    @Test
    public void testGetFood() throws Exception {
            lion = new Lion(MALE, feline);
            lion.getFood();
            Mockito.verify(feline).getFood(Mockito.anyString());
    }
}
