import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientParamTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    private Ingredient ingredient;

    public IngredientParamTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Набор тестовых данных {index} >> Type: {0}, Name: {1}, Price: {2}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {SAUCE, "hot sauce", 100},
                {SAUCE, "sour cream", 200},
                {SAUCE, "chili sauce", 300},
                {FILLING, "cutlet", 100},
                {FILLING, "dinosaur", 200},
                {FILLING, "sausage", 300},
                {null, "cutlet", 100},
                {FILLING, "", 2},
                {null, null, 0}
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getTypeShouldReturnValidType() {
        assertEquals("Ошибка в типе ингредиента", type, ingredient.getType());
    }

    @Test
    public void getNameShouldReturnValidName() {
        assertEquals("Ошибка в названии ингредиента", name, ingredient.getName());
    }

    @Test
    public void getPriceShouldReturnValidPrice() {
        assertEquals("Ошибка в цене ингредиента", price, ingredient.getPrice(), 0.01F);
    }
}