package sda.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sda.db.data.generated.tables.records.UsersRecord;
import sda.match.MatchDate;
import sda.match.model.Matches;
import sda.match.model.MatchesModel;
import sda.user.UserRepository;
import sda.user.UserService;

import java.io.IOException;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/panel")
    public String admin(Model model) {
        List<UsersRecord> users = userRepository.getAll();
        model.addAttribute("UsersList", users);
        model.addAttribute("MatchDate", new MatchDate());
        return "panel";
    }

    @PostMapping("/updateMatchDatabase")
    public String updateMatches(@ModelAttribute MatchDate matchDate, Model model) throws IOException {

        MatchesModel matchesModel = new MatchesModel();
        Matches matchesFromApi = matchesModel.getMatchesFromApi(matchDate.getDateFrom(), matchDate.getDateTo());
        matchesModel.insertMatchesToDatabase(matchesFromApi);

        return "redirect:panel";
    }

    @PostMapping("/manageUser")
    public String manage(Model model) {


        return "redirect:panel";
    }


}
