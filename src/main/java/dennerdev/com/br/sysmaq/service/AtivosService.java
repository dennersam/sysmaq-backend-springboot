package dennerdev.com.br.sysmaq.service;

import dennerdev.com.br.sysmaq.dto.request.AtivosDTO;
import dennerdev.com.br.sysmaq.dto.response.MessageResponseDTO;
import dennerdev.com.br.sysmaq.dto.mapper.AtivosMapper;
import dennerdev.com.br.sysmaq.exception.AtivosNotFoundException;
import dennerdev.com.br.sysmaq.models.Ativos;
import dennerdev.com.br.sysmaq.repository.AtivoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AtivosService {

    private final AtivoRepository ativoRepository;

    private final AtivosMapper ativosMapper = AtivosMapper.INSTANCE;

    public MessageResponseDTO createAtivo(AtivosDTO ativosDTO){
        Ativos ativosToSave = ativosMapper.toModel(ativosDTO);

        Ativos savedAtivos = ativoRepository.save(ativosToSave);
        return createMessageResponse(savedAtivos.getId(), "Ativos criado: ");
    }

    public List<AtivosDTO> listAll() {
        List<Ativos> allAtivos = ativoRepository.findAll();
        return allAtivos.stream()
                .map(ativosMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AtivosDTO findById(Long id) throws AtivosNotFoundException{
        Ativos ativos = verifyIfExists(id);
        return ativosMapper.toDTO(ativos);
    }

    public void delete(Long id) throws AtivosNotFoundException{
        verifyIfExists(id);
        ativoRepository.deleteById(id);
    }

    private Ativos verifyIfExists(Long id) throws AtivosNotFoundException{
        return ativoRepository.findById(id)
                .orElseThrow(()-> new AtivosNotFoundException(id));
    }

    public MessageResponseDTO updateById(Long id, AtivosDTO ativosDTO) throws AtivosNotFoundException{
        verifyIfExists(id);
        Ativos ativosToUpdate = ativosMapper.toModel(ativosDTO);
        Ativos updatedAtivos = ativoRepository.save(ativosToUpdate);
        return createMessageResponse(updatedAtivos.getId(), "Ativo atualizado: ");

    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
