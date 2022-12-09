package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.KitchenAppliancePage;

public class KitchenAppliancePageSteps {
    // Логгер
    private static Logger logger = LogManager.getLogger(KitchenAppliancePageSteps.class);

    // Страница "Техника для кухни"
    private KitchenAppliancePage kitchenAppliancePage;

    // Конструктор
    public KitchenAppliancePageSteps(WebDriver driver) {
        // ***** Страница "Техника для кухни" *****
        kitchenAppliancePage = new KitchenAppliancePage(driver);
    }

    //Вывести в логи названия всех категорий
    public void getLogsCategories() {
        for (WebElement category : kitchenAppliancePage.kitchenCategories()) {
            String categoryName = category.getText();
            logger.info(categoryName);
        }
    }

    //Проверить, что количество категорий больше 5
    public int countKitchenCategories() {
        int sizeKitchenCategories = kitchenAppliancePage.kitchenCategories().size();
        return sizeKitchenCategories;
    }

    //Проверить, что отображается текст Техника для кухни
    public String getKitchenApplianceTitle(){return kitchenAppliancePage.linkKitchenAppliance().getText();}

    //Проверить, что отображается ссылка Собрать свою кухню
    public boolean getLinkAssembleKitchen() {
        boolean isDisplayed = kitchenAppliancePage.linkAssembleKitchen().getWebElement().isDisplayed();
        return isDisplayed;
    }

}
