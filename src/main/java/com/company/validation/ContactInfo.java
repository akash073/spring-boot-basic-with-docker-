package com.company.validation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;

/*
@Constraint(validatedBy = { ContactInfoValidator.class })
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
*/
/*anotation interface*/
@Target({ ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ContactInfoValidator.class)
@Documented
public @interface ContactInfo {
    String message() default "Default:Invalid contact info";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

class ContactInfoValidator implements ConstraintValidator<ContactInfo, String> {

   // private static final Logger LOG = Logger.getLogger(ContactInfoValidator.class);

/*
    @Value("${contactInfoType}")
    private String expressionType;
*/

    private String pattern;

 /*   @Autowired
    private ContactInfoExpressionRepository expressionRepository;
*/
    @Override
    public void initialize(ContactInfo contactInfo) {
/*
        if (StringUtils.isEmpty(expressionType)) {
  //          LOG.error("Contact info type missing!");
        } else {
    */
/*        pattern = expressionRepository.findById(expressionType)
                    .map(ContactInfoExpression::getPattern).get();
    *//*
    }
*/
        pattern = "abc";
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
      /*  if (!StringUtils.isEmptyOrWhitespace(pattern)) {
            return Pattern.matches(pattern, value);
        }
      */  //LOG.error("Contact info pattern missing!");

        int a= 0;
        if(a==0){

            return false;
        }
        return false;
    }
}
