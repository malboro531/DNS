package steps;

import elements.Block;
import helpers.JavaScriptHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.LaptopsPage;

public class LaptopsPageSteps {
    // Логгер
    private static Logger logger = LogManager.getLogger(LaptopsPageSteps.class);

    // Страница "Ноутбуки"
    private LaptopsPage laptopsPage;

    // Конструктор
    public LaptopsPageSteps(WebDriver driver) {
        // ***** Страница "Ноутбуки" *****
        laptopsPage = new LaptopsPage(driver);
    }

    //Скрыть блок страницы
    public Block getLaptopsBlock() {
        return laptopsPage.blockHeader();
    }

    // Установка фильтра "Производитель"
    public void filterByCompany(String company) {
        //Установка фильтра "Производитель"
        laptopsPage.checkboxCompany(company).setChecked(true);
        logger.info("Страница [Ноутбуки]: Установка фильтра \"Производитель\" - <" + company + ">");
    }

    //Выбрать в фильтре Объем оперативной памяти значение 32 ГБ
    public void filterByRAM(int ram) {
        // Отображение фильтра "Объем оперативной памяти"
        laptopsPage.accordeonRAM().show();
        // Установка фильтра "Объем оперативной памяти"
        laptopsPage.checkboxRAM(ram + " ГБ").setChecked(true);
        logger.info("Страница [Ноутбуки]: Установка фильтра \"Объем оперативной памяти\" - <" + ram + " ГБ>");
    }

    //Нажать кнопку Применить
    public void applyFilters() {
        // Прокрутка страницы вверх
        JavaScriptHelper.scrollBy(0, 500);
        // Нажатие на кнопку "Применить"
        laptopsPage.buttonApply().click();
        logger.info("Страница [Ноутбуки]: Применение фильтров");
    }

    //Применить сортировку Сначала дорогие
    public void orderBy(String type) {
        // Отображение сортировки
        laptopsPage.accordeonSort().show();
        // Установка сортировки
        laptopsPage.radiobuttonSort(type).setSelected(true);
        logger.info("Страница [Ноутбуки]: Установка сортировки <" + type + ">");
    }

    //Перейти на страницу первого продукта в списке (новое окно)
    public void goToFirstProduct() {
        // Прокрутка страницы вверх
        JavaScriptHelper.scrollBy(0, -2000);
        // Нажатие на ссылку первого продукта в списке
        laptopsPage.linkFirstProduct().openInNewWindow();
        logger.info("Страница [Ноутбуки]: Переход на страницу первого продукта в списке");
    }

}
