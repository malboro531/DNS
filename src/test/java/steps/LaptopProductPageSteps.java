package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.LaptopProductPage;

public class LaptopProductPageSteps {
    // Логгер
    private static Logger logger = LogManager.getLogger(LaptopProductPageSteps.class);

    // Страница "Продукт. Ноутбук"
    private LaptopProductPage laptopProductPage;

    // Конструктор
    public LaptopProductPageSteps(WebDriver driver) {
        // ***** Страница "Продукт. Ноутбук" *****
        laptopProductPage = new LaptopProductPage(driver);
    }

    // Проверка / Утверждение (Матчер)
    public String getPageTitle() {
        logger.info("Страница [Продукт. Ноутбук]: Получение заголовка текущей страницы");
        return laptopProductPage.getPageTitle();
    }

    //Проверить, что в блоке Характеристики заголовок содержит ASUS
    public String getChCompanyAsusEquals() {
        return laptopProductPage.baseElementChCompany().getText();
    }

    //Проверить, что в блоке Характеристики значение Объем оперативной памяти равно 32 ГБ
    public String getChRAMAsusEquals() {
        return laptopProductPage.baseElementChRAM().getText();
    }
}
