package sda.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sda.bet.BetForm;
import sda.db.data.generated.tables.records.MatchesRecord;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MatchController {

    @Autowired
    private MatchServices matchServices;
    @Autowired
    private HttpSession session;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("matchDate", new MatchDate());
        return "index";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute MatchDate matchDate, Model model) throws IOException {
        List<MatchesRecord> matches = matchServices.show(matchDate.getDateFrom(), matchDate.getDateTo());

        model.addAttribute("matches", matches);

        Map<Integer, Boolean> visibleButtons = new HashMap<>();
        for (MatchesRecord match : matches) {

            boolean visible = match.getStartDate().toLocalDate().isAfter(LocalDate.now())
                    || (match.getStartDate().toLocalDate().compareTo(LocalDate.now()) == 0
                    && match.getStartTime().toLocalTime().isAfter(LocalTime.now()));

            visibleButtons.put(match.getIdMatch(), visible);
        }

        model.addAttribute("visible", visibleButtons);
        model.addAttribute("matchToBet", new MatchToBet());

        return "matches";
    }

    @PostMapping("/toBet")
    public String toBet(@ModelAttribute MatchToBet matchToBet, Model model) {
        BetForm betForm = new BetForm();
        MatchRepository matchRepository = new MatchRepository();

        betForm.setHomeTeamName(matchRepository.getById(matchToBet.getIdMatchToBet()).getHomeTeam());
        betForm.setAwayTeamName(matchRepository.getById(matchToBet.getIdMatchToBet()).getAwayTeam());
        betForm.setMatchId(matchToBet.getIdMatchToBet());
        betForm.setUserId((Integer) session.getAttribute("idUser"));

        model.addAttribute("betInfo", betForm);

        return "bet";
    }

}
