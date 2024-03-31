package okhttp;

import helpers.PropertiesReader;
import helpers.PropertiesWriter;
import helpers.TestConfig;
import helpers.TestHelper;
import models.AuthenticationRequestModel;
import models.AuthenticationResponseModel;
import models.ErrorModel;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest implements TestHelper {

    @Test
    public void loginPositive() throws IOException {

        AuthenticationRequestModel requestModel = AuthenticationRequestModel
                .username(PropertiesReader.getProperty("existingUserEmail"+"f"))
                .password(PropertiesReader.getProperty("existingUserPassword"));
        System.out.println("REQUEST: "+requestModel.getUsername()+" : "+requestModel.getPassword());

        RequestBody requestBody = RequestBody
                .create(TestConfig.gson.toJson(requestModel),
                        TestConfig.JSON);

        Request request = new Request.Builder()
                .url(PropertiesReader.getProperty("loginPassword"))
                .post(requestBody)
                .build();
        System.out.println("REQ "+request.toString());
        Response response = TestConfig.client.newCall(request).execute();
        System.out.println("Response code: "+response.code());

        if(response.isSuccessful()){

            AuthenticationResponseModel responseModel =
                    TestConfig.gson.fromJson(response.body().string(),
                            AuthenticationResponseModel.class);

            PropertiesWriter.writeProperties("token",responseModel.getToken());

            Assert.assertTrue(response.isSuccessful());
        }
        else {
            System.out.println("Status code : "+response.code());
            ErrorModel errorModel = gson.fromJson(response.body().string(), ErrorModel.class);
            System.out.println("\u001B[32mError status: "+errorModel.getStatus());
            Assert.assertTrue(response.isSuccessful());
        }


    }
}