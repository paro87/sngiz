package com.paro.sngiz.Validator;

import com.paro.sngiz.PersonalData.Employer;
import com.paro.sngiz.PersonalData.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//Custom validation with ConstraintValidator
public class EmployerIdValidator implements ConstraintValidator<EmployerId, Integer>{
    @Autowired
    private EmployerService employerService;
    public void initialize(EmployerId constraintAnnotation) {

    }


    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        Employer employer;
        try {
            employer = employerService.getEmployer(value);
        } catch (Exception e) {
            return true;
        }
        if(employer!= null) {
            return false;
        }
        return true;
    }
}
