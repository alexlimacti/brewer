package com.indeas.brewer.controller.validator;

import com.indeas.brewer.model.Venda;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class VendaValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Venda.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        
    }
}
