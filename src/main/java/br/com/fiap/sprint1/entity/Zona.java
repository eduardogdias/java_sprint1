package br.com.fiap.sprint1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_ZONA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Zona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "O tipo da zona é obrigatório")
    @Size(min = 3, max = 50, message = "O tipo deve ter entre 3 e 50 caracteres")
    private String tipo;

    @NotNull(message = "A quantidade de vagas é obrigatória")
    @Min(value = 1, message = "A quantidade mínima de vagas deve ser 1")
    @Column(name = "qtd_vaga")
    private Integer qtdVaga;

    @ManyToOne
    @JoinColumn(name = "fk_patio", nullable = false) // a zona deve um ter patio para ser instanciada
    @NotNull(message = "O pátio da zona é obrigatório")
    private Patio patio;

}