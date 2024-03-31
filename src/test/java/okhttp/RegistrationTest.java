package okhttp;

import helpers.PropertiesWriterXML;
import helpers.TestConfig;
import helpers.TestHelper;
import models.AuthenticationResponseModel;
import models.ErrorModel;
import models.NewUserModel;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegistrationTest implements TestHelper {

    @Test
    public void RegistrationPositive() throws IOException {
        NewUserModel newUserModel =
                new NewUserModel("mythirdmaile@mail.org","qweAwSD123!");
        RequestBody requestBody = RequestBody.create(gson.toJson(newUserModel), JSON);
        Request request = new Request.Builder()
                .url(REGISTRATION_PATH)
                .post(requestBody)
                .build();
        Response response = client.newCall(request).execute();
        String res = response.body().string();
        System.out.println("Response: "+res);
        if (response.isSuccessful()){
            AuthenticationResponseModel responseModel =
                    gson.fromJson(res, AuthenticationResponseModel.class);
            String resultToken = responseModel.getToken();
            System.out.println("Token: "+responseModel.getToken());
            System.out.println("Code: "+response.code());
            PropertiesWriterXML propertiesWriterXML= new PropertiesWriterXML(FILE_PATH);
            propertiesWriterXML.setProperties(TOKEN_KEY, resultToken, false);
            Assert.assertTrue(response.isSuccessful());
        }
        else {
            ErrorModel errorModel = gson.fromJson(res, ErrorModel.class);
            System.out.println("STATUS : "+errorModel.getStatus());
            System.out.println("ERROR : "+errorModel.getError());
            System.out.println("MESSAGE : "+errorModel.getMessage());
            System.out.println(response.code());
        }

    }


}