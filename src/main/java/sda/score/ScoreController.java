package sda.score;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sda.bet.BetService;
import sda.db.data.generated.tables.records.BetsRecord;
import sda.db.data.generated.tables.records.UsersRecord;
import sda.match.MatchRepository;
import sda.user.UserToManage;

import java.util.List;

@Controller
public class ScoreController {

    @Autowired
    private ScoreService scoreService;
    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private BetService betService;


    @RequestMapping("/scores")
    public String scores (Model model){
        List<UsersRecord> results = scoreService.showScores();

        model.addAttribute("scores",results);
        model.addAttribute("userToManage", new UserToManage());

        return "scores";
    }

    @PostMapping("/scoreUserBets")
    public String seeBetsOfUser (@ModelAttribute UserToManage userToManage, Model model){

        model.addAttribute("matchRepo", matchRepository);
        List<BetsRecord> userBets = betService.getUserBetsToShowInScore(userToManage.getIdUserToManage());
        model.addAttribute("userBets", userBets);

        return "scoreBets";
    }
}
