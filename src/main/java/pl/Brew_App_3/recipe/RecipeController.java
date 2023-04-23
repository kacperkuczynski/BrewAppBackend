package pl.Brew_App_3.recipe;

import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import pl.Brew_App_3.common.utils.SlugifyUtils;
import org.jsoup.safety.Safelist;
import org.jsoup.Jsoup;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class RecipeController {
    public static final Long EMPTY_ID = null;
    private final RecipeService recipeService;

    @GetMapping("recipes")
    public Page<RecipeListDto> getRecipes(Pageable pageable){
        Page<Recipe> recipes =  recipeService.getRecipes(pageable);
        List<RecipeListDto> recipeList = recipes.getContent().stream()
                .map(recipe -> RecipeListDto.builder()
                        .id(recipe.getId())
                        .numberRecipe(recipe.getNumberRecipe())
                        .nameRecipe(recipe.getNameRecipe())
                        .build())
                .collect(Collectors.toList());
        return new PageImpl<>(recipeList, pageable, recipes.getTotalElements());
    }

    @GetMapping("recipe/{slug}")
    public RecipeDto getRecipeBySlug(
            @PathVariable
            @Pattern(regexp = "[a-z0-9\\-]+")
            @Length(max = 255)
            String slug){
     return recipeService.getRecipeBySlug(slug);
    }

    @PostMapping("recipe")
    public Recipe createRecipe(@RequestBody RecipeDto recipeDto){
        return recipeService.createRecipe(mapRecipe(recipeDto, EMPTY_ID));
    }

    private Recipe mapRecipe(RecipeDto recipeDto, Long id) {
        return Recipe.builder()
                .id(id)
                .numberRecipe(recipeDto.getNumberRecipe())
                .nameRecipe(clearContent(recipeDto.getNameRecipe()))
                .slug(SlugifyUtils.slugifySlug(recipeDto.getSlug()))
                .build();
    }

    private String clearContent(String text) {
        return Jsoup.clean(text, Safelist.none());
    }
}
