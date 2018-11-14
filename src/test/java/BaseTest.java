import drivers.PropertiesConfigManager;
import drivers.WebDriverSingl;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.IndexPage;
import pages.LoginPage;
import pages.SectionPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    public WebDriverSingl webDriverSingl;
    public PropertiesConfigManager prop;

    public IndexPage indexPage;
    public LoginPage loginPage;
    public SectionPage sectionPage;

    String testURL = "";
    String testBrowser = "";
    String outputFilePath = "";


    @BeforeTest
    public void setUp(){
        prop = new PropertiesConfigManager("config.properties");
        testURL = prop.getProperty("URL");
        testBrowser = prop.getProperty("BROWSER");
        outputFilePath = prop.getProperty("OUTPUT_FILE_PATH");


        webDriverSingl = WebDriverSingl.getInstance(testBrowser);
        driver = webDriverSingl.driver;

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        indexPage = new IndexPage(driver);
        loginPage = new LoginPage(driver);
        sectionPage = new SectionPage(driver);


        driver.get(testURL);
    }

    @AfterTest
    public void tearDown(){
        if(driver != null)
            driver.quit();
    }

}
