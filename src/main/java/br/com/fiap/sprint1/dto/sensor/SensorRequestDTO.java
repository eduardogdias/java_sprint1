package br.com.fiap.sprint1.dto.sensor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SensorRequestDTO {

    @NotBlank(message = "A localização é obrigatória")
    @Size(max = 50, message = "A localização deve ter no máximo 50 caracteres")
    private String localizacao;

    
}