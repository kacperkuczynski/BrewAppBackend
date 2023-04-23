package pl.Brew_App_3.ingredient;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.Brew_App_3.raw.Raw;
import pl.Brew_App_3.raw.RawRepository;
import pl.Brew_App_3.recipe.Recipe;
import pl.Brew_App_3.recipe.RecipeRepository;

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
