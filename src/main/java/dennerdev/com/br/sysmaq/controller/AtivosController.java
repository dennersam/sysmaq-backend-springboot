package dennerdev.com.br.sysmaq.controller;

import dennerdev.com.br.sysmaq.dto.request.AtivosDTO;
import dennerdev.com.br.sysmaq.dto.response.MessageResponseDTO;
import dennerdev.com.br.sysmaq.exception.AtivosNotFoundException;
import dennerdev.com.br.sysmaq.models.Ativos;
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

    @GetMapping("/{id}")
    public AtivosDTO findById(@PathVariable Long id) throws AtivosNotFoundException {
        return ativosService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws AtivosNotFoundException{
        ativosService.delete(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @Valid @RequestBody AtivosDTO ativosDTO) throws AtivosNotFoundException{
        return ativosService.updateById(id, ativosDTO);
    }

}
