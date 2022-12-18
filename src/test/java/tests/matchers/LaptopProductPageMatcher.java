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
    public void pageTitleEquals() {
        String expected = "Технические характеристики 15.6\" Ноутбук ASUS ZenBook PRO DUO 15 OLED UX582LR-H2006T" +
                " синий | 4800982 . Интернет-магазин DNS";
        String actual = laptopProductPageSteps.getPageTitle();
        Assertions.assertEquals(expected, actual, "ERROR! Заголовок страницы не соответствует ожидаемому!");
        logger.info("Все ОК! Заголовок страницы соответствует ожидаемому");
    }

    //Проверить, что в блоке Характеристики заголовок содержит ASUS
    public void chCompanyAsusEquals() {
        String actual = laptopProductPageSteps.getChCompanyAsusEquals();
        Assertions.assertTrue((actual).contains("ASUS"));
        logger.info("Все ОК! В блоке Характеристики заголовок содержит ASUS");
    }

    //Проверить, что в блоке Характеристики значение Объем оперативной памяти равно 32 ГБ
    public void chRAMEquals() {
        String actual = laptopProductPageSteps.getChRAMAsusEquals();
        Assertions.assertEquals("32 ГБ", actual);
        logger.info("Все ОК! В блоке Характеристики Объем оперативной памяти равен 32 ГБ");

    }
}
