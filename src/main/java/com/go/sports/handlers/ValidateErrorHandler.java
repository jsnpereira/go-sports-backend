package com.go.sports.handlers;

import com.go.sports.handlers.dto.ErrorExceptionMessageDTO;
import com.go.sports.handlers.dto.ErrorValidMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ValidateErrorHandler {

    private MessageSource messageSource;

    @Autowired
    public ValidateErrorHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorExceptionMessageDTO> handle(MethodArgumentNotValidException exception){
        System.out.println("MethodArgumentNotValidException exception is called");
        List<ErrorValidMessageDTO> dto = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach( e -> {
            String message = messageSource.getMessage(e , LocaleContextHolder.getLocale());
            ErrorValidMessageDTO error = new ErrorValidMessageDTO(e.getField(), message);
            dto.add(error);
        });
        ErrorExceptionMessageDTO errorValidListMessageDTO = new ErrorExceptionMessageDTO(LocalDateTime.now(),dto);
        return new ResponseEntity<>(errorValidListMessageDTO, HttpStatus.BAD_REQUEST);
    }
}
