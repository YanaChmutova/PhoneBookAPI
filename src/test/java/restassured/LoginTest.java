package restassured;

import helpers.EmailGenerator;
import helpers.PasswordStringGenerator;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.AuthenticationRequestModel;
import models.AuthenticationResponseModel;
import models.NewUserModel;
import org.testng.annotations.Test;

import java.lang.annotation.Target;

import static io.restassured.RestAssured.given;

public class LoginTest {
    @Test
    public void registrationTest(){
        NewUserModel newUserModel = new NewUserModel(EmailGenerator.generateEmail(7,7,3),
                PasswordStringGenerator.generateString());
        String token = given().body(newUserModel). contentType(ContentType.JSON)
                .when()
                .post("https://contactapp-telran-backend.herokuapp.com/v1/user/registration/usernamepassword")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("token");
        System.out.println("Token: "+token);
    }

    @Test
    public void loginTestRestAssured(){
        RestAssured.baseURI = "https://contactapp-telran-backend.herokuapp.com/v1/user/login/usernamepassword";
        AuthenticationRequestModel authenticationRequestModel =
                AuthenticationRequestModel.username("qwerty123456@mail.com").password("Zy4121566!");
        AuthenticationResponseModel response = given().body(authenticationRequestModel)
                .contentType(ContentType.JSON)
                .when()
                .post().then().log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .as(AuthenticationResponseModel.class);
        System.out.println("Token :"+response.getToken());
    }
}
