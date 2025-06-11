// SignUpSteps.java
package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.SignUpPage;
import pages.LoginPage;
import utils.TestData;

import java.util.UUID;

public class SignUpLoginSteps {

    WebDriver driver;
    SignUpPage signUpPage;
    LoginPage loginPage;

    @Given("user is on the create account page")
    public void user_is_on_create_account_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
        signUpPage = new SignUpPage(driver);
    }

    @When("user enters valid details and submits the form")
    public void user_enters_valid_details_and_submits_form() {
        String uniqueEmail = "user_" + UUID.randomUUID().toString().substring(0, 5) + "@testmail.com";
        TestData.createdEmail = uniqueEmail;

        signUpPage.enterFirstName("Deva");
        signUpPage.enterLastName("Test");
        signUpPage.enterEmail(uniqueEmail);
        signUpPage.enterPassword(TestData.PASSWORD);
        signUpPage.enterConfirmPassword(TestData.PASSWORD);
        signUpPage.clickCreateAccount();
    }

    @Then("account should be created successfully")
    public void account_should_be_created_successfully() {
        System.out.println("Account creation successful: " + TestData.createdEmail);
        driver.quit();
    }

    @Given("user is on the login page")
    public void user_is_on_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
        loginPage = new LoginPage(driver);
    }

    @When("user enters valid credentials")
    public void user_enters_valid_credentials() {
        System.out.println("Logging in with: " + TestData.createdEmail);
        loginPage.enterEmail(TestData.createdEmail);
        loginPage.enterPassword(TestData.PASSWORD);
        loginPage.clickSignIn();
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        System.out.println("Login successful for: " + TestData.createdEmail);
        driver.quit();
    }
}
