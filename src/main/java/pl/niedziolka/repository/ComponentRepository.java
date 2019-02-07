package pl.niedziolka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.niedziolka.model.Component;

import java.util.List;

public interface ComponentRepository extends JpaRepository<Component, Long> {
    Component findOneByName (String name);
    @Query(value = "select name from components", nativeQuery = true)
    List<String> findAllName();
}
