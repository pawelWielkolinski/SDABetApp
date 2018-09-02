package sda.bet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BetController {

    @Autowired
    private BetService betService;

    @RequestMapping("/bet")
    public String setBet(@ModelAttribute BetForm betInfo, Model model) {

        return "bet";
    }


}
