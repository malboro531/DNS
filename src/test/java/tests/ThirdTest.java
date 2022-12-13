package tests;

import helpers.JavaScriptHelper;
import helpers.ScreenshotHelper;
import listeners.Selenium4Listener;
import models.LaptopBL;
import models.LaptopBLBuilder;
import models.valueobjects.Company;
import models.valueobjects.Ram;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import steps.LaptopProductPageSteps;
import steps.LaptopsPageSteps;
import steps.StartPageSteps;
import tests.matchers.LaptopProductPageMatcher;

public class ThirdTest extends BaseTest {
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
        ScreenshotHelper.screenshot("31HomePage.png");
        //Навести курсор на ссылку (Компьютеры и периферия) ПК, ноутбуки, периферия
        startPageSteps.focusOnLinkComputers();
        //Сделать скриншот всей страницы (с прокруткой) после открытия меню
        ScreenshotHelper.screenshot("32linkComputers.png");

        // 1.3 Matchers laptopsPage
    }

    @Test
    public void laptopsPageTest() {
        // ***** Страница "Ноутбуки" *****
        // 2.1 Arrange
        String company = "ASUS";            // производитель
        int ram = 32;                       // объем оперативной памяти

        LaptopBLBuilder builder = new LaptopBLBuilder(
                new Ram(ram),
                new Company(company));
        LaptopBL laptopBL = builder.build(); // Создание объекта

        // 2.2 Act Шаги на странице "Ноутбуки"
        // Регистрация слушателя событий
        Selenium4Listener listener = new Selenium4Listener();
        WebDriver eventFiringWebDriver = new EventFiringDecorator<>(listener).decorate(driver);

        StartPageSteps startPageSteps = new StartPageSteps(eventFiringWebDriver);
        // Закрыть окно подтверждения города
        startPageSteps.closeCityAgree();
        //Перейти по ссылке Ноутбуки
        //Не понимаю че к чему, но без слипа не работает
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        startPageSteps.focusOnLinkComputers();
        startPageSteps.goToLaptopsPage();

        LaptopsPageSteps laptopsPageSteps = new LaptopsPageSteps(eventFiringWebDriver);
        //Сделать скриншот всей страницы (с прокруткой) после загрузки страницы
        JavaScriptHelper.slowScroll();
        ScreenshotHelper.screenshot("33Laptops.png");
        //Скрыть блок страницы
        laptopsPageSteps.getLaptopsBlock().hide();
        //Сделать скриншот всей страницы (с прокруткой) после скрытия блока
        ScreenshotHelper.screenshot("34NoHeader.png");
        //Выбрать в фильтре Производитель значение ASUS
        laptopsPageSteps.filterByCompany(laptopBL.getCompany().getCompany());
        //Выбрать в фильтре Объем оперативной памяти значение 32 ГБ
        laptopsPageSteps.filterByRAM(laptopBL.getRam().getRam());
        //Нажать кнопку Применить
        laptopsPageSteps.applyFilters();
        //Сделать скриншот всей страницы (с прокруткой) после применения фильтров
        JavaScriptHelper.slowScroll();
        ScreenshotHelper.screenshot("35Asus32gb.png");
        //Применить сортировку Сначала дорогие
        String type = "Сначала дорогие";
        laptopsPageSteps.orderBy(type);
        //Сделать скриншот всей страницы (с прокруткой) после применения сортировки
        JavaScriptHelper.slowScroll();
        ScreenshotHelper.screenshot("36Asus32gbExpensive.png");

        // 2.3 Matchers laptopsPage
    }

    @Test
    public void laptopProductPageTest() {
        // ***** Страница "Продукт. Ноутбук" *****
        // 3.1 Arrange
        String company = "ASUS";            // производитель
        int ram = 32;                       // объем оперативной памяти

        LaptopBLBuilder builder = new LaptopBLBuilder(
                new Ram(ram),
                new Company(company));
        LaptopBL laptopBL = builder.build(); // Создание объекта

        // 3.2 Act Шаги на странице "Продукт. Ноутбук"
        // Регистрация слушателя событий
        Selenium4Listener listener = new Selenium4Listener();
        WebDriver eventFiringWebDriver = new EventFiringDecorator<>(listener).decorate(driver);

        StartPageSteps startPageSteps = new StartPageSteps(eventFiringWebDriver);
        // Закрыть окно подтверждения города
        startPageSteps.closeCityAgree();
        //Перейти по ссылке Ноутбуки
        //Не понимаю че к чему, но без слипа не работает
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        startPageSteps.focusOnLinkComputers();
        startPageSteps.goToLaptopsPage();

        LaptopsPageSteps laptopsPageSteps = new LaptopsPageSteps(eventFiringWebDriver);
        //Выбрать в фильтре Производитель значение ASUS
        JavaScriptHelper.scrollBy(0, 1250);
        laptopsPageSteps.filterByCompany(laptopBL.getCompany().getCompany());
        //Выбрать в фильтре Объем оперативной памяти значение 32 ГБ
        laptopsPageSteps.filterByRAM(laptopBL.getRam().getRam());
        //Нажать кнопку Применить
        laptopsPageSteps.applyFilters();
        //Применить сортировку Сначала дорогие
        String type = "Сначала дорогие";
        laptopsPageSteps.orderBy(type);
        //Перейти на страницу первого продукта в списке (новое окно)
        laptopsPageSteps.goToFirstProduct();

        LaptopProductPageSteps laptopProductPageSteps = new LaptopProductPageSteps(eventFiringWebDriver);
        //Сделать скриншот всей страницы (с прокруткой) после загрузки страницы
        ScreenshotHelper.screenshot("37FirstLaptop.png");

        // 3.3 Matchers laptopProductPage
        LaptopProductPageMatcher laptopProductPageMatcher = new LaptopProductPageMatcher(laptopProductPageSteps);
        // 3.3.1 Проверить, что заголовок страницы соответствует ожидаемому
        String expected = "Купить 15.6\" Ноутбук ASUS ZenBook PRO DUO 15 OLED UX582LR-H2006T синий в интернет " +
                "магазине DNS. Характеристики, цена ASUS ZenBook PRO DUO 15 OLED UX582LR-H2006T | 4800982";
        laptopProductPageMatcher.pageTitleEquals(expected);
        // 3.3.2 Проверить, что в блоке Характеристики заголовок содержит ASUS
        String expectedCompany = "ASUS";
        laptopProductPageMatcher.chCompanyAsusEquals(expectedCompany);
        // 3.3.3 Проверить, что в блоке Характеристики значение Объем оперативной памяти равно 32 ГБ
        String expectedRAM = "32";
        laptopProductPageMatcher.chRAMEquals(expectedRAM);
    }

}