package helpers;

import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;

public interface TestHelper {

    public static  final MediaType JSON =
            MediaType.get("application/json; charset=utf-8");
    public  static  final Gson gson = new Gson(); // Объект Gson из библиотеки Google Gson используется для преобразования Java объектов в JSON и наоборот.
    public static  final OkHttpClient client = new OkHttpClient();// Объект используется для выполнения HTTP запросов
    public  static final  String FILE_PATH = "src/main/resources/data.xml";
    public static final  String AuthorizationHeader="Authorization"; // Заголовок авторизации, который используется для отправки токена авторизации в запросах.
    public static  final  String REGISTRATION_PATH = "https://contactapp-telran-backend.herokuapp.com/v1/user/registration/usernamepassword";
    public static  final  String ADD_CONTACT_PATH = "https://contactapp-telran-backend.herokuapp.com/v1/contacts";
    public static final String TOKEN_KEY = "token";
    public static  final  String LOGIN_PATH = "https://contactapp-telran-backend.herokuapp.com/v1/user/login/usernamepassword";
    public static  final  String DELETE_ALL_CONTACTS_PATH = "https://contactapp-telran-backend.herokuapp.com/v1/contacts/clear";


}