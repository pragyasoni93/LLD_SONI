package abc.demo.ecommerceplatform.dto;

import org.springframework.http.HttpStatus;

public class ExceptionDto {
    private HttpStatus statusCode;
    private String message;

    public ExceptionDto(HttpStatus status, String message){
        this.statusCode = status;
        this.message = message;
    }
}
