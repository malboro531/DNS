package tests;

import helpers.JavaScriptHelper;
import helpers.ScreenshotHelper;
import listeners.Selenium4Listener;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import steps.AppliancePageSteps;
import steps.KitchenAppliancePageSteps;
import steps.StartPageSteps;
import tests.matchers.AppliancePageMatcher;
import tests.matchers.KitchenAppliancePageMatcher;

public class FirstTest extends BaseTest{
    @Test
    public void startPageTest() {
        // ***** Стартовая страница сайта DNS *****
        // 1.1 Arrange

        // 1.2 Act Шаги на стратовой странице ДНС
        // Регистрация слушателя событий
        Selenium4Listener listener = new Selenium4Listener();
        WebDriver eventFiringWebDriver = new EventFiringDecorator<>(listener).decorate(driver);

        StartPageSteps startPageSteps = new StartPageSteps(eventFiringWebDriver);
        //Закрыть окно подтверждения города
//        startPageSteps.closeCityAgree();
        //Скриншот
        JavaScriptHelper.slowScroll();
        ScreenshotHelper.screenshot("11HomePage.png");

        // 1.3 Matchers startPage
    }

    @Test
    public void appliancePageTest(){
        // ***** Страница "Бытовая техника" *****
        // 2.1 Arrange

        // 2.2 Act Шаги на стратовой странице ДНС
        // Регистрация слушателя событий
        Selenium4Listener listener = new Selenium4Listener();
        WebDriver eventFiringWebDriver = new EventFiringDecorator<>(listener).decorate(driver);
        StartPageSteps startPageSteps = new StartPageSteps(eventFiringWebDriver);
        //Закрыть окно подтверждения города
//        startPageSteps.closeCityAgree();
        //Перейти по ссылке Бытовая техника
        startPageSteps.goToAppliancesPage();

        AppliancePageSteps appliancePageSteps = new AppliancePageSteps(eventFiringWebDriver);
        //Скриншот
        ScreenshotHelper.screenshot("12Appliance.png");

        // 2.3 Matchers appliancePage
        AppliancePageMatcher appliancePageMatcher = new AppliancePageMatcher(appliancePageSteps);
        // 2.3.1 Проверить, что отображается текст Бытовая техника
        String expected = "Бытовая техника";
        appliancePageMatcher.pageTitleEqualsAppliance(expected);
    }

    @Test
    public void kitchenAppliancePageTest() {
        // ***** Страница "Техника для кухни" *****
        // 3.1 Arrange

        // 3.2 Act Шаги на стратовой странице "Техника для кухни"
        // Регистрация слушателя событий
        Selenium4Listener listener = new Selenium4Listener();
        WebDriver eventFiringWebDriver = new EventFiringDecorator<>(listener).decorate(driver);

        StartPageSteps startPageSteps = new StartPageSteps(eventFiringWebDriver);
        //Закрыть окно подтверждения города
//        startPageSteps.closeCityAgree();
        //Перейти по ссылке Бытовая техника
        startPageSteps.goToAppliancesPage();

        AppliancePageSteps appliancePageSteps = new AppliancePageSteps(eventFiringWebDriver);
        //Перейти по ссылке Техника для кухни
        appliancePageSteps.goToKitchenAppliancePage();

        KitchenAppliancePageSteps kitchenAppliancePageSteps = new KitchenAppliancePageSteps(eventFiringWebDriver);
        //Вывести в логи названия всех категорий
        kitchenAppliancePageSteps.getLogsCategories();
        //Скриншот
        JavaScriptHelper.slowScroll();
        ScreenshotHelper.screenshot("13KitchenAppliance.png");

        // 3.3 Matchers kitchenAppliancePage
        KitchenAppliancePageMatcher kitchenAppliancePageMatcher =
                new KitchenAppliancePageMatcher(kitchenAppliancePageSteps);
        // 3.3.1 Проверить, что отображается текст Техника для кухни
        String expectedTitleKitchenAppliance = "Техника для кухни";
        kitchenAppliancePageMatcher.pageTitleEqualsKitchenAppliance(expectedTitleKitchenAppliance);
        // 3.3.2 Проверить, что отображается ссылка Собрать свою кухню
        kitchenAppliancePageMatcher.isDisplayedLinkAssembleKitchen();
        // 3.3.3 Проверить, что количество категорий больше 5
        kitchenAppliancePageMatcher.isCountKitchenCategoriesOverFive();
    }

}