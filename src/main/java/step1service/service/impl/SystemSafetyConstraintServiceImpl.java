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
    // Decided not to use ModelMapper. Used SystemSafetyConstraintMapper instead
    // private ModelMapper modelMapper;

    /*
                     CONVERTING SystemSafetyConstraintDTO TO SystemSafetyConstraint JPA ENTITY

     FIRST WAY: Manual conversion

     SystemSafetyConstraint SystemSafetyConstraint = new SystemSafetyConstraint(
                                             systemSafetyConstraintDto.getId(),
                                             systemSafetyConstraintDto.getSystemSafetyConstraintTitle(),
                                             systemSafetyConstraintDto.getSystemSafetyConstraintDescription(),
                                             systemSafetyConstraintDto.getSystemSafetyConstraintCode()
                                            );

     SECOND WAY: Create a method to perform the conversion

     SystemSafetyConstraint SystemSafetyConstraint = SystemSafetyConstraintMapper.convertSystemSafetyConstraintDtoToSystemSafetyConstraint(systemSafetyConstraintDto);

     THIRD WAY: ModelMapper

     SystemSafetyConstraint SystemSafetyConstraint = modelMapper.map(systemSafetyConstraintDto, SystemSafetyConstraint.class);

     FOURTH WAY: MapStruct

     SystemSafetyConstraint SystemSafetyConstraint = AutoSystemSafetyConstraintMapper.MAPPER.mapToSystemSafetyConstraint(systemSafetyConstraintDto);

                     CONVERTING SystemSafetyConstraint JPA ENTITY TO SystemSafetyConstraint DTO

     FIRST WAY: Manual conversion

     SystemSafetyConstraintDto savedSystemSafetyConstraintDto = new SystemSafetyConstraintDto(
                                                            savedSystemSafetyConstraint.getId(),
                                                            savedSystemSafetyConstraint.getSystemSafetyConstraintTitle(),
                                                            savedSystemSafetyConstraint.getSystemSafetyConstraintDescription(),
                                                            savedSystemSafetyConstraint.getSystemSafetyConstraintCode()
                                                          );

     SECOND WAY: Create a method to perform the conversion

     return SystemSafetyConstraintMapper.convertSystemSafetyConstraintToSystemSafetyConstraintDto(savedSystemSafetyConstraint);

     THIRD WAY: ModelMapper

     SystemSafetyConstraintDto savedSystemSafetyConstraintDto = modelMapper.map(savedSystemSafetyConstraint, SystemSafetyConstraintDto.class);

     FOURTH WAY: MapStruct

     return AutoSystemSafetyConstraintMapper.MAPPER.mapToSystemSafetyConstraintDto(savedSystemSafetyConstraint);

     */
    @Override
    public SystemSafetyConstraintDto saveSystemSafetyConstraint(SystemSafetyConstraintDto systemSafetyConstraintDto) {
        Optional<SystemSafetyConstraint> optionalSystemSafetyConstraint = SystemSafetyConstraintRepository.findByCode(systemSafetyConstraintDto.getSystemSafetyConstraintCode());

        if(optionalSystemSafetyConstraint.isPresent()){
            throw new SystemSafetyConstraintAlreadyExistsException("SystemSafetyConstraint name already exists");
        }
        // SECOND WAY: Create a method to perform the conversion
        SystemSafetyConstraint systemSafetyConstraint = SystemSafetyConstraintMapper.convertSystemSafetyConstraintDtoToSystemSafetyConstraint(systemSafetyConstraintDto);
        SystemSafetyConstraint savedSystemSafetyConstraint = SystemSafetyConstraintRepository.save(systemSafetyConstraint);
        return SystemSafetyConstraintMapper.convertSystemSafetyConstraintToSystemSafetyConstraintDto(savedSystemSafetyConstraint);

    }

    /*
                      CONVERTING SystemSafetyConstraint JPA ENTITY TO SystemSafetyConstraintDTO

         FIRST WAY: Manual conversion
         SystemSafetyConstraintDto SystemSafetyConstraintDto = new SystemSafetyConstraintDto(
                                                          SystemSafetyConstraint.getId()
                                                          SystemSafetyConstraint.getSystemSafetyConstraintTitle(),
                                                          SystemSafetyConstraint.getSystemSafetyConstraintDescription(),
                                                          SystemSafetyConstraint.getSystemSafetyConstraintCode()
                                                         );

         SECOND WAY: Create a method to perform the conversion
        return SystemSafetyConstraintMapper.convertSystemSafetyConstraintToSystemSafetyConstraintDto(SystemSafetyConstraint);

         THIRD WAY: ModelMapper
         return modelMapper.map(SystemSafetyConstraint, SystemSafetyConstraintDto.class);

         FOURTH WAY: MapStruct
         return AutoSystemSafetyConstraintMapper.MAPPER.mapToSystemSafetyConstraintDto(SystemSafetyConstraint);
     */
    @Override
    public SystemSafetyConstraintDto getSystemSafetyConstraintByCode(String SystemSafetyConstraintCode) {
        // @TODO Contrast with the mechanism used on saveSystemSafetyConstraint with Optional and isPresent()
        SystemSafetyConstraint systemSafetyConstraint = SystemSafetyConstraintRepository.findByCode(SystemSafetyConstraintCode).orElseThrow(
                () -> new ResourceNotFoundException("systemSafetyConstraint", "SystemSafetyConstraintCode", SystemSafetyConstraintCode)
        );

        return SystemSafetyConstraintMapper.convertSystemSafetyConstraintToSystemSafetyConstraintDto(systemSafetyConstraint);
    }
}
