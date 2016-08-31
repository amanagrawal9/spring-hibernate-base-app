package qa.qcri.rahar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import qa.qcri.rahar.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
