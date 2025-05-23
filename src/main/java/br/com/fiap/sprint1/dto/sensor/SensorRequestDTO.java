package br.com.fiap.sprint1.dto.sensor;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "A data é obrigatória")
    private LocalDate data;

    @NotNull(message = "A hora é obrigatória")
    private LocalTime hora;

}