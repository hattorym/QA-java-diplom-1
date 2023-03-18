
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunParamTest {
    private final String bunName;
    private final float bunPrice;
    private Bun bun;

    public BunParamTest(String name, float price) {
        this.bunName = name;
        this.bunPrice = price;
    }

    @Parameters(name = "Набор тестовых данных {index} >> Name: {0}, Price: {1}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Обычная", 1},
                {"Вкусная", 20},
                {"Съедобная", 300},
                {"Флотная", 0.01F},
                {"Бесценная", 0},
                {" ", 0},
                {"", 0},
                {null, 0},
                {"Отрицательная", -100},
                {"Цифровая_1234", 1234},
                {"$%#^@&$$(%^^)symbol_bun", 999},
                {"СуперПуперОчуметьОфигенноМегаГигаГиперУльтраЭкстраЛухариМаксиДлинноеИмя", Float.MAX_VALUE}
        };
    }

    @Before
    public void setBun() {
        this.bun = new Bun(this.bunName, this.bunPrice);
    }

    @Test
    public void getBunNameTestShouldReturnValidBunName() {
        Assert.assertEquals("Имя булочки не соответствует указанному", this.bunName, this.bun.getName());
    }

    @Test
    public void getBunPriceTestShouldReturnValidBunPrice() {
        Assert.assertEquals("Цена булочки не соответствует указанной", this.bunPrice, this.bun.getPrice(), 0.01F);
    }
}
