package pl.niedziolka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.niedziolka.model.Recipe;
import pl.niedziolka.model.User;
import pl.niedziolka.repository.RecipeRepository;
import pl.niedziolka.repository.UserRepository;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RecipeRepository recipeRepository;


    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String myPage(Model model, @SessionAttribute String login) {
        User user = userRepository.findByUserName(login);
        List<Recipe> recipes = recipeRepository.findAllByUserId(user.getId());
        model.addAttribute("recipes",recipes);
        model.addAttribute("user", user);

        return "/users/myPage";
    }

}
