package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.ElectricStovePage;

public class ElectricStovePageSteps {
    // Логгер
    private static Logger logger = LogManager.getLogger(ElectricStovePageSteps.class);

    // Страница "Плиты электрические"
    private ElectricStovePage electricStovePage;

    // Конструктор
    public ElectricStovePageSteps(WebDriver driver) {
        // ***** Страница "Плиты электрические" *****
        electricStovePage = new ElectricStovePage(driver);
        logger.info("Открыта страница [Плиты электрические]");
    }

    // Получение заголовка текущей страницы
    public String getPageTitle() {
        logger.info("Страница [Плиты электричекие]: Получение заголовка текущей страницы");
        return electricStovePage.getPageTitle();
    }


}
