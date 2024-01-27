import com.example.Animal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class AnimalSecondTest {
    // определение констант для теста
    private static final String ANIMAL_KIND_HERBIVORE = "Травоядное";
    private static final String ANIMAL_KIND_PREDATOR = "Хищник";
    private static final String[] FOODS_HERBIVORE = {"Трава", "Различные растения"};
    private static final String[] FOODS_PREDATOR = {"Животные", "Птицы", "Рыба"};
    // определение переменных для теста
    private String animalKind;
    private String[] foods;
    private Animal animal;
    // конструктор класса
    public AnimalSecondTest(String animalKind, String[] foods) {
        this.animalKind = animalKind;
        this.foods = foods;
    }

    // параметры для теста
    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][] {
                {ANIMAL_KIND_HERBIVORE, FOODS_HERBIVORE},
                {ANIMAL_KIND_PREDATOR, FOODS_PREDATOR}
        };
    }

    // создание экземпляра Animal для теста
    @Before
    public void setUp() {
        animal = new Animal();
    }

    // проверка метода getFood
    @Test
    public void testGetFood() throws Exception {
        String[] actual = animal.getFood(animalKind).toArray(new String[0]);
        assertArrayEquals(foods, actual);
    }
}
