import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest2 {

    @Test
    public void FieldValidationPasswordAndConfirmPassword1() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Nastya");
        driver.findElement(By.name("last_name")).sendKeys("Martsuta");
        driver.findElement(By.name("email")).sendKeys("Nastya@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("0123");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        Assert.assertEquals(error, "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Аккаунт был создан");
        driver.quit();
    }

    @Test
    public void FieldValidationPasswordAndConfirmPassword2() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Nastya");
        driver.findElement(By.name("last_name")).sendKeys("Martsuta");
        driver.findElement(By.name("email")).sendKeys("Nastya@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("    ");
        driver.findElement(By.name("password2")).sendKeys("    ");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        Assert.assertEquals(error, "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Аккаунт был создан");
        driver.quit();
    }

    @Test
    public void FieldValidationPasswordAndConfirmPassword3() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Nastya");
        driver.findElement(By.name("last_name")).sendKeys("Martsuta");
        driver.findElement(By.name("email")).sendKeys("Nastya@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("Hello");
        driver.findElement(By.name("password2")).sendKeys("HELLO");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        Assert.assertEquals(error, "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Аккаунт был создан");
        driver.quit();
    }


}
