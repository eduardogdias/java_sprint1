package br.com.fiap.sprint1.dto.historico;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoricoRequestDTO {

    @NotNull(message = "A posição é obrigatória")
    private Integer posicao;

    @NotNull(message = "O ID da moto é obrigatório")
    private Integer motoId;

    @NotNull(message = "O ID da zona é obrigatório")
    private Integer zonaId;

    @NotNull(message = "O ID do sensor é obrigatório")
    private Integer sensorId;
}
