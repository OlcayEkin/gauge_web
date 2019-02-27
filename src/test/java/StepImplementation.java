
import browser.Browser;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class StepImplementation extends Browser {

    @Step("Go to <url> page")
    public void navigatePage(String url) {
        getDriver().navigate().to(url);
    }


    @Step("Search <item> from the page")
    public void searchPage(String item) {
        getDriver().findElement(By.cssSelector("[title='Ara']")).sendKeys(item);
        getDriver().findElement(By.cssSelector("[title='Ara']")).sendKeys(Keys.ENTER);
    }

    @Step("Select <item> from the page")
    public void searchItem(String item) {
        List<WebElement> listElement = getDriver().findElements(By.tagName("cite"));
        for (WebElement element:
             listElement) {
            if (!element.getText().contains(item)){
                continue;
            }else{
                element.click();
                break;
            }
        }
    }

    @Step("Click GetStarted button on the page")
    public void clickGetStarted() {
        getDriver().findElement(By.cssSelector("[href='/get_started/']")).click();
    }
    @Step("Check Overview")
    public void checkOverview() {
       Assert.assertTrue(getDriver().findElement(By.className("sidebar_get-started")).isDisplayed());
    }
}