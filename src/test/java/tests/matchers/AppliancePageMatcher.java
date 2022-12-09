package tests.matchers;

import elements.Link;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import steps.AppliancePageSteps;
import steps.KitchenAppliancePageSteps;

public class AppliancePageMatcher {
    // Логгер
    private static Logger logger = LogManager.getLogger(AppliancePageMatcher.class);
    // Шаги на странице "Бытовая техника"
    AppliancePageSteps appliancePageSteps;

    // Конструктор
    public AppliancePageMatcher(AppliancePageSteps appliancePageSteps) {this.appliancePageSteps = appliancePageSteps;}

    // Проверка / Утверждение (Матчер)
    //Проверить, что отображается текст Бытовая техника
    public void pageTitleEqualsAppliance(String expected) {
        String actual = appliancePageSteps.getApplianceTitle();
        Assertions.assertEquals(expected, actual, "ERROR! Текст Бытовая техника не отображается!");
        logger.info("Все ОК! Текст Бытовая техника отображается");
    }
}