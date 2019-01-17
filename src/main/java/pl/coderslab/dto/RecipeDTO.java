package pl.coderslab.dto;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeDTO {

    public List<String> mealTypeDTO() {
        List<String> mealType = new ArrayList<String>();
        mealType.add("dania główne");
        mealType.add("zupy");
        mealType.add("sałatki");
        mealType.add("ciasta");
        mealType.add("desery");
        mealType.add("przekąski");
        mealType.add("dodatki do dań");
        return mealType;
    }

    public List<String> timeOfDayDTO() {
        List<String> timeOfDay = new ArrayList<>();
        timeOfDay.add("śniadanie");
        timeOfDay.add("lunch");
        timeOfDay.add("obiad");
        timeOfDay.add("podwieczorek");
        timeOfDay.add("kolacja");
        return timeOfDay;
    }

    public List<String> dietsDTO() {
        List<String> diets = new ArrayList<>();
        diets.add("wegetariańska");
        diets.add("bezglutenowa");
        diets.add("niskokaloryczna");
        return diets;
    }

    public List<String> unitOfMeasurementDTO() {
        List<String> units = new ArrayList<>();
        units.add("gram");
        units.add("mililitrów");
        units.add("sztuk");
        return units;
    }
}
