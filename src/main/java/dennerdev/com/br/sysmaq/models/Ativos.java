package dennerdev.com.br.sysmaq.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ativos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private String fabricante;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false, unique = true)
    private String registro;

    @Column(nullable = false, unique = true)
    private String serie;

    @Column(nullable = false)
    private String cliente;

    @Column(nullable = false)
    private String locador;

    @Column(nullable = false)
    private String local;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = true)
    private LocalDate previsao;

    @Column(nullable = false)
    private String status;

    @Column(nullable = true)
    private LocalDate dtSaida;

    @Column(nullable = true)
    private Double horimetro;

    @Column(nullable = true)
    private LocalDate ultInspeccaoData;

    @Column(nullable = true)
    private Double ultInspeccaoHorimetro;

    @Column(nullable = true)
    private LocalDate proxTrocaOleo;

}
