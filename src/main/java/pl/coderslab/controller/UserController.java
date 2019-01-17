package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Service.UserService;
import pl.coderslab.model.Recipe;
import pl.coderslab.model.User;
import pl.coderslab.repository.RecipeRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private RecipeRepository recipeRepository;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "/users/registerPage";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String add(@ModelAttribute("user")@Valid User user, BindingResult validResult){
        if (validResult.hasErrors() || userService.checkIfUserExists(user)) {
            return "users/registerPage";
        }else {
            userService.registerUser(user);
        }
        return "redirect:/user/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model) {
        model.addAttribute("user", new User());
        return "/users/loginPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String logUser(@RequestParam String userName, @RequestParam String password, HttpSession session) {
        if (userService.successfulLogin(userName, password)) {
            session.setAttribute("login", userName);
            return "redirect:/user/main";
        }
        return "/users/loginPage";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String myPage(Model model, @SessionAttribute String login) {
        User user = userRepository.findByUserName(login);
        List<Recipe> recipes = recipeRepository.findAllByUserId(user.getId());
        model.addAttribute("recipes",recipes);
        model.addAttribute("user", user);

        return "/users/myPage";
    }

}
