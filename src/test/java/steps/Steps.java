package steps;

import driverSingleton.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CreateNewMailPage;
import pages.LoginPage;


public class Steps {
    private WebDriver driver;

    public void initBrowser() {
        driver = DriverSingleton.getDriver();
    }

    public void closeDriver() {
        DriverSingleton.closeDriver();
    }

    public void loginMailRu(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login(username, password);
    }

    public boolean isLoggedIn(String username) {
        WebElement linkLoggedInUser = (new WebDriverWait(driver, 5000))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='PH_user-email']")));

        LoginPage loginPage = new LoginPage(driver);
        String actualUsername = loginPage.getLoggedInUserName().trim().toLowerCase();
        System.out.println("Actual username: " + actualUsername);
        return actualUsername.equals(username);
    }

    public void createNewMail(String addressee, String subject, String body) {
        CreateNewMailPage createNewMailPage = new CreateNewMailPage(driver);
        createNewMailPage.clickOnNewMail();
        createNewMailPage.fields(addressee, subject, body);
    }

    public boolean isSavedInDrafts(String draft) {
        WebElement mail_in_drafts = (new WebDriverWait(driver, 5000))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/messages/drafts']")));

        CreateNewMailPage createNewMailPage = new CreateNewMailPage(driver);
        String actualDraft = createNewMailPage.getDraft().trim().toLowerCase();
        System.out.println("Saved in: " + actualDraft);
        return actualDraft.equals(draft);
    }
}







