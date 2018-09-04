package sda.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @Autowired
    private HttpSession httpSession;

    @RequestMapping("/logout")
    public String logout(){
        httpSession.invalidate();
        return "logout";
    }

}
