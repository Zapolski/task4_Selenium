package drivers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesConfigManager {
    private Properties properties = new Properties();

    //конструктор, инициализирующий менеджера файлом настроек
    public PropertiesConfigManager(String fileName){
        try {
            FileInputStream fis = new FileInputStream("./src/test/java/drivers/"+fileName);
            properties.load(fis);
        } catch (IOException ex) {
            System.out.println("Ошибка открытия конфигурационного файла [" + fileName + "]!");
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public void setProperty(String key,String value) {
        properties.setProperty(key, value);
    }

    /*public static void main(String[] args){
        PropertiesConfigManager prop = new PropertiesConfigManager("config.properties");
        for (String key : prop.properties.stringPropertyNames()){
            System.out.println(key+" "+prop.properties.getProperty(key));
        }
    }*/

}
