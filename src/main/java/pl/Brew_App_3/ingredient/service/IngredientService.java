package pl.Brew_App_3.ingredient.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.Brew_App_3.ingredient.model.Ingredient;
import pl.Brew_App_3.ingredient.repository.IngredientRepository;

@Service
@RequiredArgsConstructor
public class IngredientService {
    private final IngredientRepository ingredientRepository;
    public Ingredient createIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }
}
