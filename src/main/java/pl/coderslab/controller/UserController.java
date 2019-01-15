package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "/users/registerPage";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "/users/registerPage";
        }

        userRepository.save(user);
        return "/users/loginPage";
    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String loginForm(Model model) {
//        model.addAttribute("user", new User());
//        return "/users/loginPage";
//    }
//
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public String logUser(@Valid User user, BindingResult result) {
//        if (result.hasErrors()) {
//            return "/users/loginPage";
//        }
//
//        //userRepository.save(user);
//        return "/users/myPage";
//    }
}
