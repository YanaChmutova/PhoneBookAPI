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

public class AddNewContactPositive implements TestHelper {
    String idResult;
   // @Test
    public void addNewContact() throws IOException {
        ContactModel contactModel = new ContactModel(
                NameAndLastNameGenerator.generateName(),
                NameAndLastNameGenerator.generateLastName(),
                EmailGenerator.generateEmail(7,5,3),
                PhoneNumberGenerator.generatePhoneNumber(),
                AddressGenerator.generateAddress(),"mydesc");

        RequestBody requestBody=RequestBody.create(gson.toJson(contactModel),JSON);
        Request request = new Request.Builder()
                .url(ADD_CONTACT_PATH)
                .addHeader(AuthorizationHeader, PropertiesReaderXML.getProperty("token"))
                .post(requestBody).build();

        Response response = client.newCall(request).execute();
        ContactResponseModel contactResponseModel =
                gson.fromJson(response.body().string(), ContactResponseModel.class);
        String responseMsg = contactResponseModel.getMessage();
        idResult = IdExtractor.extractId(responseMsg);
        System.out.println("Message : "+idResult);
        Assert.assertTrue(response.isSuccessful());
    }
    @Test
    public void deleteContactByID() throws IOException {
        addNewContact();
        Request request = new Request.Builder()
                .url(ADD_CONTACT_PATH+"/"+idResult)
                .addHeader(AuthorizationHeader, PropertiesReaderXML.getProperty("token"))
                .delete()
                .build();
        Response response = client.newCall(request).execute();
        ContactResponseModel contactResponseModel  = gson
                .fromJson(response.body().string(), ContactResponseModel.class);
        System.out.println("Message : "+contactResponseModel.getMessage());
        Assert.assertTrue(response.isSuccessful());
    }
}