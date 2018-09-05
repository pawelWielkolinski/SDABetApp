package sda.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sda.bet.BetForm;
import sda.bet.BetRepository;
import sda.bet.BetService;
import sda.db.data.generated.tables.records.MatchesRecord;
import sda.user.UserService;

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
    @Autowired
    private BetService betService;


    @RequestMapping("/")
    public String home(Model model) throws IOException {
        model.addAttribute("matchDate", new MatchDate());
        model.addAttribute("matchTeamName", new MatchTeamName());

        List<MatchesRecord> matches = matchServices.showWithLimit();

        model.addAttribute("matches", matches);

        Map<Integer, Boolean> visibleButtons = matchServices.getVisibleMatches(matches);

        model.addAttribute("visible", visibleButtons);
        model.addAttribute("matchToBet", new MatchToBet());

        BetRepository betRepository = new BetRepository();

        model.addAttribute("betRepo", betRepository);

        betService.givePoints();

        return "index";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute MatchDate matchDate, Model model) throws IOException {
        List<MatchesRecord> matches = matchServices.show(matchDate.getDateFrom(), matchDate.getDateTo());

        model.addAttribute("matches", matches);

        Map<Integer, Boolean> visibleButtons = matchServices.getVisibleMatches(matches);

        model.addAttribute("visible", visibleButtons);
        model.addAttribute("matchToBet", new MatchToBet());

        BetRepository betRepository = new BetRepository();

        model.addAttribute("betRepo", betRepository);

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

    @PostMapping("/teamName")
    public String teamName(@ModelAttribute MatchTeamName matchTeamName, Model model) throws IOException{
        List<MatchesRecord> matches = matchServices.showByName(matchTeamName.getTeamName());

        model.addAttribute("matches", matches);

        Map<Integer, Boolean> visibleButtons = matchServices.getVisibleMatches(matches);

        model.addAttribute("visible", visibleButtons);
        model.addAttribute("matchToBet", new MatchToBet());

        BetRepository betRepository = new BetRepository();

        model.addAttribute("betRepo", betRepository);

        return "matches";
    }

}
