package step1service.mapper;

import step1service.dto.SystemSafetyConstraintDto;
import step1service.entity.SystemSafetyConstraint;


public class SystemSafetyConstraintMapper {
    public static SystemSafetyConstraintDto convertSystemSafetyConstraintToSystemSafetyConstraintDto(SystemSafetyConstraint systemSafetyConstraint){
        return new SystemSafetyConstraintDto(
                systemSafetyConstraint.getId(),
                systemSafetyConstraint.getSystemSafetyConstraintCode(),
                systemSafetyConstraint.getSystemSafetyConstraintDescription()
        );
    }

    public static SystemSafetyConstraint convertSystemSafetyConstraintDtoToSystemSafetyConstraint(SystemSafetyConstraintDto systemSafetyConstraintDto){
        return new SystemSafetyConstraint(
                systemSafetyConstraintDto.getId(),
                systemSafetyConstraintDto.getSystemSafetyConstraintCode(),
                systemSafetyConstraintDto.getSystemSafetyConstraintDescription()
        );
    }
}
