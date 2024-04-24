package com.api.v1.auxiliary;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@NotNull
@Pattern(regexp = "^([0-9]{2})-([0-9]{2})-([0-9]{4}) ([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$")
public @interface DateTimeFormatForGET {
  String message() default "Invalid date time format. Please enter date time as dd/mm/yyyy hh:mm:ss.";
}
