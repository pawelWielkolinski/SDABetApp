package sda.bet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sda.db.data.generated.tables.records.BetsRecord;
import sda.match.MatchRepository;
import sda.match.MatchServices;
import sda.match.MatchToBet;
import sda.user.UserRepository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BetController {

    @Autowired
    private BetService betService;
    @Autowired
    private HttpSession session;
    @Autowired
    private  MatchServices matchServices;
    @Autowired
    private BetRepository betRepository;
    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private UserRepository userRepository;

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

        betService.givePoints();
        List<BetsRecord> yourBets = betRepository.getBetsByUserId((Integer) session.getAttribute("idUser"));
        model.addAttribute("yourBets", yourBets);
        model.addAttribute("matchRepo", matchRepository);
        model.addAttribute("matchServ", matchServices);

        return "bets";
    }

    @PostMapping("/betsByUsers")
    public  String betsByUsers(MatchToBet matchToBet, Model model){

        List<BetsRecord> yourBets = betRepository.getBetsByMatchId(matchToBet.getIdMatchToBet());
        model.addAttribute("yourBets", yourBets);
        model.addAttribute("matchRepo", matchRepository);
        model.addAttribute("userRepo", userRepository);
        model.addAttribute("matchServ", matchServices);
        model.addAttribute("matchId", matchToBet.getIdMatchToBet());

        return "usersBets";
    }

}
