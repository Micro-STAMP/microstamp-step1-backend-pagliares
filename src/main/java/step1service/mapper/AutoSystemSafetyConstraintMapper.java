package step1service.mapper;

import step1service.dto.SystemSafetyConstraintDto;
import step1service.entity.SystemSafetyConstraint;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoSystemSafetyConstraintMapper {
    AutoSystemSafetyConstraintMapper MAPPER = Mappers.getMapper(AutoSystemSafetyConstraintMapper.class);

    /*
     We do not need to implement these methods.
     MapStruct provides the implementation at compilation time.
     SystemSafetyConstraint and corresponding DTO may have the same
     field names or be customized otherwise
     In our example SystemSafetyConstraintDto and SystemSafetyConstraint has
     exactly the same fields and names.

     The annotation below is not needed since both
     have the same fields names.
     @Mapping(source="emailAddress", target="email")
    */
    SystemSafetyConstraintDto mapToSystemSafetyConstraintDto(SystemSafetyConstraint systemSafetyConstraint);

    SystemSafetyConstraint mapToSystemSafetyConstraint(SystemSafetyConstraintDto systemSafetyConstraintDto);
}
