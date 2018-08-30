package sda.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sda.db.data.generated.tables.records.MatchesRecord;

import java.io.IOException;
import java.util.List;

@Controller
public class MatchController {

    @Autowired
    private MatchServices matchServices;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("matchDate", new MatchDate());
        return "index";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute MatchDate matchDate, Model model) throws IOException {
        List<MatchesRecord> matches = matchServices.show(matchDate.getDateFrom(), matchDate.getDateTo());

        model.addAttribute("matches", matches);
        return "matches";
    }

}
