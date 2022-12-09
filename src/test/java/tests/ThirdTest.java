package tests;

import helpers.JavaScriptHelper;
import helpers.ScreenshotHelper;
import models.LaptopBL;
import models.LaptopBLBuilder;
import models.valueobjects.Company;
import models.valueobjects.Ram;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import steps.ElectricStovePageSteps;
import steps.LaptopProductPageSteps;
import steps.LaptopsPageSteps;
import steps.StartPageSteps;
import tests.matchers.ElectricStovePageMatcher;
import tests.matchers.LaptopProductPageMatcher;

public class ThirdTest extends BaseTest {
    @Test
    public void dnsTest() {
    // 1. Arrange
        String company = "ASUS";            // производитель
        int ram = 32;                       // объем оперативной памяти

        LaptopBLBuilder builder = new LaptopBLBuilder(
                new Ram(ram),
                new Company(company));
        LaptopBL laptopBL = builder.build(); // Создание объекта

    // 2. Act
    // 2.1 Шаги на стартовой странице ДНС
        LaptopsPageSteps startPageSteps = startPageSteps();
    // 2.2 Шаги на странице "Ноутбуки"
        LaptopProductPageSteps laptopsPageSteps = laptopsPageSteps(laptopBL);
    // 2.3 Шаги на странице "Ноутбук"
        StartPageSteps laptopProductPageSteps = laptopProductPageSteps();
        laptopProductPageMatchers(laptopProductPageSteps);
    }

    // 3. Assert
    // 3.3 Matchers laptopProductPage
    private void laptopProductPageMatchers (StartPageSteps laptopProductPageSteps){
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

    private LaptopsPageSteps startPageSteps() {
        // ***** Стартовая страница сайта DNS *****
        StartPageSteps startPageSteps = new StartPageSteps(driver);
        //Закрыть окно подтверждения города
        startPageSteps.closeCityAgree();
        //Сделать скриншот всей страницы (с прокруткой) после загрузки страницы
        ScreenshotHelper.screenshot("31HomePage.png");
        //Навести курсор на ссылку (Компьютеры и периферия) ПК, ноутбуки, периферия
        startPageSteps.focusOnLinkComputers();
        //Сделать скриншот всей страницы (с прокруткой) после открытия меню
        ScreenshotHelper.screenshot("32linkComputers.png");
        //Перейти по ссылке Ноутбуки
        startPageSteps.goToLaptopsPage();
        return new LaptopsPageSteps(driver);
    }

    private LaptopProductPageSteps laptopsPageSteps(LaptopBL laptopBL) {
        // ***** Страница "Ноутбуки" *****
        LaptopsPageSteps laptopsPageSteps = new LaptopsPageSteps(driver);
        //Сделать скриншот всей страницы (с прокруткой) после загрузки страницы
        ScreenshotHelper.screenshot("33Laptops.png");
        //Скрыть блок страницы
        JavaScriptHelper.displayNone((WebElement) laptopsPageSteps.getLaptopsBlock());
        //Сделать скриншот всей страницы (с прокруткой) после скрытия блока
        ScreenshotHelper.screenshot("34NoHeader.png");
        //Выбрать в фильтре Производитель значение ASUS
        laptopsPageSteps.filterByCompany(laptopBL.getCompany().getCompany());
        //Выбрать в фильтре Объем оперативной памяти значение 32 ГБ
        laptopsPageSteps.filterByRAM(laptopBL.getRam().getRam());
        //Нажать кнопку Применить
        laptopsPageSteps.applyFilters();
        //Сделать скриншот всей страницы (с прокруткой) после применения фильтров
        ScreenshotHelper.screenshot("35Asus32gb");
        //Применить сортировку Сначала дорогие
        String type = "Сначала дорогие";
        laptopsPageSteps.orderBy(type);
        //Сделать скриншот всей страницы (с прокруткой) после применения сортировки
        ScreenshotHelper.screenshot("36Asus32gbExpensive.png");
        //Перейти на страницу первого продукта в списке (новое окно)
        laptopsPageSteps.goToFirstProduct();
        return new LaptopProductPageSteps(driver);
    }

    private StartPageSteps laptopProductPageSteps() {
        // ***** Страница "Продукт. Ноутбук" *****
        //Сделать скриншот всей страницы (с прокруткой) после загрузки страницы
        ScreenshotHelper.screenshot("37FirstLaptop.png");
        return new StartPageSteps(driver);
    }
}
