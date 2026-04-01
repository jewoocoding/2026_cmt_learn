package com.example.demo.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PostNotFoundException.class)
    public String handlePostNotFound(PostNotFoundException e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "error/404";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        model.addAttribute("message", "서버 오류가 발생했습니다.");
        return "error/500";
    }
}
