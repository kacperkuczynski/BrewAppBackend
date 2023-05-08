package pl.Brew_App_3.ingredient.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.Brew_App_3.raw.model.Raw;
import pl.Brew_App_3.recipe.model.Recipe;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;

    @ManyToOne
    @JoinColumn(name = "recipeId")
    private Recipe recipeId;

    @ManyToOne
    @JoinColumn(name = "rawId")
    private Raw rawId;
}
