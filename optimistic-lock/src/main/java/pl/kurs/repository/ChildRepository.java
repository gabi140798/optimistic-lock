package pl.kurs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kurs.model.Child;

public interface ChildRepository extends JpaRepository<Child, Integer> {
}
