package sda.bet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sda.db.data.generated.tables.records.BetsRecord;
import sda.match.MatchRepository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BetController {

    @Autowired
    private BetService betService;
    @Autowired
    private HttpSession session;

    @PostMapping ("/setBet")
    public String setBet(@ModelAttribute BetForm betInfo, Model model) {

        betService.saveBet(betInfo);

        return "betSuccessful";
    }

    @RequestMapping("/bets")
    public String bets(Model model) {
        BetRepository betRepository = new BetRepository();
        MatchRepository matchRepository = new MatchRepository();

        betService.givePoints();
        List<BetsRecord> yourBets = betRepository.getBetsByUserId((Integer) session.getAttribute("idUser"));

        model.addAttribute("yourBets", yourBets);
        model.addAttribute("matchRepo", matchRepository);

        return "bets";
    }


}
