package accuratech.example.accuratech.repository;

import accuratech.example.accuratech.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Creation of Employee Repository
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
