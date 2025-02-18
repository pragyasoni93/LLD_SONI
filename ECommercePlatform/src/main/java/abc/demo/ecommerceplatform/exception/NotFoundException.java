package abc.demo.ecommerceplatform.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends Exception{
    public NotFoundException(HttpStatus notFound, String message){
        super(message);
    }
}
