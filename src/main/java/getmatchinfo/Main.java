package getmatchinfo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class Main {

    private final String AUTHENTICATION_KEY_NAME = "X-Auth-Token";
    private final String AUTHENTICATION_KEY_VALUE = "337b4cfc3f3643b985bdb623ba1d888d";

//  http://api.football-data.org/v2/competitions/2001/matches?stage=group_stage
//  http://api.football-data.org/v2/competitions/2001/matches?dateFrom=2017-09-12&dateTo=2017-09-13

    private static OkHttpClient okHttpClient;
    private static Request request;
    private static Response response;
    private static ObjectMapper objectMapper;

    public static void main(String[] args) {



    }

}
