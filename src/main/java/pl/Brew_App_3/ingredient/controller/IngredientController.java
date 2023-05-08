package pl.Brew_App_3.ingredient.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.Brew_App_3.ingredient.model.Ingredient;
import pl.Brew_App_3.ingredient.service.IngredientService;
import pl.Brew_App_3.raw.model.Raw;
import pl.Brew_App_3.raw.repository.RawRepository;
import pl.Brew_App_3.recipe.model.Recipe;
import pl.Brew_App_3.recipe.repository.RecipeRepository;

@RestController
@RequiredArgsConstructor
public class IngredientController {
    private static final Long EMPTY_ID = null;
    private final IngredientService ingredientService;
    private final RecipeRepository recipeRepository;
    private final RawRepository rawRepository;

    @PostMapping("ingredient/{slug}/{rawId}")
    public Ingredient createIngredient(@RequestBody Ingredient ingredient,
                                       @PathVariable String slug,
                                       @PathVariable Long rawId){
        Recipe recipe = recipeRepository.findBySlug(slug).orElseThrow();
        Raw raw = rawRepository.findById(rawId).orElseThrow();
        Ingredient ing = Ingredient.builder()
                .id(EMPTY_ID)
                .amount(ingredient.getAmount())
                .recipeId(recipe)
                .rawId(raw)
                .build();
        return ingredientService.createIngredient(ing);
    }
}
