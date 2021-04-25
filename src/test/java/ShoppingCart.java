import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ShoppingCart {

    @Test
    public void checkingThe2PercentDiscount() {
        //УСТАНОВКА ПЕРЕМЕННОЙ СРЕДЫ
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, SECONDS);
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
        //УБЕДИТЬСЯ ЧТО МЫ НА СТРАНИЦЕ SIGN UP, ACCOUNT IS CREATED!
        boolean created = driver.findElement(By.cssSelector("[class=confirmation_message]")).isDisplayed();
        Assert.assertTrue(created, "Регистрации не прошла");
        //СОХРАНИТЬ LOGIN И PASSWORD
        String email = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        String password = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]")).getText();
        driver.findElement(By.linkText("here")).click();
        //ПРОИЗВЕСТИ РЕГИСТРАЦИЮ, ЗАПОЛНИВ LOGIN И PASSWORD
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value=Login]")).click();
        // УБЕДИТЬСЯ,ЧТО АВТОРИТИЗАЦИЯ ПРОШЛА УСПЕШНО
        boolean cart = driver.findElement(By.linkText("Shopping Cart")).isDisplayed();
        Assert.assertTrue(cart, "Авторизация не прошла");
//      ВВЕСТИ НАЗВАНИЕ КНИГИ В ПОИСКЕ
        driver.findElement(By.cssSelector("[name=keyword]")).sendKeys("The Adventures of Huckleberry Finn");
        driver.findElement(By.cssSelector("[value=Search]")).click();
//      ДОБАВЛЯЕМ ТОВАР В КОРЗИНУ
        driver.findElement(By.cssSelector("[src=\"../images/add_to_cart.gif\"]")).click();
//      ПЕРЕЙТИ В SHOPPING CART
        driver.findElement(By.cssSelector("[href=\"./shopping_cart.py\"]")).click();
//      ВВЕСТИ КОЛИЧЕСТВО КНИГ
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("20");
//      НАЖАТЬ UPDATE
        driver.findElement(By.cssSelector("[value=Update]")).click();
//      ПРОВЕРЯЕМ СКИДКУ
        String discount = driver.findElement(By.xpath("((//tr)[9]//td)[7]")).getText();
        Assert.assertEquals(discount, "196",
                "Скидка применена некорректно");
        //ЗАКРЫТЬ БРАУЗЕР
        driver.quit();
    }

    @Test
    public void checkingThe8PercentDiscount() {
        //УСТАНОВКА ПЕРЕМЕННОЙ СРЕДЫ
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, SECONDS);
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
        //УБЕДИТЬСЯ ЧТО МЫ НА СТРАНИЦЕ SIGN UP, ACCOUNT IS CREATED!
        boolean created = driver.findElement(By.cssSelector("[class=confirmation_message]")).isDisplayed();
        Assert.assertTrue(created, "Регистрации не прошла");
        //СОХРАНИТЬ LOGIN И PASSWORD
        String email = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        String password = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]")).getText();
        driver.findElement(By.linkText("here")).click();
        //ПРОИЗВЕСТИ РЕГИСТРАЦИЮ, ЗАПОЛНИВ LOGIN И PASSWORD
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value=Login]")).click();
        // УБЕДИТЬСЯ,ЧТО АВТОРИТИЗАЦИЯ ПРОШЛА УСПЕШНО
        boolean cart = driver.findElement(By.linkText("Shopping Cart")).isDisplayed();
        Assert.assertTrue(cart, "Авторизация не прошла");
//      ВВЕСТИ НАЗВАНИЕ КНИГИ В ПОИСКЕ
        driver.findElement(By.cssSelector("[name=keyword]")).sendKeys("The Adventures of Huckleberry Finn");
        driver.findElement(By.cssSelector("[value=Search]")).click();
//      ДОБАВЛЯЕМ ТОВАР В КОРЗИНУ
        driver.findElement(By.cssSelector("[src=\"../images/add_to_cart.gif\"]")).click();
//      ПЕРЕЙТИ В SHOPPING CART
        driver.findElement(By.cssSelector("[href=\"./shopping_cart.py\"]")).click();
//      ВВЕСТИ КОЛИЧЕСТВО КНИГ
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("10000");
//      НАЖАТЬ UPDATE
        driver.findElement(By.cssSelector("[value=Update]")).click();
//      ПРОВЕРЯЕМ СКИДКУ
        String discount = driver.findElement(By.xpath("((//tr)[9]//td)[7]")).getText();
        Assert.assertEquals(discount, "92 000",
                "Скидка применена некорректно");
        //ЗАКРЫТЬ БРАУЗЕР
        driver.quit();
    }
}
