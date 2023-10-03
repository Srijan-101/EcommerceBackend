package com.EcommerceProject.EcommerceProject.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ErrorDetails {
    private LocalDateTime timestamp;
    private String Errormessage;
    private String Description;
}
