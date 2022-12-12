package elements;

import helpers.ActionHelper;
import helpers.WaitHelper;
import org.openqa.selenium.WebElement;

public class Accordeon extends BaseElement{
    // Конструктор
    public Accordeon(WebElement webElement) {
        super(webElement);
    }

    // Раскрытие гармошки
    public void show() {
        // Ожидание кликабельности гармошки
        ActionHelper.moveToElement(webElement);
        WaitHelper.clickabilityOfElement(webElement);
        webElement.click();
    }
}
