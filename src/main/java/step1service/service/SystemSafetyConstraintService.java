package step1service.service;

import step1service.dto.SystemSafetyConstraintDto;

public interface SystemSafetyConstraintService {
    SystemSafetyConstraintDto saveSystemSafetyConstraint(SystemSafetyConstraintDto systemSafetyConstraintDto);

    SystemSafetyConstraintDto getSystemSafetyConstraintByCode(String SystemSafetyConstraintCode);
}
