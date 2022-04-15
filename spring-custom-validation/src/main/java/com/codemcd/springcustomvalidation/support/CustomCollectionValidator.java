package com.codemcd.springcustomvalidation.support;

import java.util.Collection;
import javax.validation.Validation;
import org.graalvm.compiler.lir.CompositeValue.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import com.codemcd.springcustomvalidation.exception.InvalidBindListException;

@Component
public class CustomCollectionValidator implements Validator {

  private final SpringValidatorAdapter validator;

  public CustomCollectionValidator() {
    this.validator = new SpringValidatorAdapter(
        Validation.buildDefaultValidatorFactory().getValidator()
        );
  }

  @Override
  public boolean supports(Class clazz) {
    return true;
  }

  @Override
  public void validate(Object target, Errors errors) {
    if(target instanceof Collection){
      Collection collection = (Collection) target;

      for (Object object : collection) {
        validator.validate(object, errors);

        if (errors.hasErrors()) {
          throw new InvalidBindListException();
        }
      }
    }

  }
}
//