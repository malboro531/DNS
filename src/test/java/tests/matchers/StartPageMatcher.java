package tests.matchers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import pages.StartPage;
import steps.StartPageSteps;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StartPageMatcher {
    // Логгер
    private static Logger logger = LogManager.getLogger(StartPageMatcher.class);
    // Стартовая страница сайта DNS
    StartPageSteps startPageSteps;

    // Конструктор
    public StartPageMatcher(StartPageSteps startPageSteps) {
        this.startPageSteps = startPageSteps;
    }

    // Проверка / Утверждение (Матчер)
    // Проверить, что отображаются ссылки: Встраиваемая техника, Техника для кухни, Техника для дома
    public void isDisplayedLinkApplianceSubcategories() {
        List<String> expectedResultSubcategories = new ArrayList();
        expectedResultSubcategories.add("Встраиваемая техника");
        expectedResultSubcategories.add("Техника для кухни");
        expectedResultSubcategories.add("Техника для дома");

        Assertions.assertEquals(expectedResultSubcategories, startPageSteps.getTextsSubcategories(),
                "ERROR!Запрашиваемые категории не найдены");
        logger.info("Все ОК! Ссылки: Встраиваемая техника, Техника для кухни, Техника для дома отображаются");
    }

}