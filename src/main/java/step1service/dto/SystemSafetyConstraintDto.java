package step1service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SystemSafetyConstraintDto {
    private Long id;
    private String systemSafetyConstraintCode;
    private String systemSafetyConstraintDescription;

}
