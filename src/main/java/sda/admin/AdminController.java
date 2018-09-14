package sda.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sda.user.UserService;

@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @GetMapping("/adminpanel")
    public String update(Model model){

        return "panel";
    }




    }
