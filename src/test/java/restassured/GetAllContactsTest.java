package restassured;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class GetAllContactsTest {


    @Test
    public void getAllContactsPositive() throws IOException {
        File logFile = new File("src/logs/testresult.log");
        if(!logFile.exists()){
            logFile.getParentFile().mkdirs();
            logFile.createNewFile();
        }
        PrintStream printStream = new PrintStream(new FileOutputStream(logFile));
        System.setOut(printStream);
        System.setErr(printStream);

    }

}
