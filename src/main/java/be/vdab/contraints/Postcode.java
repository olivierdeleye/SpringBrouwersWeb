package be.vdab.contraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

//enkele imports uit java.lang.annotation en uit javax.validation
 @Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE }) 
 @Retention(RetentionPolicy.RUNTIME) 
 @Constraint(validatedBy = PostcodeValidator.class) 
 
 public @interface Postcode { 
  String message() default "{fouteVanTotPostcode}"; //indien niet gevonden in resourcebundles teksten.propterties
  Class<?>[] groups() default {}; 
  Class<? extends Payload>[] payload() default {}; 
}