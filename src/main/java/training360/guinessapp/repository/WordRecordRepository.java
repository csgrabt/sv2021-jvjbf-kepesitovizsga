package training360.guinessapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import training360.guinessapp.Entity.WorldRecord;

public interface WordRecordRepository extends JpaRepository<WorldRecord, Long> {
}
