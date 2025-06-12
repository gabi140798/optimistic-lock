package pl.kurs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kurs.model.Mother;

public interface MotherRepository  extends JpaRepository<Mother, Integer> {
}
