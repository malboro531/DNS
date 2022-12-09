package tests.matchers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import pages.ElectricStovePage;

public class ElectricStovePageMatcher {
    // Логгер
    private static Logger logger = LogManager.getLogger(ElectricStovePageMatcher.class);
    // Страница "Плиты электрические"
    ElectricStovePage electricStovePage;

    // Конструктор
    public ElectricStovePageMatcher(ElectricStovePage electricStovePage) {
        this.electricStovePage = electricStovePage;
    }

    // Проверка / Утверждение (Матчер)
    //Проверить, что в тексте Плиты электрические [количество] товаров количество товаров больше 100
    public void isCountElectricStoveOverOneHundred() {
        Assertions.assertTrue(electricStovePage.intCountElectricStove() > 100,
                "ERROR! Количество электрических плит меньше 100");
        logger.info("Все ОК! Количество электрических плит больше 100");
    }
}
