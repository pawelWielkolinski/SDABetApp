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

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;
    @Autowired
    HttpSession session;

    @GetMapping("/panel")
    public String admin(Model model) {
        List<UsersRecord> users = userRepository.getAll();
        List<UsersRecord> panelUsers = users.stream()
                .filter(usersRecord -> !usersRecord.getUserRole().equals("ADMIN"))
                .collect(Collectors.toList());
        model.addAttribute("UsersList", panelUsers);
        model.addAttribute("MatchDate", new MatchDate());
        return "panel";
    }

    @PostMapping("/updateMatchDatabase")
    public String updateMatches(@ModelAttribute MatchDate matchDate) throws IOException {

        MatchesModel matchesModel = new MatchesModel();
        Matches matchesFromApi = matchesModel.getMatchesFromApi(matchDate.getDateFrom(), matchDate.getDateTo());
        matchesModel.insertMatchesToDatabase(matchesFromApi);

        return "redirect:panel";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(Model model) {


        return "redirect:panel";
    }


}
