package sda.match;

import sda.match.model.Matches;
import sda.match.model.MatchesModel;

import java.io.IOException;
import java.time.LocalDate;

public class Main {

//  http://api.football-data.org/v2/competitions/2001/matches?stage=group_stage
//  http://api.football-data.org/v2/competitions/2001/matches?dateFrom=2017-09-12&dateTo=2017-09-13
//  http://api.football-data.org/v2/matches?dateFrom=2017-09-12&dateTo=2017-09-13&competitions=2001

    public static void main(String[] args) throws IOException {

        MatchesModel matchesModel = new MatchesModel();
        Matches matchesFromApi = matchesModel.getMatchesFromApi("2018-09-18","2018-09-20");
        matchesModel.insertMatchesToDatabase(matchesFromApi);


    }

}
