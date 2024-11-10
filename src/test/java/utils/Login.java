package utils;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class Login {

    public static void visitUrl(WebDriver driver) {

        driver.get("https://ajkerdeal.com/");
        String CurrentUrl = driver.getCurrentUrl();
        String actualResult = driver.getTitle();
        String expectedResult = "Online Shopping BD: Fashion, Electronics & Gadgets | Ajkerdeal";
        Assertions.assertEquals(actualResult, expectedResult);
        Assertions.assertTrue(CurrentUrl.contains("ajkerdeal"));
        System.out.println(driver.getPageSource());
    }
}
