package pl.Brew_App_3.ingredient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.Brew_App_3.recipe.Recipe;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient,Long>{

    @Query(value = "SELECT i FROM Ingredient i JOIN i.rawId w WHERE i.recipeId = ?1")
    List<Ingredient> findIngredientAndRawByRecipe(Recipe recipeId);
}
