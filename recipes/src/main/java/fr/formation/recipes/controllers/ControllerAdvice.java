package fr.formation.recipes.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import fr.formation.recipes.errors.ValidationError;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
	    MethodArgumentNotValidException ex, HttpHeaders headers,
	    HttpStatus status, WebRequest request) {
	// Validation errors wrapped in a BindingResult from
	// MethodArgumentNotValidException (ex):
	BindingResult result = ex.getBindingResult();
	// Spring field errors:
	List<FieldError> fieldErrors = result.getFieldErrors();
	// Custom field errors:
	List<ValidationError> validationErrors = new ArrayList<>();
	for (FieldError fieldError : fieldErrors) {
	    String object = fieldError.getObjectName();
	    String attribute = fieldError.getField();
	    String code = fieldError.getCode();
	    ValidationError validationError = new ValidationError(object,
		    attribute, code);
	    validationErrors.add(validationError);
	}
	// Spring global errors:
	List<ObjectError> globalErrors = result.getGlobalErrors();
	for (ObjectError globalError : globalErrors) {
	    String object = globalError.getObjectName();
	    String code = globalError.getCode();
	    ValidationError validationError = new ValidationError(object, code);
	    validationErrors.add(validationError);
	}
	return handleExceptionInternal(ex, validationErrors, headers, status,
		request);
    }
}
