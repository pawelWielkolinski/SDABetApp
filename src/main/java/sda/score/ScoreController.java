package sda.score;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sda.db.data.generated.tables.records.UsersRecord;
import sda.user.UserRepository;
import sda.user.UserService;

import java.util.List;

@Controller
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @RequestMapping("/scores")
    public String scores (Model model){
        List<UsersRecord> results = scoreService.showScores();

        model.addAttribute("scores",results);


        return "scores";
    }
}
