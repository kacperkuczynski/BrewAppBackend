package pl.Brew_App_3.ingredient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.Brew_App_3.recipe.RecipeRepository;

@Service
@RequiredArgsConstructor
public class IngredientService {
    private final IngredientRepository ingredientRepository;
    public Ingredient createIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }
}
