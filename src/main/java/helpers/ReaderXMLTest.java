package helpers;

public class ReaderXMLTest{
    public static void main(String[] args) {
        String key = "user001";
        String PROPERTIES_PATH = "src/main/resources/data.xml";
        PropertiesWriterXML.setProperties(key, "John", true);
        PropertiesWriterXML propertiesWriterXML = new PropertiesWriterXML(PROPERTIES_PATH);
        String res = PropertiesReaderXML.getProperty(key);
        System.out.println("RESULT: "+res);
    }
}
