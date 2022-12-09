package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.StartPage;

import java.util.List;
import java.util.stream.Collectors;

// Шаги на странице "Стартовая"
public class StartPageSteps {
    // Логгер
    private static Logger logger = LogManager.getLogger(StartPageSteps.class);

    // Стартовая страница сайта DNS
    private StartPage startPage;

    // Конструктор
    public StartPageSteps(WebDriver driver) {
        // ***** Стартовая страница сайта DNS *****
        startPage = new StartPage(driver);
        // Открыть сайт https://www.dns-shop.ru/
        startPage.openPage();
        logger.info("Открыта страница [Стартовая страница DNS]");
    }

    //Закрыть окно подтверждения города
    public void closeCityAgree() {
        startPage.buttonYes().click();
        logger.info("Окно подтверждения города закрыто");
    }

    // Навести курсор мыши на ссылку "Бытовая техника"
    public void focusOnLinkAppliance () {
        startPage.linkAppliance().focusOnLink();
    }

    //Навести курсор на ссылку Плиты и печи
    public void focusOnLinkStoveAndOven () {
        startPage.linkStoveAndOvens().focusOnLink();
    }

    //Навести курсор на ссылку (Компьютеры и периферия) ПК, ноутбуки, периферия
    public void focusOnLinkComputers () {startPage.linkComputers().focusOnLink();}


    // Переход на страницу "Бытовая техника"
    public void goToAppliancesPage() {
        // Фокус на элементе
        startPage.linkAppliance().focusOnLink();
        // Нажатие на ссылку "Бытовая техника"
        startPage.linkAppliance().click();
        logger.info("Открыта страница [Бытовая техника]");
    }

    // Переход на страницу "Плиты и печи"
    public void goToStoveAndOvensPage() {
        // Наведение курсора мыши на ссылку "Бытовая техника"
        startPage.linkAppliance().focusOnLink();
        // Нажатие на ссылку "Плиты и печи"
        startPage.linkStoveAndOvens().click();
        logger.info("Открыта страница [Плиты и печи]");
    }

    // Переход на страницу "Ноутбуки"
    public void goToLaptopsPage() {
        // Наведение курсора мыши на ссылку "ПК,ноутбуки,периферия"
        startPage.linkComputers().focusOnLink();
        // Нажатие на ссылку "Ноутбуки"
        startPage.linkLaptops().click();
        logger.info("Открыта страница [Ноутбуки]");
    }

    // Проверить, что отображаются ссылки: Встраиваемая техника, Техника для кухни, Техника для дома
    public List<String> getTextsSubcategories() {
        List<String> textsSubcategories =
                startPage.linksSubcategories().stream().map(WebElement::getText).collect(Collectors.toList());
        return textsSubcategories;
    }

}