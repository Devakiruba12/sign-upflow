// pages/LoginPage.java
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By email = By.id("email");
    private By password = By.id("pass");
    private By signInButton = By.id("send2");

    public void enterEmail(String emailText) {
        driver.findElement(email).sendKeys(emailText);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }
}
