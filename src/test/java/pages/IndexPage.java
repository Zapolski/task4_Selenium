package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class IndexPage {


    //private WebDriver driver;
    public IndexPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        //this.driver = driver;
    }

    @FindBy(id = "Header__Authentication")
    public WebElement authenticationField;

    @FindBy(id = "yt0")
    private WebElement logoutButton;

    @FindBys( { @FindBy (xpath  = "//div[@class=\"Catalog__SectionMainBlock\"]") })
    public List<WebElement> catalog;

    public void clickAuthenticationField(){
        authenticationField.click();
    }

    public void clickLogoutButton(){
        logoutButton.click();
    }

}
