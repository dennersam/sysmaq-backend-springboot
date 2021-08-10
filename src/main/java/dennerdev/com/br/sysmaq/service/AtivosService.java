package dennerdev.com.br.sysmaq.service;

import dennerdev.com.br.sysmaq.dto.request.AtivosDTO;
import dennerdev.com.br.sysmaq.dto.response.MessageResponseDTO;
import dennerdev.com.br.sysmaq.dto.mapper.AtivosMapper;
import dennerdev.com.br.sysmaq.exception.AtivosNotFoundException;
import dennerdev.com.br.sysmaq.models.Ativos;
import dennerdev.com.br.sysmaq.repository.AtivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AtivosService {

    private final AtivoRepository ativoRepository;

    private final AtivosMapper ativosMapper = AtivosMapper.INSTANCE;

    @Autowired
    public AtivosService(AtivoRepository ativoRepository) {
        this.ativoRepository = ativoRepository;
    }

    public MessageResponseDTO createAtivo(AtivosDTO ativosDTO){
        Ativos ativosToSave = ativosMapper.toModel(ativosDTO);

        Ativos savedAtivos = ativoRepository.save(ativosToSave);
        return MessageResponseDTO
                .builder()
                .message("Ativo criado com o ID: " + savedAtivos.getId())
                .build();
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
}
