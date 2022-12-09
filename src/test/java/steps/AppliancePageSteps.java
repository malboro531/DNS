package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.AppliancePage;

public class AppliancePageSteps {
    // Логгер
    private static Logger logger = LogManager.getLogger(AppliancePageSteps.class);

    // Страница "Бытовая техника"
    private AppliancePage appliancePage;

    // Конструктор
    public AppliancePageSteps(WebDriver driver) {
        // ***** Страница "Продукт. Смартфон" *****
        appliancePage = new AppliancePage(driver);
    }

    //Перейти по ссылке Техника для кухни
    public void goToKitchenAppliancePage() {
        // Фокус на элементе
        appliancePage.linkKitchenAppliance().focusOnLink();
        // Клик по элементу
        appliancePage.linkKitchenAppliance().click();
        logger.info("Открыта страница [Техника для кухни]");
    }

    //Проверить, что отображается текст Бытовая техника
    public String getApplianceTitle() {return appliancePage.linkAppliance().getText();}

}