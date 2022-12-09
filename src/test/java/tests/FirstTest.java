package tests;

import helpers.ScreenshotHelper;
import org.junit.jupiter.api.Test;
import steps.AppliancePageSteps;
import steps.KitchenAppliancePageSteps;
import steps.StartPageSteps;
import tests.matchers.AppliancePageMatcher;
import tests.matchers.KitchenAppliancePageMatcher;

public class FirstTest extends BaseTest {

    @Test
    public void dnsTest() {
    // 1. Arrange

    // 2. Act
    // 2.1 Шаги на стартовой странице ДНС
        AppliancePageSteps startPageSteps = startPageSteps();
        appliancePageMatchers(startPageSteps);
    // 2.2 Шаги на странице "Бытовая техника"
        KitchenAppliancePageSteps appliancePageSteps = appliancePageSteps();
        kitchenAppliancePageMatchers(appliancePageSteps);
    // 2.3 Шаги на странице "Техника для кухни"
        kitchenAppliancePageSteps();
    }

    // 3. Assert
    // 3.1 Matchers appliancePage
    private void appliancePageMatchers(AppliancePageSteps startPageSteps) {
        AppliancePageMatcher appliancePageMatcher = new AppliancePageMatcher(startPageSteps);
        // 3.1.1 Проверить, что отображается текст Бытовая техника
        String expected = "Бытовая техника";
        appliancePageMatcher.pageTitleEqualsAppliance(expected);
    }

    // 3.2 Matchers kitchenPage
    private void kitchenAppliancePageMatchers(KitchenAppliancePageSteps appliancePageSteps) {
        KitchenAppliancePageMatcher kitchenAppliancePageMatcher = new KitchenAppliancePageMatcher(appliancePageSteps);
        // 3.2.1 Проверить, что отображается текст Техника для кухни
        String expectedTitleKitchenAppliance = "Техника для кухни";
        kitchenAppliancePageMatcher.pageTitleEqualsKitchenAppliance(expectedTitleKitchenAppliance);
        // 3.2.2 Проверить, что отображается ссылка Собрать свою кухню
        kitchenAppliancePageMatcher.isDisplayedLinkAssembleKitchen();
        // 3.2.3 Проверить, что количество категорий больше 5
        kitchenAppliancePageMatcher.isCountKitchenCategoriesOverFive();
    }

    private AppliancePageSteps startPageSteps() {
        // ***** Стартовая страница сайта DNS *****
        StartPageSteps startPageSteps = new StartPageSteps(driver);
        //Закрыть окно подтверждения города
        startPageSteps.closeCityAgree();
        //Скриншот
        ScreenshotHelper.screenshot("11HomePage.png");
        //Перейти по ссылке Бытовая техника
        startPageSteps.goToAppliancesPage();
        return new AppliancePageSteps(driver);
    }

    private KitchenAppliancePageSteps appliancePageSteps() {
        // ***** Страница "Бытовая техника" *****
        AppliancePageSteps appliancePageSteps = new AppliancePageSteps(driver);
        //Скриншот
        ScreenshotHelper.screenshot("12Appliance.png");
        //Перейти по ссылке Техника для кухни
        appliancePageSteps.goToKitchenAppliancePage();
        return new KitchenAppliancePageSteps(driver);
    }

    private void kitchenAppliancePageSteps() {
        // ***** Страница "Техника для кухни" *****
        KitchenAppliancePageSteps kitchenAppliancePageSteps = new KitchenAppliancePageSteps(driver);
        //Вывести в логи названия всех категорий
        kitchenAppliancePageSteps.getLogsCategories();
        //Скриншот
        ScreenshotHelper.screenshot("13KitchenAppliance.png");
    }

}