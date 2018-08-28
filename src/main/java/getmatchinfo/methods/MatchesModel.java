package getmatchinfo.methods;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import db.data.MatchRepository;
import db.data.generated.tables.records.MatchesRecord;
import getmatchinfo.Match;
import getmatchinfo.Matches;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MatchesModel {

    private final String AUTHENTICATION_KEY_NAME = "X-Auth-Token";
    private final String AUTHENTICATION_KEY_VALUE = "337b4cfc3f3643b985bdb623ba1d888d";

    private OkHttpClient okHttpClient = new OkHttpClient();
    private Request request;
    private Response response;
    private ObjectMapper objectMapper = new ObjectMapper();

    private DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public Matches getMatchesFromApi (String dateFrom, String dateTo) throws IOException {
        request = new Request.Builder()
                .url("http://api.football-data.org/v2/matches?dateFrom="+dateFrom+"&dateTo="+dateTo+"&competitions=2001")
                .header(AUTHENTICATION_KEY_NAME, AUTHENTICATION_KEY_VALUE)
                .build();

        response = okHttpClient.newCall(request).execute();

        String resp = response.body().string();

        Matches matches = objectMapper.readValue(resp, Matches.class);
        return matches;
    }


    public void insertMatchesToDatabase(Matches matches) {
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
