package com.example.GuesthouseWebpage.handlers;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

// Model for error response
@Data
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private List<String> details;
}
