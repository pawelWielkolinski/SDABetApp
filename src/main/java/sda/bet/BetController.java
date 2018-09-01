package sda.bet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import sda.match.SelectMatchForm;

@Controller
public class BetController {

    @Autowired
    private BetService betService;

    @RequestMapping("/bet")
    public String setBet(@ModelAttribute SelectMatchForm selectMatchForm, Model model) {

        return "matches";
    }


}
