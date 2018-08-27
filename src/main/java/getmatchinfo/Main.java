package getmatchinfo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import db.data.MatchRepository;
import db.data.generated.tables.records.MatchesRecord;


import java.io.IOException;
import java.sql.Date;
import java.sql.Time;


public class Main {

    private final static String AUTHENTICATION_KEY_NAME = "X-Auth-Token";
    private final static String AUTHENTICATION_KEY_VALUE = "337b4cfc3f3643b985bdb623ba1d888d";

//  http://api.football-data.org/v2/competitions/2001/matches?stage=group_stage
//  http://api.football-data.org/v2/competitions/2001/matches?dateFrom=2017-09-12&dateTo=2017-09-13
//  http://api.football-data.org/v2/matches?dateFrom=2017-09-12&dateTo=2017-09-13&competitions=2001

    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static Request request;
    private static Response response;
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        request = new Request.Builder()
                .url("http://api.football-data.org/v2/matches?dateFrom=2017-09-12&dateTo=2017-09-13&competitions=2001")
                .header(AUTHENTICATION_KEY_NAME, AUTHENTICATION_KEY_VALUE)
                .build();

        response = okHttpClient.newCall(request).execute();

        String resp = response.body().string();
        int code = response.code();

        System.out.println(code);
        Matches matches = objectMapper.readValue(resp, Matches.class);

        MatchRepository matchRepository = new MatchRepository();
        MatchesRecord matchesRecord = new MatchesRecord();


        for (Match match : matches.getMatches()) {

            matchesRecord.setIdMatch(match.getId());
            matchesRecord.setHomeTeam(match.getHomeTeam().getName());
            matchesRecord.setAwayTeam(match.getAwayTeam().getName());
            matchesRecord.setHomeTeamGoals(match.getScore().getFullTime().getHomeTeam());
            matchesRecord.setAwayTeamGoals(match.getScore().getFullTime().getAwayTeam());
            matchesRecord.setStartDate(Date.valueOf(match.getDate()));
            matchesRecord.setStartTime(Time.valueOf(match.getTime()));
            matchRepository.insert(matchesRecord);

        }
    }

}
