package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.dto.RecipeDTO;
import pl.coderslab.model.Component;
import pl.coderslab.model.QuantityComponent;
import pl.coderslab.model.Recipe;
import pl.coderslab.repository.ComponentRepository;
import pl.coderslab.repository.QuantityComponentRepository;
import pl.coderslab.repository.RecipeRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/component")
public class ComponentController {

    @Autowired
    private ComponentRepository componentRepository;
    @Autowired
    private QuantityComponentRepository quantityComponentRepository;
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private RecipeDTO recipeDTO;

    @ModelAttribute("nameComponents")
    public List<String> allComponents() {
        return componentRepository.findAllName();
    }
    @ModelAttribute("units")
    public List<String> unitOfMeasurement() {
        return recipeDTO.unitOfMeasurementDTO();
    }
//    @ModelAttribute("myComponents")
//    public List<QuantityComponent> addedComponents(Long id) {
//        return quantityComponentRepository.findAllByRecipeId(id);
//    }

    @RequestMapping(value = "/add/{recipeId}",method = RequestMethod.GET)
    public String addComponent(@PathVariable long recipeId, Model model) {
        Recipe recipe = recipeRepository.findOne(recipeId);
        QuantityComponent quantityComponent = new QuantityComponent();
        quantityComponent.setRecipe(recipe);
        model.addAttribute("quantityComponent", quantityComponent);
        return "/components/addComponents";
    }

    @RequestMapping(value = "/add/{recipeId}", method = RequestMethod.POST)
    public String saveComponent(@Valid QuantityComponent quantityComponent, @PathVariable long recipeId, BindingResult result) {
        if (result.hasErrors()) {
            return "/components/addComponents";
        }
        Recipe recipe = recipeRepository.findOne(recipeId);
        recipe.getQuantityComponents().add(quantityComponent);
        recipeRepository.save(recipe);

        Component component = componentRepository.findOneByName(quantityComponent.getName());
        quantityComponent.setComponent(component);
        quantityComponentRepository.save(quantityComponent);

        return "redirect:/component/add/" + recipeId;
    }
}
