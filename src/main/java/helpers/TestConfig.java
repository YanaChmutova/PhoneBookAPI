package helpers;


import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;

public class TestConfig {

    public static final MediaType JSON =
            MediaType.get("application/json; charset=utf-8");
    public static final Gson gson = new Gson();
    public static final OkHttpClient client = new OkHttpClient();
}