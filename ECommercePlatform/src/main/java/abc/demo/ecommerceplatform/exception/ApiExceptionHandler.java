package abc.demo.ecommerceplatform.exception;

import abc.demo.ecommerceplatform.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    private ResponseEntity<ExceptionDto> handler (NotFoundException notFoundException){
        return new ResponseEntity(new NotFoundException(HttpStatus.NOT_FOUND, notFoundException.getMessage()),
                HttpStatus.NOT_FOUND);
    }
}
