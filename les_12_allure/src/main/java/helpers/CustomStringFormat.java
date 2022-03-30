package helpers;

import org.openqa.selenium.By;

public class CustomStringFormat {
    public static By formatStringToXpath(String abstractString, String argument) {
        return By.xpath(String.format(abstractString, argument));
    }
}
