package dennerdev.com.br.sysmaq.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AtivosDTO {

    private Long id;

    @NotEmpty
    @Size(min = 5, max = 200)
    private String fabricante;

    @NotEmpty
    @Size(min = 1, max = 10)
    private String numero;

    @NotEmpty
    @Size(min = 5, max = 200)
    private String tipo;

    @NotEmpty
    @Size(min = 5, max = 200)
    private String registro;

    @NotEmpty
    @Size(min = 5, max = 200)
    private String serie;

    @NotEmpty
    @Size(min = 5, max = 200)
    private String cliente;

    @NotEmpty
    @Size(max = 2)
    private String locador;

    @NotEmpty
    @Size(min = 5, max = 200)
    private String local;

    @NotEmpty
    @Size(max = 2)
    private String estado;

    private LocalDate previsao;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String status;

    private LocalDate dtSaida;

    private Double horimetro;

    private LocalDate ultInspeccaoData;

    private Double ultInspeccaoHorimetro;

    private LocalDate proxTrocaOleo;

}
