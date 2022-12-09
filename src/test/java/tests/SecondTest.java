package tests;

import helpers.JavaScriptHelper;
import helpers.ScreenshotHelper;
import org.junit.jupiter.api.Test;
import steps.*;
import tests.matchers.AppliancePageMatcher;
import tests.matchers.ElectricStovePageMatcher;
import tests.matchers.StartPageMatcher;

public class SecondTest extends BaseTest {

    @Test
    public void dnsTest() {
    // 1. Arrange

    // 2. Act
    // 2.1 Шаги на стратовой странице ДНС
        StoveAndOvenPageSteps startPageSteps = startPageSteps();
        startPageMatchers(startPageSteps);
    // 2.2 Шаги на странице "Плиты и печи"
        ElectricStovePageSteps stoveAndOvenPageSteps = stoveAndOvenPageSteps();
    // 2.3 Шаги на странице "Электрические плиты"
        StartPageSteps electricStovePageSteps = electricStovePageSteps();
        electricStovePageMatchers(electricStovePageSteps);
    }

    // 3. Assert
    // 3.1 Matchers startPage
    private void startPageMatchers(StoveAndOvenPageSteps startPageSteps) {
        StartPageMatcher starPageMatcher = new StartPageMatcher(startPageSteps);
        // 3.1.1 Проверить, что отображаются ссылки: Встраиваемая техника, Техника для кухни, Техника для дома
        starPageMatcher.isDisplayedLinkApplianceSubcategories();
    }

    // 3.3 Matchers electricStovePage
    private void electricStovePageMatchers (StartPageSteps electricStovePageSteps){
        ElectricStovePageMatcher electricStovePageMatcher = new ElectricStovePageMatcher(electricStovePageSteps);
        // 3.3.1 Проверить, что в тексте Плиты электрические [количество] товаров количество товаров больше 100
        electricStovePageMatcher.isCountElectricStoveOverOneHundred();
    }


    private StoveAndOvenPageSteps startPageSteps() {
        // ***** Стартовая страница сайта DNS *****
        StartPageSteps startPageSteps = new StartPageSteps(driver);
        // Закрыть окно подтверждения города
        startPageSteps.closeCityAgree();
        //Скриншот
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
        //Перейти по ссылке Плиты и печи
        startPageSteps.goToStoveAndOvensPage();
        return new StoveAndOvenPageSteps(driver);
    }

    private ElectricStovePageSteps stoveAndOvenPageSteps() {
        // ***** Страница "Плиты и печи" *****
        StoveAndOvenPageSteps stoveAndOvenPageSteps = new StoveAndOvenPageSteps(driver);
        //Скриншот
        ScreenshotHelper.screenshot("24StoveAndOven.png");
        //Перейти по ссылке Плиты электрические
        stoveAndOvenPageSteps.goToElectricStovePage();
        return  new ElectricStovePageSteps(driver);
    }

    private StartPageSteps electricStovePageSteps() {
        // ***** Страница "Электрические плиты" *****
        //Скриншот
        ScreenshotHelper.screenshot("25ElectricStove.png");
        return new StartPageSteps(driver);
    }

}