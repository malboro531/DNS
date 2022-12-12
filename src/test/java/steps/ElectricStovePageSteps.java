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
    }

    // Получение заголовка текущей страницы
    public String getPageTitle() {
        logger.info("Страница [Плиты электричекие]: Получение заголовка текущей страницы");
        return electricStovePage.getPageTitle();
    }

    //Проверить, что в тексте Плиты электрические [количество] товаров количество товаров больше 100
    public int intCountElectricStove() {
        int countElectricStove = Integer.parseInt(electricStovePage.intCountElectricStove());
        return countElectricStove;
    }

}
