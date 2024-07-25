package step1service.repository;

import step1service.entity.SystemSafetyConstraint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SystemSafetyConstraintRepository extends JpaRepository<SystemSafetyConstraint,Long> {

    Optional<SystemSafetyConstraint> findBySystemSafetyConstraintCode(String systemSafetyConstraintCode);

}
