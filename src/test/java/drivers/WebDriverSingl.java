package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverSingl {

    private static WebDriverSingl instance;
    private static final String PATH_DRIVERS = "./src/test/resources/";

    public WebDriver driver;

    private WebDriverSingl(){
    }

    public static WebDriverSingl getInstance(String type){

        if (instance==null){

            Browsers typeBrowser = null;
            for (Browsers br : Browsers.values()) {
                if (br.toString().equalsIgnoreCase(type)) {
                    typeBrowser = br;
                }
            }

            if (typeBrowser!=null){
                instance = new WebDriverSingl();
                switch (typeBrowser) {
                    case CHROME:
                        System.setProperty("webdriver.chrome.driver", PATH_DRIVERS + "chromedriver.exe");
                        instance.driver = new ChromeDriver();
                        break;
                    case FIREFOX:
                        System.setProperty("webdriver.gecko.driver", PATH_DRIVERS + "geckodriver.exe");
                        instance.driver = new FirefoxDriver();
                        break;
                    case IEXPLORE:
                        System.setProperty("webdriver.ie.driver", PATH_DRIVERS + "IEDriverServer.exe");
                        instance.driver = new InternetExplorerDriver();
                        break;
                }
            }else{
                System.out.println("Некорректное/неподдерживаемое имя браузера! Драйвер не инициализрован!");
                return null;
            }
        }
        return instance;
    }
}
