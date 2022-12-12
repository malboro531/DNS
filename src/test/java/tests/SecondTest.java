package tests;

import helpers.JavaScriptHelper;
import helpers.ScreenshotHelper;
import listeners.Selenium4Listener;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import steps.ElectricStovePageSteps;
import steps.StartPageSteps;
import steps.StoveAndOvenPageSteps;
import tests.matchers.ElectricStovePageMatcher;
import tests.matchers.StartPageMatcher;

public class SecondTest extends BaseTest {

    @Test
    public void startPageTest() {
        // ***** Стартовая страница сайта DNS *****
        // 1.1 Arrange

        // 1.2 Act Шаги на стратовой странице ДНС
        // Регистрация слушателя событий
        Selenium4Listener listener = new Selenium4Listener();
        WebDriver eventFiringWebDriver = new EventFiringDecorator<>(listener).decorate(driver);

        StartPageSteps startPageSteps = new StartPageSteps(eventFiringWebDriver);
        // Закрыть окно подтверждения города
        startPageSteps.closeCityAgree();
        //Скриншот
        JavaScriptHelper.slowScroll();
        ScreenshotHelper.screenshot("21HomePage.png");
        //Навести курсор на ссылку Бытовая техника
        startPageSteps.focusOnLinkAppliance();
        //Скриншот
        ScreenshotHelper.screenshot("22FocusOnLinkAppliance.png");
        //Навести курсор на ссылку Бытовая техника повторно (+скролл)
        JavaScriptHelper.scrollBy(0, -3000);
        startPageSteps.focusOnLinkAppliance();
        //Навести курсор на ссылку Плиты и печи
        startPageSteps.focusOnLinkStoveAndOven();
        //Скриншот
        ScreenshotHelper.screenshot("23FocusOnLinkStoveAndOven.png");
        //Навести курсор на ссылку Бытовая техника повторно (+скролл)
        JavaScriptHelper.scrollBy(0, -3000);
        startPageSteps.focusOnLinkAppliance();

        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 1.3 Assert Matchers startPage
        StartPageMatcher starPageMatcher = new StartPageMatcher(startPageSteps);
        // 1.3.1 Проверить, что отображаются ссылки: Встраиваемая техника, Техника для кухни, Техника для дома
        starPageMatcher.isDisplayedLinkApplianceSubcategories();
    }

    @Test
    public void stoveAndOvenPageTest() {
        // ***** Страница "Плиты и печи" *****
        // 2.1 Arrange

        // 2.2 Act Шаги на странице "Плиты и печи"
        // Регистрация слушателя событий
        Selenium4Listener listener = new Selenium4Listener();
        WebDriver eventFiringWebDriver = new EventFiringDecorator<>(listener).decorate(driver);

        StartPageSteps startPageSteps = new StartPageSteps(eventFiringWebDriver);
        // Закрыть окно подтверждения города
        startPageSteps.closeCityAgree();
        //Перейти по ссылке Плиты и печи
        startPageSteps.focusOnLinkAppliance();
        startPageSteps.goToStoveAndOvensPage();
        //Скриншот
        ScreenshotHelper.screenshot("24StoveAndOven.png");

        // 2.3 Assert Matchers startPage
    }

    @Test
    public void electricStovePageTest() {
        // ***** Страница "Электрические плиты" *****
        // 3.1 Arrange

        // 3.2 Act
        // Регистрация слушателя событий
        Selenium4Listener listener = new Selenium4Listener();
        WebDriver eventFiringWebDriver = new EventFiringDecorator<>(listener).decorate(driver);

        StartPageSteps startPageSteps = new StartPageSteps(eventFiringWebDriver);
        // Закрыть окно подтверждения города
        startPageSteps.closeCityAgree();
        //Перейти по ссылке Плиты и печи
        startPageSteps.focusOnLinkAppliance();
        startPageSteps.goToStoveAndOvensPage();

        StoveAndOvenPageSteps stoveAndOvenPageSteps = new StoveAndOvenPageSteps(eventFiringWebDriver);
        //Перейти по ссылке Плиты электрические
        stoveAndOvenPageSteps.goToElectricStovePage();

        ElectricStovePageSteps electricStovePageSteps = new ElectricStovePageSteps(eventFiringWebDriver);
        //Скриншот
        JavaScriptHelper.slowScroll();
        ScreenshotHelper.screenshot("25ElectricStove.png");

        // 3.3 Matchers electricStovePage
        ElectricStovePageMatcher electricStovePageMatcher = new ElectricStovePageMatcher(electricStovePageSteps);
        // 3.3.1 Проверить, что в тексте Плиты электрические [количество] товаров количество товаров больше 100
        electricStovePageMatcher.isCountElectricStoveOverOneHundred();
    }

}