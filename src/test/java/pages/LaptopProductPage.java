package pages;

import elements.BaseElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Страница "Продукт. Ноутбук"
public class LaptopProductPage extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(LaptopProductPage.class);

    // ***** Веб элементы *****
    //Модель ноутбука (в характеристиках)
    @FindBy(xpath = "//button[contains(@class, 'product-characteristics__expand')]")
    private WebElement baseElementChCompany;
    //Объем оперативной памяти ноутбука (в характеристиках)
    @FindBy(xpath = "//button[contains(@class, 'product-characteristics__expand')]")
    private WebElement baseElementChRAM;

    // Конструктор класса
    public LaptopProductPage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }

    // ***** Получение обернутых веб элементов *****

    // Модель ноутбука (в характеристиках)
    public BaseElement baseElementChCompany() {
        return new BaseElement(baseElementChCompany);
    }

    // Объем оперативной памяти ноутбука (в характеристиках)
    public BaseElement baseElementChRAM() {
        return new BaseElement(baseElementChRAM);
    }

}