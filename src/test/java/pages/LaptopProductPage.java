package pages;

import elements.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

// Страница "Продукт. Ноутбук"
public class LaptopProductPage extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(LaptopProductPage.class);

    // ***** Веб элементы *****
    // Наименование продукта в продукте
    @FindBy(xpath = "//h1[@class='product-card-top__title']")
    private WebElement baseElementNameOfProduct;
    // Кнопка "Развернуть все"
    @FindBy(xpath = "//button[contains(@class, 'product-characteristics__expand')]")
    private WebElement buttonExpandAll;
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
    // Наименование продукта в продукте
    public BaseElement baseElementNameOfProduct() {
        return new BaseElement(baseElementNameOfProduct);
    }

    // Кнопка "Развернуть все"
    public Button buttonExpandAll() {
        return new Button(buttonExpandAll);
    }

    // Модель ноутбука (в характеристиках)
    public BaseElement baseElementChCompany() {
        return new BaseElement(baseElementChCompany);
    }

    // Объем оперативной памяти ноутбука (в характеристиках)
    public BaseElement baseElementChRAM() {
        return new BaseElement(baseElementChRAM);
    }

}