import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest {

    @Test
    public void zipCodeShouldAccept5Digits() {
        //УСТАНОВКА ПЕРЕМЕННОЙ СРЕДЫ
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //ОТКРЫТЬ СТРАНИЦУ https://sharelane.com/cgi-bin/register.py
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //ВВЕСТИ ЛЮБЫЕ 5 ЦИФР (НАПРИМЕР 12345)
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //НАЖАТЬ КНОПКУ CONTINUE
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //УБЕДИТЬСЯ ЧТО МЫ НА СТРАНИЦЕ SIGN UP
        boolean isOpened = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        Assert.assertTrue(isOpened, "Страница регистрации не открылась");
        //ЗАКРЫТЬ БРАУЗЕР
        driver.quit();
    }

    @Test
    public void zipCodeShouldNotAccept6Digits() {
        //УСТАНОВКА ПЕРЕМЕННОЙ СРЕДЫ
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //ОТКРЫТЬ СТРАНИЦУ https://sharelane.com/cgi-bin/register.py
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //ВВЕСТИ ЛЮБЫЕ 6 ЦИФР (НАПРИМЕР 123456)
        driver.findElement(By.name("zip_code")).sendKeys("123456");
        //НАЖАТЬ КНОПКУ CONTINUE
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        String error = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        Assert.assertEquals(error, "Oops, error on page. ZIP code should have 5 digits",
                "Сообщение об ошибке (zipcode) некорректное");
        //ЗАКРЫТЬ БРАУЗЕР
        driver.quit();
    }

    @Test
    public void zipCodeShouldNotAccept4Digits() {
        //УСТАНОВКА ПЕРЕМЕННОЙ СРЕДЫ
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //ОТКРЫТЬ СТРАНИЦУ https://sharelane.com/cgi-bin/register.py
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //ВВЕСТИ ЛЮБЫЕ 4 ЦИФРs (НАПРИМЕР 1234)
        driver.findElement(By.name("zip_code")).sendKeys("1234");
        //НАЖАТЬ КНОПКУ CONTINUE
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        String error = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        Assert.assertEquals(error, "Oops, error on page. ZIP code should have 5 digits",
                "Сообщение об ошибке (zipcode) некорректное");
        //ЗАКРЫТЬ БРАУЗЕР
        driver.quit();
    }

    @Test
    public void successfulSignUp() {
        //УСТАНОВКА ПЕРЕМЕННОЙ СРЕДЫ
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //ОТКРЫТЬ СТРАНИЦУ https://sharelane.com/cgi-bin/register.py
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //ВВЕСТИ ЛЮБЫЕ 5 ЦИФР (НАПРИМЕР 12345)
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //НАЖАТЬ КНОПКУ CONTINUE
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Nastya");
        driver.findElement(By.name("last_name")).sendKeys("Martsuta");
        driver.findElement(By.name("email")).sendKeys("Nastya@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        Assert.assertEquals(error, "Account is created!",
                "Аккаунт не был создан");
        //ЗАКРЫТЬ БРАУЗЕР
        driver.quit();
    }

    @Test
    public void FieldValidationFirstName1() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Nastya-Nastya");
        driver.findElement(By.name("last_name")).sendKeys("Martsuta");
        driver.findElement(By.name("email")).sendKeys("Nastya@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        Assert.assertEquals(error, "Account is created!",
                "Аккаунт не был создан");
        driver.quit();
    }

    @Test
    public void FieldValidationFirstName2() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("d'Nastya");
        driver.findElement(By.name("last_name")).sendKeys("Martsuta");
        driver.findElement(By.name("email")).sendKeys("Nastya@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        Assert.assertEquals(error, "Account is created!",
                "Аккаунт не был создан");
        driver.quit();
    }

    @Test
    public void FieldValidationLastName1() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Nastya");
        driver.findElement(By.name("last_name")).sendKeys("1");
        driver.findElement(By.name("email")).sendKeys("Nastya@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        Assert.assertEquals(error, "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Аккаунт был создан");
        driver.quit();
    }

    @Test
    public void FieldValidationLastName2() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Nastya");
        driver.findElement(By.name("last_name")).sendKeys("Й");
        driver.findElement(By.name("email")).sendKeys("Nastya@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        Assert.assertEquals(error, "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Аккаунт был создан");
        driver.quit();
    }

    @Test
    public void FieldValidationLastName3() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Nastya");
        driver.findElement(By.name("last_name")).sendKeys("$");
        driver.findElement(By.name("email")).sendKeys("Nastya@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        Assert.assertEquals(error, "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Аккаунт был создан");
        driver.quit();
    }

    @Test
    public void FieldValidationEmail1() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Nastya");
        driver.findElement(By.name("last_name")).sendKeys("Martsuta");
        driver.findElement(By.name("email")).sendKeys("Nastya Nastya@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        Assert.assertEquals(error, "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Аккаунт был создан");
        driver.quit();
    }

    @Test
    public void FieldValidationEmail2() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Nastya");
        driver.findElement(By.name("last_name")).sendKeys("Martsuta");
        driver.findElement(By.name("email")).sendKeys("Nastya@mail.ru&&&");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        Assert.assertEquals(error, "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Аккаунт был создан");
        driver.quit();
    }

    @Test
    public void FieldValidationEmail3() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Nastya");
        driver.findElement(By.name("last_name")).sendKeys("Martsuta");
        driver.findElement(By.name("email")).sendKeys("@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        Assert.assertEquals(error, "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Аккаунт был создан");
        driver.quit();
    }

    @Test
    public void FieldValidationEmail4() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Nastya");
        driver.findElement(By.name("last_name")).sendKeys("Martsuta");
        driver.findElement(By.name("email")).sendKeys("Nastya@ma il.ru");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        Assert.assertEquals(error, "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Аккаунт был создан");
        driver.quit();
    }
}
