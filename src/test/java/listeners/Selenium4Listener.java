package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class Selenium4Listener implements WebDriverListener {
    private Logger logger = LogManager.getLogger(Selenium4Listener.class);

    // После поиска веб элемента
    @Override
    public void afterClick(WebElement element) {
        logger.info("Успешный клик по элементу " + element);
    }
    /*
Хотелось бы укоротить логирование в части element. Я пытался сделать это через сплит: element.getText().split("xpath")[1]
Подбирал разные точки, но результат был один - становилось еще хуже)
Хотелось бы добавить еще протоколирование событий драйвера при переходе на новую страницу, но я не нашел такого метода
в интерфейсе WebDriverListener.
Можно еще сделать перегрузку метода afterClick, добавить параметр String elementName, не использовать параметр element
параметр String elementName передавать вместе с кликом по элементу в Тесте. Тогда будет красиво. Но придется вручную
каждый раз вызывать метод afterClick
     */
}