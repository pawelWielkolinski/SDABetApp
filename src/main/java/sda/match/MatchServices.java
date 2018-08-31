package sda.match;

import org.springframework.stereotype.Service;
import sda.db.data.generated.tables.records.MatchesRecord;
import sda.match.model.Match;
import sda.match.model.Matches;
import sda.match.model.MatchesModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MatchServices {
    public List<MatchesRecord> show(String dateFrom, String dateTo) throws IOException {
        MatchRepository matchRepository = new MatchRepository();
//        MatchesModel matchesModel = new MatchesModel();
//        matchesModel.insertMatchesToDatabase(matchesModel.getMatchesFromApi(dateFrom,dateTo));

        List<MatchesRecord> matches = new ArrayList<>();
        matches = matchRepository.getByDate(dateFrom,dateTo);

        return matches;
    }
}
