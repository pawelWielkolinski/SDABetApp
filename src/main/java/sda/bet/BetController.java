package sda.bet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sda.db.data.generated.tables.records.BetsRecord;
import sda.db.data.generated.tables.records.MatchesRecord;
import sda.match.MatchRepository;
import sda.match.MatchServices;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Controller
public class BetController {

    @Autowired
    private BetService betService;
    @Autowired
    private HttpSession session;
    @Autowired
    private  MatchServices matchServices;

    @PostMapping ("/setBet")
    public String setBet(@ModelAttribute BetForm betInfo, BindingResult binding) {
        if(binding.hasErrors()){
            return "redirect:bets";
        }

        betService.saveBet(betInfo);

        return "redirect:bets";
    }

    @RequestMapping("/bets")
    public String bets(Model model) {
        BetRepository betRepository = new BetRepository();
        MatchRepository matchRepository = new MatchRepository();

        betService.givePoints();
        List<BetsRecord> yourBets = betRepository.getBetsByUserId((Integer) session.getAttribute("idUser"));
        model.addAttribute("yourBets", yourBets);
        model.addAttribute("matchRepo", matchRepository);
        model.addAttribute("matchServ", matchServices);

        return "bets";
    }

}
