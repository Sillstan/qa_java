import com.example.Feline;
import com.example.LionAlex;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {
    // определение констант для тестов
    private final int expectedAlexKittens = 0;
    private final String[] expectedFriendsOfAlex = {"Марти", "Глория", "Мелман"};
    private final String expectedPlaceOfLivivng = "Нью-Йоркский зоопарк";
    // определение переменных для тестов
    private LionAlex alex;

    // создание мока класса Feline для тестов
    @Mock
    private Feline feline;

    // проверка метода getFriends
    @Test
    public void testGetFriends() throws Exception {
        alex = new LionAlex(feline);
        String[] actualFriendsOfAlex = alex.getFriends();
        assertArrayEquals(expectedFriendsOfAlex, actualFriendsOfAlex);
    }

    // проверка метода getPlaceOfLivivng
    @Test
    public void testGetPlaceOfLiving() throws Exception {
        alex = new LionAlex(feline);
        String actualPlaceOfLiving = alex.getPlaceOfLiving();
        assertEquals(expectedPlaceOfLivivng, actualPlaceOfLiving);
    }

    // проверка метода getKittens
    @Test
    public void testGetKittens() throws Exception {
        alex = new LionAlex(feline);
        int actualAlexKittens = alex.getKittens();
        assertEquals(expectedAlexKittens, actualAlexKittens);
    }
}
