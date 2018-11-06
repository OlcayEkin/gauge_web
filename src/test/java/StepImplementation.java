
import browser.Browser;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class StepImplementation extends Browser {

    @Step("Go to <url> page")
    public void navigatePage(String url) {
        getDriver().navigate().to(url);
    }

    @Step("Choose <plate> plate no")
    public void choosePlate(String plateNo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("plateNo")));
        List<WebElement> listElement = getDriver().findElements(By.className("plateNo"));
        for (WebElement element :
                listElement) {
            if (element.getText().equals(plateNo)) {
                element.click();
                break;
            }

        }
    }

    @Step("Set <username> as an username")
    public void setUsername(String username) {
        getDriver().findElement(By.id("UserName")).sendKeys(username);
    }

    @Step("Set <pass> as a pass")
    public void setPass(String pass) {
        getDriver().findElement(By.id("password")).sendKeys(pass);
    }

    @Step("Click submit button")
    public void clickSubmit() {
        getDriver().findElement(By.id("ys-fastlogin-button")).click();
    }

    @Step("Wait main page to be displayed")
    public void waitMainPage() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-info")));
    }

}