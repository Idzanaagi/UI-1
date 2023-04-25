package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Home {


    WebDriver driver;

    public Home(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a")
    private WebElement logOut;


    public String getLogoutLinkText() {
        return logOut.getText();
    }

    public void clickLogoutBtn() {
        logOut.click();
    }

}
