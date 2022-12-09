package pages;

import elements.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Страница "Плиты и печи"
public class StoveAndOvenPage extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(StoveAndOvenPage.class);

    // ***** Веб элементы *****
    // Ссылка на "Электрические плиты"
    @FindBy(xpath = "(//a[contains(@class, \"catalog-product__name\")])[1]")
    public WebElement linkElectricStove;

    // Конструктор класса
    public StoveAndOvenPage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }

    // ***** Получение обернутых веб элементов *****
    // Ссылка на первый продукт в списке
    public Link linkElectricStove() {return new Link(linkElectricStove);}
}