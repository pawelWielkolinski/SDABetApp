package sda.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import sda.db.data.generated.tables.records.UsersRecord;
import sda.match.MatchDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {

    private UserService userService;

    @Autowired
    private HttpSession httpSession;


    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";

    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute LoginForm loginForm, Model model) {
        String login = loginForm.getUserName();
        String password = loginForm.getPassword();

        UsersRecord loginU = userService.findByName(login);

        if (loginU != null && loginU.getPassword().equals(password)) {
            httpSession.setAttribute("idUser", loginU.getIdUser());
            httpSession.setAttribute("email", loginU.getEmail());
            httpSession.setAttribute("points", loginU.getPoints());
            httpSession.setAttribute("isLogin", "true");

            model.addAttribute("matchDate", new MatchDate());
            return "index";
        }
        return "login";

    }

}
