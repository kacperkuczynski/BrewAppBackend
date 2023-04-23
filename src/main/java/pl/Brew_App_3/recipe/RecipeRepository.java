package pl.Brew_App_3.recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe,Long>{
    Optional<Recipe> findBySlug(String slug);
}
