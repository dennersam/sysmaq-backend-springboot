package dennerdev.com.br.sysmaq.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AtivosNotFoundException extends Exception{

    public AtivosNotFoundException(Long id){
        super("Não foi encontrado o Ativo com ID: " + id);
    }
}
