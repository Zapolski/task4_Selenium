import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OpenPageTest extends BaseTest{

    @Test
    public void userLogin(){
        //1
        String titleActual = driver.getTitle().toLowerCase();
        Assert.assertTrue(titleActual.contains("shop.by"));

        //2
        indexPage.clickAuthenticationField();
        loginPage.setPhoneField("447659060");
        loginPage.setPasswordField("testa1qa");
        loginPage.clickLoginButton();
        String currentUser = loginPage.getTextProfileUser();
        Assert.assertEquals(currentUser,"userShop.by_20");

        //3-5
        int rnd = (new Random()).nextInt(indexPage.catalog.size());
        String expectedTitleSection = indexPage.catalog.get(rnd).getText();

        Actions builder = new Actions(driver);
        builder.doubleClick(indexPage.catalog.get(rnd)).build().perform();
        //indexPage.catalog.get(rnd).click();


        Assert.assertEquals(sectionPage.titleSection.getText(),expectedTitleSection);

        //6-8
        driver.get(testURL);
        String source = driver.getPageSource();
        writeToFile(outputFilePath,parseSourceToCsv(source));

        WebElement authenticationFieldWithExplicityWait = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("Header__Authentication")));

        authenticationFieldWithExplicityWait.click();
        indexPage.clickLogoutButton();

        //indexPage.clickAuthenticationField();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get(testURL);


        Assert.assertEquals(indexPage.authenticationField.getText(),"Войти");
    }

    private void writeToFile(String filePath, String recordLine){
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(outputFilePath));
            bw.write(recordLine);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {/*NOP*/}
            }
        }
    }

    private String parseSourceToCsv (String source){
        Pattern pattern = Pattern.compile("ModelReviewsHome__NameModel.+?<");
        Matcher matcher = pattern.matcher(source);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()){
            String str = matcher.group();
            str = str.substring(str.lastIndexOf('>')+1,str.length()-1);
            sb.append(str);
            sb.append(',');
        }
        if (sb.length()!=0){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }

}
