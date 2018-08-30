package sda.match;

import org.springframework.stereotype.Service;
import sda.match.model.Match;
import sda.match.model.Matches;
import sda.match.model.MatchesModel;

import java.io.IOException;

@Service
public class MatchServices {
    public String show(String dateFrom, String dateTo) throws IOException {
        MatchesModel matchesModel = new MatchesModel();
        StringBuffer stringBuffer = new StringBuffer();
        String result;

        Matches matches = matchesModel.getMatchesFromApi(dateFrom, dateTo);

        for (Match match : matches.getMatches()) {
            stringBuffer.append(match.toString());
        }

        result = String.valueOf(stringBuffer);

        return result;
    }
}
