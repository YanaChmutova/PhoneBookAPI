
package okhttp;

import helpers.PropertiesReader;
import helpers.TestHelper;
import models.ContactResponseModel;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.annotations.Test;

import java.io.IOException;

public class DeleteAllContacts implements TestHelper {

    @Test
    public void clearContacts() throws IOException {

        Request request = new Request.Builder()
                .url(DELETE_ALL_CONTACTS_PATH)
                .addHeader(AuthorizationHeader, PropertiesReader.getProperty("token"))
                .delete()
                .build();
        Response response = client.newCall(request).execute();
        System.out.println("Code: "+response.code());
        ContactResponseModel contactResponseModel =
                gson.fromJson(response.body().string(), ContactResponseModel.class);
        System.out.println("MSG: "+contactResponseModel.getMessage());
    }
}
