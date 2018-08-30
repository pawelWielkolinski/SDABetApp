package sda.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class MatchController {

    @Autowired
    private MatchServices matchServices;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("MatchDate", new MatchDate());
        return "index";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute MatchDate matchDate, Model model) throws IOException {
        String matches = matchServices.show(matchDate.getDateFrom(), matchDate.getDateTo());

        model.addAttribute("matches", matches);
        return "matches";
    }

}
