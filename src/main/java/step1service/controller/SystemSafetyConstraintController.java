package step1service.controller;

import lombok.AllArgsConstructor;
import step1service.dto.SystemSafetyConstraintDto;
import step1service.service.SystemSafetyConstraintService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/SystemSafetyConstraints")
@AllArgsConstructor
public class SystemSafetyConstraintController {

    private SystemSafetyConstraintService SystemSafetyConstraintService;

    // Build save SystemSafetyConstraint REST API
    @PostMapping
    public ResponseEntity<SystemSafetyConstraintDto> saveSystemSafetyConstraint(@RequestBody SystemSafetyConstraintDto systemSafetyConstraintDto){
        SystemSafetyConstraintDto savedSystemSafetyConstraintDto = SystemSafetyConstraintService.saveSystemSafetyConstraint(systemSafetyConstraintDto);
        return new ResponseEntity<SystemSafetyConstraintDto>(savedSystemSafetyConstraintDto, HttpStatus.CREATED);
    }

    // Build get SystemSafetyConstraint REST API
    @GetMapping("{SystemSafetyConstraint-code}")
    public ResponseEntity<SystemSafetyConstraintDto> getSystemSafetyConstraint(@PathVariable("SystemSafetyConstraint-code") String SystemSafetyConstraintCode) {
        SystemSafetyConstraintDto systemSafetyConstraintDto = SystemSafetyConstraintService.getSystemSafetyConstraintByCode(SystemSafetyConstraintCode);
        return new ResponseEntity<SystemSafetyConstraintDto>(systemSafetyConstraintDto, HttpStatus.OK);
    }

}
    /*
         Moved to a central class - GlobalExceptionHandler
         @@ExceptionHandler is an annotation used to handle the SPECIFIC exceptions and
         sending the custom responses to the client

         @ExceptionHandler(ResourceNotFoundException.class)
         public ResponseEntity<ErrorDetails> handleResourceNotFoundException(
                ResourceNotFoundException resourceNotFoundException,
                WebRequest webRequest){
            ErrorDetails errorDetails = new ErrorDetails(
                    LocalDateTime.now(),
                    resourceNotFoundException.getMessage(),
                    webRequest.getDescription(false),
                    "SystemSafetyConstraint_NOT_FOUND"
            );

            return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
        }
     */


