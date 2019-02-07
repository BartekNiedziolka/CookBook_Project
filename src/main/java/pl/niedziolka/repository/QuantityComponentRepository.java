package pl.niedziolka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.niedziolka.model.QuantityComponent;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface QuantityComponentRepository extends JpaRepository<QuantityComponent, Long> {
    List<QuantityComponent> findAllByRecipeId (Long id);
    Long findRecipeIdById (Long id);
}
