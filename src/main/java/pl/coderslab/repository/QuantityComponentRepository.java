package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.QuantityComponent;

import java.util.List;

public interface QuantityComponentRepository extends JpaRepository<QuantityComponent, Long> {
    List<QuantityComponent> findAllByRecipeId (Long id);
}
