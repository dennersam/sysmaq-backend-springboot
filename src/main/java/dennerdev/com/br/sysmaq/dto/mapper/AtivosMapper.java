package dennerdev.com.br.sysmaq.dto.mapper;

import dennerdev.com.br.sysmaq.dto.request.AtivosDTO;
import dennerdev.com.br.sysmaq.models.Ativos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AtivosMapper {

    AtivosMapper INSTANCE = Mappers.getMapper(AtivosMapper.class);

    @Mapping(target = "previsao", source = "previsao", dateFormat = "dd-MM-yyyy")
    @Mapping(target = "dtSaida", source = "dtSaida", dateFormat = "dd-MM-yyyy")
    @Mapping(target = "ultInspeccaoData", source = "ultInspeccaoData", dateFormat = "dd-MM-yyyy")
    @Mapping(target = "proxTrocaOleo", source = "proxTrocaOleo", dateFormat = "dd-MM-yyyy")
    Ativos toModel(AtivosDTO ativosDTO);

    AtivosDTO toDTO(Ativos ativos);
}
