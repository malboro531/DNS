package steps;

import helpers.JavaScriptHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.StoveAndOvenPage;

public class StoveAndOvenPageSteps {
    // Логгер
    private static Logger logger = LogManager.getLogger(StoveAndOvenPageSteps.class);

    // Страница "Плиты и печи"
    private StoveAndOvenPage stovesAndOvensPage;

    // Конструктор
    public StoveAndOvenPageSteps(WebDriver driver) {
        // ***** Страница "Плиты и печи" *****
        stovesAndOvensPage = new StoveAndOvenPage(driver);
        logger.info("Открыта страница [Плиты и печи]");
    }

    // Получение заголовка текущей страницы
    public String getPageTitle() {
        logger.info("Страница [Плиты и печи]: Получение заголовка текущей страницы");
        return stovesAndOvensPage.getPageTitle();
    }

    //Перейти по ссылке Плиты электрические
    public void goToElectricStovePage() {
        // Фокус на элементе
        stovesAndOvensPage.linkElectricStove().focusOnLink();
        // Клик по элементу
        stovesAndOvensPage.linkElectricStove().click();
        logger.info("Открыта страница [Плиты электрические]");
    }

}
