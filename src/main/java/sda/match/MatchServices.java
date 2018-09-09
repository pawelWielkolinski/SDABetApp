package sda.match;

import org.springframework.stereotype.Service;
import sda.db.data.generated.tables.records.MatchesRecord;
import sda.match.model.Match;
import sda.match.model.Matches;
import sda.match.model.MatchesModel;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<MatchesRecord> showWithLimit() throws IOException {
        MatchRepository matchRepository = new MatchRepository();
//        MatchesModel matchesModel = new MatchesModel();
//        matchesModel.insertMatchesToDatabase(matchesModel.getMatchesFromApi(dateFrom,dateTo));

        List<MatchesRecord> matches = new ArrayList<>();
        matches = matchRepository.getByDateLimit5();

        return matches;
    }

    public List<MatchesRecord> showByName(String name) throws IOException{
        MatchRepository matchRepository = new MatchRepository();

        List<MatchesRecord> matches = new ArrayList<>();
        matches = matchRepository.getByTeamName(name);

        return matches;
    }

    public Map<Integer, Boolean> getVisibleMatches(List<MatchesRecord> matches) {
        Map<Integer, Boolean> visibleButtons = new HashMap<>();
        for (MatchesRecord match : matches) {

            boolean visible = isVisible(match);

            visibleButtons.put(match.getIdMatch(), visible);
        }
        return visibleButtons;
    }

    public boolean isVisible(MatchesRecord match) {
        return match.getStartDate().toLocalDate().isAfter(LocalDate.now())
                        || (match.getStartDate().toLocalDate().compareTo(LocalDate.now()) == 0
                        && match.getStartTime().toLocalTime().isAfter(LocalTime.now()));
    }
}
