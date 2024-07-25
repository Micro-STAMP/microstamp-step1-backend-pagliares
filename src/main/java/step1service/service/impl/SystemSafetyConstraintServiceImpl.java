package step1service.service.impl;

import lombok.AllArgsConstructor;
import step1service.dto.SystemSafetyConstraintDto;
import step1service.entity.SystemSafetyConstraint;
import step1service.exception.ResourceNotFoundException;
import step1service.mapper.SystemSafetyConstraintMapper;
import step1service.repository.SystemSafetyConstraintRepository;
import step1service.service.SystemSafetyConstraintService;
import org.springframework.stereotype.Service;
import step1service.exception.SystemSafetyConstraintAlreadyExistsException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SystemSafetyConstraintServiceImpl implements SystemSafetyConstraintService {

    private SystemSafetyConstraintRepository SystemSafetyConstraintRepository;

    @Override
    public SystemSafetyConstraintDto saveSystemSafetyConstraint(SystemSafetyConstraintDto systemSafetyConstraintDto) {
        Optional<SystemSafetyConstraint> optionalSystemSafetyConstraint = SystemSafetyConstraintRepository.findBySystemSafetyConstraintCode(systemSafetyConstraintDto.getSystemSafetyConstraintCode());

        if(optionalSystemSafetyConstraint.isPresent()){
            throw new SystemSafetyConstraintAlreadyExistsException("SystemSafetyConstraint name already exists");
        }
        SystemSafetyConstraint systemSafetyConstraint = SystemSafetyConstraintMapper.convertSystemSafetyConstraintDtoToSystemSafetyConstraint(systemSafetyConstraintDto);
        SystemSafetyConstraint savedSystemSafetyConstraint = SystemSafetyConstraintRepository.save(systemSafetyConstraint);
        return SystemSafetyConstraintMapper.convertSystemSafetyConstraintToSystemSafetyConstraintDto(savedSystemSafetyConstraint);

    }

    @Override
    public SystemSafetyConstraintDto getSystemSafetyConstraintByCode(String SystemSafetyConstraintCode) {
        SystemSafetyConstraint systemSafetyConstraint = SystemSafetyConstraintRepository.findBySystemSafetyConstraintCode(SystemSafetyConstraintCode).orElseThrow(
                () -> new ResourceNotFoundException("systemSafetyConstraint", "SystemSafetyConstraintCode", SystemSafetyConstraintCode)
        );

        return SystemSafetyConstraintMapper.convertSystemSafetyConstraintToSystemSafetyConstraintDto(systemSafetyConstraint);
    }
}
