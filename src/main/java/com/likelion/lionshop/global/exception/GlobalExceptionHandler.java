package com.likelion.lionshop.global.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.NoSuchElementException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     *  @Valid에서  error 발생시 발생한다.
     *  주로 @RequestBody, @RequestPart 어노테이션에서 발생
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)//
    protected ResponseEntity<String> handleIllegalArgumentException(MethodArgumentNotValidException e) {
        log.error("handleIllegalArgumentException", e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    /**
     * Authentication 객체가 필요한 권한을 보유하지 않은 경우 발생함.
     */
    @ExceptionHandler(AccessDeniedException.class)
    protected ResponseEntity<String> handleAccessDeniedException(AccessDeniedException e) {
        log.error("handleAccessDeniedException", e);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
    }

    /**
     * 대상이 없는 경우 발생함.
     */
    @ExceptionHandler(NoSuchElementException.class)
    protected ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        log.error("handleNoSuchElementException", e);//e= error
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); //error404 보내라 e.getmessage는 메세지 가지고 와라
    }//특정 무언가를 수정하려고 하는데 특정 무언가를 조회했을때 없다면 이 exception을 날림.


    @ExceptionHandler(IOException.class)
    protected ResponseEntity<String> handleSIOException(IOException e){
        log.error("IOException", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<String> handleException(Exception e) {
        log.error("handleException", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

}