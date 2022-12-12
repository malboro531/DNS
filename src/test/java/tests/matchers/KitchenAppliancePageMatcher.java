package tests.matchers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import steps.KitchenAppliancePageSteps;

public class KitchenAppliancePageMatcher {
    // Логгер
    private static Logger logger = LogManager.getLogger(KitchenAppliancePageMatcher.class);
    // Страница "Техника для кухни"
    KitchenAppliancePageSteps kitchenAppliancePageSteps;

    // Конструктор
    public KitchenAppliancePageMatcher(KitchenAppliancePageSteps kitchenAppliancePageSteps) {
        this.kitchenAppliancePageSteps = kitchenAppliancePageSteps;
    }

    // Проверка / Утверждение (Матчер)
    //Проверить, что отображается текст Техника для кухни
    public void pageTitleEqualsKitchenAppliance(String expected) {
        String actual = kitchenAppliancePageSteps.getKitchenApplianceTitle();
        Assertions.assertEquals(expected, actual, "ERROR! Текст Техника для кухни не отображается!");
        logger.info("Все ОК! Текст Техника для кухни отображается");
    }

    //Проверить, что отображается ссылка Собрать свою кухню
    public void isDisplayedLinkAssembleKitchen() {
        Assertions.assertTrue(kitchenAppliancePageSteps.getLinkAssembleKitchen(), "ERROR! Ссылка Собрать свою кухню не отображается!");
        logger.info("Все ОК! Ссылка Собрать свою кухню отображается");
    }

    //Проверить, что количество категорий больше 5
    public void isCountKitchenCategoriesOverFive() {
        Assertions.assertTrue(kitchenAppliancePageSteps.countKitchenCategories() > 5, "ERROR! Количество категорий меньше 5");
        logger.info("Все ОК! Количество категорий больше 5");
    }
}
