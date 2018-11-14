package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    //private WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        //this.driver = driver;
    }

    @FindBy(id = "LLoginForm_phone")
    private WebElement phoneField;

    @FindBy(id = "LLoginForm_password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Войти']")
    private WebElement loginButton;

    @FindBy(css = ".Header__BlockNameUser")
    private WebElement profileUser;

    public void setPhoneField(CharSequence charSequence){
        phoneField.sendKeys(charSequence);
    }

    public void setPasswordField(CharSequence charSequence){
        passwordField.sendKeys(charSequence);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public String getTextProfileUser(){
        return profileUser.getText();
    }
}
