
package helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdExtractor {
    /* public static void main(String[] args) {
        System.out.println("Res : "
                +extractId("Contact was added! ID: ac452eef-546c-40da-8bab-47520374e461"));
    }
     */
    public static String extractId(String input){
        Pattern pattern = Pattern.compile("ID: (\\S+)");
        Matcher matcher =pattern.matcher(input);
        if (matcher.find()){

            return matcher.group(1);

        }
        else {return null;}

    }
}
