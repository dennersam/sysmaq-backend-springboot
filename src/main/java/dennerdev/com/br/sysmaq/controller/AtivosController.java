package dennerdev.com.br.sysmaq.controller;

import dennerdev.com.br.sysmaq.dto.request.AtivosDTO;
import dennerdev.com.br.sysmaq.dto.response.MessageResponseDTO;
import dennerdev.com.br.sysmaq.service.AtivosService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/ativo")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AtivosController {

    private AtivosService ativosService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createAtivo(@RequestBody @Valid AtivosDTO ativosDTO){
        return ativosService.createAtivo(ativosDTO);
    }

    @GetMapping
    public List<AtivosDTO> listAll(){
        return ativosService.listAll();
    }

}
