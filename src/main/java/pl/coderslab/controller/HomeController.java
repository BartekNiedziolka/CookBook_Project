package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.service.UserService;
import pl.coderslab.model.User;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String homePage() {
        return "/home/home";
    }

    @RequestMapping(value = "/home/register", method = RequestMethod.GET)
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "/home/registerPage";
    }

    @RequestMapping(value = "/home/register", method = RequestMethod.POST)
    public String add(@ModelAttribute("user")@Valid User user, BindingResult validResult){
        if (validResult.hasErrors() || userService.checkIfUserExists(user)) {
            return "home/registerPage";
        }else {
            userService.registerUser(user);
        }
        return "redirect:/home/login";
    }

    @RequestMapping(value = "/home/login", method = RequestMethod.GET)
    public String loginForm(Model model) {
        model.addAttribute("user", new User());
        return "/home/loginPage";
    }

    @RequestMapping(value = "/home/login", method = RequestMethod.POST)
    public String logUser(@RequestParam String userName, @RequestParam String password, HttpSession session) {
        if (userService.successfulLogin(userName, password)) {
            session.setAttribute("login", userName);
            return "redirect:/user/main";
        }
        return "/home/loginPage";
    }
}
