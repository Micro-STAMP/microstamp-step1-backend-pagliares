package step1service.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import step1service.dto.SystemSafetyConstraintDto;
import step1service.service.SystemSafetyConstraintService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/system-safety-constraints")
@AllArgsConstructor
public class SystemSafetyConstraintController {

    private SystemSafetyConstraintService systemSafetyConstraintService;

    // Save SystemSafetyConstraint REST API
    @PostMapping
    public ResponseEntity<SystemSafetyConstraintDto> saveSystemSafetyConstraint(@RequestBody SystemSafetyConstraintDto systemSafetyConstraintDto){
        SystemSafetyConstraintDto savedSystemSafetyConstraintDto = systemSafetyConstraintService.saveSystemSafetyConstraint(systemSafetyConstraintDto);
        return new ResponseEntity<SystemSafetyConstraintDto>(savedSystemSafetyConstraintDto, HttpStatus.CREATED);
    }

    // Get SystemSafetyConstraint REST API
    @GetMapping("{system-safety-constraint-code}")
    public ResponseEntity<SystemSafetyConstraintDto> getSystemSafetyConstraint(@AuthenticationPrincipal Jwt jwt,
                                                                               @PathVariable("system-safety-constraint-code")
                                                                               String systemSafetyConstraintCode) {
        System.out.println(jwt.getSubject());
        SystemSafetyConstraintDto systemSafetyConstraintDto = systemSafetyConstraintService.getSystemSafetyConstraintByCode(systemSafetyConstraintCode);
        return new ResponseEntity<SystemSafetyConstraintDto>(systemSafetyConstraintDto, HttpStatus.OK);
    }
}


