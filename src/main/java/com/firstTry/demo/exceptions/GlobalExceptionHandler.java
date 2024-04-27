package com.firstTry.demo.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.firstTry.demo.ResponseHandler.copy.ApiResponse;

import java.util.HashMap;
import java.util.Map;

@Component
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundHandler(ResourceNotFoundException ex){
		
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
		
	}
	
   @ExceptionHandler(ValidationException.class)
   public ResponseEntity<ApiResponse> validationErrorHandler(ValidationException ex){
	   System.out.println("******************************hi-bangaluru***************************************");
	   String message =ex.getMessage();
	   ApiResponse apiResponse =new ApiResponse(message, false);
	   System.out.println(apiResponse);
	   return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.BAD_REQUEST);
   }

   @ExceptionHandler(MethodArgumentNotValidException.class)
   public  ResponseEntity<Map<String,String>> MethodArgumentNotValidExceptionHandeler(MethodArgumentNotValidException ex){
		Map<String,String> res = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName = ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			res.put(fieldName,message);
		});
		return  new ResponseEntity<Map<String,String>>(res,HttpStatus.BAD_REQUEST);
   }
}
