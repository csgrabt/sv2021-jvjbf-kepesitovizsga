package training360.guinessapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import training360.guinessapp.Entity.Recorder;
import training360.guinessapp.dto.RecorderDto;

import java.util.List;

public interface RecorderRepository extends JpaRepository<Recorder, Long> {


@Query("select u from Recorder u where u.name like  'B%' or u.contains 'e' ordered by u.dateOfBirth DESC")
List<RecorderDto> listRecordes();
}
