package server.repository;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.model.Recipe;

@Configurable
@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
}
