package com.EcommerceProject.EcommerceProject.Exception;

import com.EcommerceProject.EcommerceProject.dto.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@ControllerAdvice
public class CustomException extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(BindException.class)
//    public final ResponseEntity<Object> handleAppException(AppException appException){
//        ApiResponse response = new ApiResponse(false, appException.getMessage(), appException.getMessage());
//        return ResponseEntity.status(appException.getHttpStatus()).body(response);
//    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        BindingResult bindingResult = ex.getBindingResult();
        List<String> errorMessages = new ArrayList<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMessages.add(fieldError.getDefaultMessage());
        }
        ApiResponse response = new ApiResponse(false, "Validation Error", errorMessages);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }



    @ExceptionHandler(AppException.class)
    public final ResponseEntity <ErrorDetails> handleAppException(AppException appException, WebRequest request){
        ErrorDetails errorDetails =
                new ErrorDetails(LocalDateTime.now(),
                        appException.getMessage(),request.getDescription(false));
        return new ResponseEntity<ErrorDetails>(errorDetails,appException.getHttpStatus());
    }
}
