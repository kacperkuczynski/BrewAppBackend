package pl.Brew_App_3.recipe;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.Brew_App_3.ingredient.Ingredient;
import pl.Brew_App_3.ingredient.IngredientRepository;
import pl.Brew_App_3.raw.Raw;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;
    public Page<Recipe> getRecipes(Pageable pageable) {
        return recipeRepository.findAll(pageable);
    }

    public RecipeDto getRecipeBySlug(String slug) {
        Recipe recipe = recipeRepository.findBySlug(slug).orElseThrow();
        List<Ingredient> ingredients = ingredientRepository.findIngredientAndRawByRecipe(recipe);
        return mapToRecipeDto(recipe, ingredients);
    }

    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }


    private RecipeDto mapToRecipeDto(Recipe recipe, List<Ingredient> ingredients) {
        return RecipeDto.builder()
                .id(recipe.getId())
                .numberRecipe(recipe.getNumberRecipe())
                .nameRecipe(recipe.getNameRecipe())
                .ingredients(ingredients.stream().map(ingredient -> Ingredient.builder()
                        .id(ingredient.getId())
                        .rawId(Raw.builder()
                                .id(ingredient.getRawId().getId())
                                .typeRaw(ingredient.getRawId().getTypeRaw())
                                .build())
                        .amount(ingredient.getAmount())
                        .build()
                ).toList())
                .build();
    }
}
