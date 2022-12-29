package com.centersound.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<PasswordConstraint,String> {
    private static final long serialVersionUID = 1786676760692254978L;
    private static final String CapitalLetter1_SmallLetter1_Digit_1_Symbol1
            ="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$";
    private static final String SYMBOLS = "[~!@#$%^&*()_+{}\\[\\]:;,.<>/?-]";
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value.length()<8 || value.length()>20) {
            return false;
        }
        Pattern p = Pattern.compile(SYMBOLS);
        Matcher m = p.matcher(value);

        if(m.find()==false){
            return false;
        }

        if(value.matches(CapitalLetter1_SmallLetter1_Digit_1_Symbol1)) {
            return true;
        }

        return false;
    }
}
