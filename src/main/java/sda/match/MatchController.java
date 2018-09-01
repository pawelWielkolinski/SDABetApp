package sda.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sda.db.data.generated.tables.records.MatchesRecord;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        Map<Integer, Boolean> visibleButtons = new HashMap<>();
        for (MatchesRecord match : matches) {

            boolean visible = match.getStartDate().toLocalDate().isAfter(LocalDate.now())
                    || (match.getStartDate().toLocalDate().compareTo(LocalDate.now()) == 0
                    && match.getStartTime().toLocalTime().isAfter(LocalTime.now()));

            visibleButtons.put(match.getIdMatch(),visible);
        }
        model.addAttribute("visible", visibleButtons);

        return "matches";
    }

}
