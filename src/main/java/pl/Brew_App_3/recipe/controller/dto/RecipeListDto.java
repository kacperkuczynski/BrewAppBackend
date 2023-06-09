package pl.Brew_App_3.recipe.controller.dto;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RecipeListDto {
    private Long id;
    private Long numberRecipe;
    private String nameRecipe;
    private String slug;
}
