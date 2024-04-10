
package okhttp;

import helpers.*;
import models.ContactModel;
import models.ContactResponseModel;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static helpers.IdExtractor.extractId;

public class TestTest implements TestHelper{
    @Test
    public void createDeleteContactByID() throws IOException {
        ContactModel contactModel =
                new ContactModel(
                        NameAndLastNameGenerator.generateName(),
                        NameAndLastNameGenerator.generateLastName(),
                        EmailGenerator.generateEmail(5,5,3),
                        PhoneNumberGenerator.generatePhoneNumber(),
                        AddressGenerator.generateAddress(),
                        "My description");

        RequestBody requestBody = RequestBody.create(gson.toJson(contactModel), JSON);
        Request request = new Request.Builder()
                .url(PropertiesReader.getProperty("getAllContacts"))
                .addHeader(AuthorizationHeader, PropertiesReader.getProperty("token"))
                .post(requestBody)
                .build();
        Response response = client.newCall(request).execute();
        ContactResponseModel contactResponseModel =
                gson.fromJson(response.body().string(), ContactResponseModel.class);
        String id = extractId(contactResponseModel.getMessage());
        request = new Request.Builder()
                .url(PropertiesReader.getProperty("getAllContacts")+"/"+id)
                .addHeader(AuthorizationHeader, PropertiesReader.getProperty("token"))
                .delete()
                .build();

        response = client.newCall(request).execute();
        contactResponseModel = gson.fromJson(response.body().string(),ContactResponseModel.class);
        System.out.println(contactResponseModel.getMessage());
        Assert.assertTrue(response.isSuccessful());
        // kak dostat ID ?  msg.substring(msg.lastIndexOf(" ")+1); No est' drugoi variant


    }

}
