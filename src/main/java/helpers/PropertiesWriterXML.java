package helpers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesWriterXML {

    public PropertiesWriterXML(String filePath) {
        this.filePath = filePath;
    }
    private static String filePath;
    static Properties properties = new Properties();


    // public PropertiesWriterXML(Properties properties) {this.properties = properties;    }

    //public PropertiesWriterXML() {}


    public static void setProperties(String key, String value, boolean clearFile){
        if(!clearFile){
            try( FileInputStream inputStream = new FileInputStream(filePath)){
                properties.loadFromXML(inputStream);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        properties.setProperty(key, value);
        try(FileOutputStream outputStream = new FileOutputStream(filePath)){
            properties.storeToXML(outputStream, null);
        }
        catch (IOException e){e.printStackTrace();}
    }



}