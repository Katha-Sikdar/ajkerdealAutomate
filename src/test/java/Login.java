import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class Login {

    WebDriver driver;
    @BeforeAll
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @DisplayName("Visit URL and check if title is showing properly")
    @Test
    public void visitUrl() {
        driver.get("https://ajkerdeal.com/");
        String CurrentUrl = driver.getCurrentUrl();
        String actualResult = driver.getTitle();
        String expectedResult = "Online Shopping BD: Fashion, Electronics & Gadgets | Ajkerdeal";
        Assertions.assertEquals(actualResult, expectedResult);
        Assertions.assertTrue(CurrentUrl.contains("ajkerdeal"));
        //.out.println(driver.getPageSource());
    }

    @Test
    public void UserRegister(){

        driver.get("https://ajkerdeal.com/customers/registersingleorder.aspx");
        List<WebElement> infos=driver.findElements(By.className("form-control"));
        infos.get(1).sendKeys("Katha");
        infos.get(2).sendKeys("01778901769");
        infos.get(3).sendKeys("kat@gmail.com");
        infos.get(4).sendKeys("kat@123456");
        infos.get(5).sendKeys("kat@123456");
        WebElement radiobtn=driver.findElement(By.xpath("//input[@id='FemaleRadioButton']"));
        radiobtn.click();
        driver.findElements(By.tagName("input")).get(15).click();
        //driver.findElement((By.ByCssSelector("[type=
        System.out.println("Registration successfull");

    }

    @Test

    public void userLogin(){
        driver.get("https://ajkerdeal.com/#");

        WebElement loginButton = driver.findElement(By.id("hover-Id"));
        loginButton.click();

        // Find the username/email input field and enter the email

        List <WebElement> emailField = driver.findElements(By.tagName("input"));
        emailField.get(0).sendKeys("kat@gmail.com");

        List <WebElement> passfield = driver.findElements(By.tagName("input"));
        passfield.get(1).sendKeys("kat@123456");


        // Click on the submit/login button
        WebElement loginbtn = driver.findElement(By.xpath("//header/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/div[1]/div[1]/ul[1]/div[3]/input[1]"));
        loginbtn.click();





    }




@AfterAll
    public void finishTest(){
        //driver.quit();
    }
}
