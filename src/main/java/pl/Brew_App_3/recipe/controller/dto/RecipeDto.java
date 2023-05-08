package pl.Brew_App_3.recipe.controller.dto;

import lombok.Builder;
import lombok.Getter;
import pl.Brew_App_3.ingredient.model.Ingredient;
import java.util.List;

@Getter
@Builder
public class RecipeDto {
    private Long id;
    private Long numberRecipe;
    private String nameRecipe;
    private String slug;
    List<Ingredient> ingredients;
}
