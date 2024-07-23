package step1service.mapper;

import step1service.dto.SystemSafetyConstraintDto;
import step1service.entity.SystemSafetyConstraint;


public class SystemSafetyConstraintMapper {
    public static SystemSafetyConstraintDto convertSystemSafetyConstraintToSystemSafetyConstraintDto(SystemSafetyConstraint systemSafetyConstraint){
        return new SystemSafetyConstraintDto(
                systemSafetyConstraint.getId(),
                systemSafetyConstraint.getTitle(),
                systemSafetyConstraint.getDescription(),
                systemSafetyConstraint.getCode()
        );
    }

    public static SystemSafetyConstraint convertSystemSafetyConstraintDtoToSystemSafetyConstraint(SystemSafetyConstraintDto systemSafetyConstraintDto){
        return new SystemSafetyConstraint(
                systemSafetyConstraintDto.getId(),
                systemSafetyConstraintDto.getSystemSafetyConstraintName(),
                systemSafetyConstraintDto.getSystemSafetyConstraintDescription(),
                systemSafetyConstraintDto.getSystemSafetyConstraintCode()
        );
    }
}
