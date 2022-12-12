package tests.matchers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import steps.ElectricStovePageSteps;

public class ElectricStovePageMatcher {
    // Логгер
    private static Logger logger = LogManager.getLogger(ElectricStovePageMatcher.class);
    // Страница "Плиты электрические"
    ElectricStovePageSteps electricStovePageSteps;

    // Конструктор
    public ElectricStovePageMatcher(ElectricStovePageSteps electricStovePageSteps) {
        this.electricStovePageSteps = electricStovePageSteps;
    }

    // Проверка / Утверждение (Матчер)
    //Проверить, что в тексте Плиты электрические [количество] товаров количество товаров больше 100
    public void isCountElectricStoveOverOneHundred() {
        Assertions.assertTrue(electricStovePageSteps.intCountElectricStove() > 100,
                "ERROR! Количество электрических плит меньше 100");
        logger.info("Все ОК! Количество электрических плит больше 100");
    }
}
