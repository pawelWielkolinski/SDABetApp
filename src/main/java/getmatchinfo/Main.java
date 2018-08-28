package getmatchinfo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import db.data.MatchRepository;
import db.data.generated.tables.records.MatchesRecord;
import getmatchinfo.methods.MatchesModel;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

public class Main {

//  http://api.football-data.org/v2/competitions/2001/matches?stage=group_stage
//  http://api.football-data.org/v2/competitions/2001/matches?dateFrom=2017-09-12&dateTo=2017-09-13
//  http://api.football-data.org/v2/matches?dateFrom=2017-09-12&dateTo=2017-09-13&competitions=2001

    public static void main(String[] args) throws IOException {

        MatchesModel matchesModel = new MatchesModel();
        Matches matchesFromApi = matchesModel.getMatchesFromApi("2017-07-01","2017-07-10");
        matchesModel.insertMatchesToDatabase(matchesFromApi);
    }

}
