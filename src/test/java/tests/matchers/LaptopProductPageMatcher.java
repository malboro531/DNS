package tests.matchers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import steps.LaptopProductPageSteps;

public class LaptopProductPageMatcher {
    // Логгер
    private static Logger logger = LogManager.getLogger(LaptopProductPageMatcher.class);
    // Шаги на странице "Бытовая техника"
    LaptopProductPageSteps laptopProductPageSteps;

    // Конструктор
    public LaptopProductPageMatcher(LaptopProductPageSteps laptopProductPageSteps) {
        this.laptopProductPageSteps = laptopProductPageSteps;
    }

    // Проверка / Утверждение (Матчер)
    // Проверить, что заголовок страницы соответствует ожидаемому
    public void pageTitleEquals(String expected) {
        String actual = laptopProductPageSteps.getPageTitle();
        Assertions.assertEquals(expected, actual, "ERROR! Заголовок страницы не соответствует ожидаемому!");
    }

    //Проверить, что в блоке Характеристики заголовок содержит ASUS
    public void chCompanyAsusEquals(String expectedCompany) {
        String actual = laptopProductPageSteps.getChCompanyAsusEquals();
        Assertions.assertEquals(expectedCompany, actual,
                "ERROR! В блоке Характеристики заголовок не содержит ASUS!");
    }

    //Проверить, что в блоке Характеристики значение Объем оперативной памяти равно 32 ГБ
    public void chRAMEquals(String expectedRAM) {
        String actual = laptopProductPageSteps.getChRAMAsusEquals();
        Assertions.assertEquals(expectedRAM, actual,
                "ERROR! В блоке Характеристики объем оперативной памяти не соответствует ожидаемому!");

    }
}
