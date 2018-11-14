package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SectionPage {
    //private WebDriver driver;

    public SectionPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        //this.driver = driver;
    }

    @FindBy (css = ".Page__TitleActivePage.PageSection__TitleActivePage")
    public WebElement titleSection;


}
