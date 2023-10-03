package com.EcommerceProject.EcommerceProject.Exception;

import com.EcommerceProject.EcommerceProject.dto.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.LocalTime;



@ControllerAdvice
public class CustomException  extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(AppException.class)
//    public final ResponseEntity<Object> handleAppException(AppException appException){
//        ApiResponse response = new ApiResponse(false, appException.getMessage(), appException.getMessage());
//        return ResponseEntity.status(appException.getHttpStatus()).body(response);
//    }

    @ExceptionHandler(AppException.class)
    public final ResponseEntity <ErrorDetails> handleAppException(AppException appException, WebRequest request){
        ErrorDetails errorDetails =
                new ErrorDetails(LocalDateTime.now(),
                        appException.getMessage(),request.getDescription(false));
        return new ResponseEntity<ErrorDetails>(errorDetails,appException.getHttpStatus());
    }
}
