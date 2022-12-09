package pages;

import elements.Button;
import elements.Link;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StartPage extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(StartPage.class);
    // URL страницы
    private final String URL = "https://www.dns-shop.ru/";

    // ***** Веб элементы *****
    // Кнопка "Всё верно" на всплывашке
    @FindBy(xpath = "(//span[text()=\"Всё верно\"]/parent::button)[1]")
    private WebElement buttonYes;
    // Ссылка "Смартфоны и гаджеты"
    @FindBy(xpath = "(//a[contains(text(), \"Смартфоны и гаджеты\")])[1]")
    private WebElement linkSmartsAndGadgets;
    // Ссылка "Смартфоны"
    @FindBy(xpath = "(//a[contains(text(), \"Смартфоны и гаджеты\")])[2]/following::div/a")
    private WebElement linkSmarts;
    // Ссылка "Бытовая техника"
    @FindBy(xpath = "//a[text()=\"Бытовая техника\"]")
    public WebElement linkAppliance;
    // Подкатегории бытовой техники "Встраиваемая техника, Техника для кухни, Техника для дома"
    @FindBy(xpath = "//a[@class=\"ui-link menu-desktop__first-level\"]")
    private List<WebElement> linksSubcategories;
    // Ссылка "Техника для кухни"
    @FindBy(xpath = "//a[text()=\"Техника для кухни\"]")
    private WebElement linkKitchenAppliance;
    // Ссылка "Плиты и печи"
    @FindBy(xpath = "//a[text()=\"Плиты и печи\"]")
    private WebElement linkStoveAndOvens;
    //Ссылка "Плиты электрические"
    @FindBy(xpath = "//span[text()=\"Плиты электрические\"]")
    private WebElement linkElectricStove;
    // Ссылка "ПК, ноутбуки, периферия"
    @FindBy(xpath = "//a[text()=\"ПК, ноутбуки, периферия\"]")
    private WebElement linkComputers;
    // Ссылка "Ноутбуки"
    @FindBy(xpath = "//a[text()=\"Ноутбуки\"]")
    private WebElement linkLaptops;

    // Конструктор класса
    public StartPage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }

    // Получение URL страницы
    public String getURL() {
        return this.URL;
    }

    // Открытие страницы
    public void openPage() {
        driver.get(this.URL);
        logger.info("Открыта страница https://www.dns-shop.ru/");
    }

    // ***** Получение обернутых веб элементов *****
    // Кнопка "Всё верно" на всплывашке
    public Button buttonYes() {
        return new Button(buttonYes);
    }

    // Ссылка "Смартфоны и гаджеты"
    public Link linkSmartsAndGadgets() {
        return new Link(linkSmartsAndGadgets);
    }

    // Ссылка "Смартфоны"
    public Link linkSmarts() {
        return new Link(linkSmarts);
    }

    // Ссылка "Бытовая техника"
    public Link linkAppliance() {
        return new Link(linkAppliance);
    }

    // Подкатегории бытовой техники "Встраиваемая техника, Техника для кухни, Техника для дома"
    public List<WebElement> linksSubcategories() {
        return linksSubcategories;
    }

    // Ссылка "Техника для кухни"
    public Link linkKitchenAppliances() { return new Link(linkKitchenAppliance); }

    // Ссылка "Плиты и печи"
    public Link linkStoveAndOvens() { return new Link(linkStoveAndOvens); }

    // Ссылка "Плиты электрические"
    public Link linkElectricStove() { return new Link(linkElectricStove); }

    // Ссылка "ПК, ноутбуки, периферия"
    public Link linkComputers() { return new Link(linkComputers); }

    // Ссылка "Ноутбуки"
    public Link linkLaptops() { return new Link(linkLaptops); }
}
