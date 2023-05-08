package pl.Brew_App_3.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.Brew_App_3.recipe.model.Recipe;

import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe,Long>{
    Optional<Recipe> findBySlug(String slug);
}
