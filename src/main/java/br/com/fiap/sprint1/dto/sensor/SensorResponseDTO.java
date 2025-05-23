package br.com.fiap.sprint1.dto.sensor;

import br.com.fiap.sprint1.entity.Sensor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SensorResponseDTO {

    private Integer id;
    private String localizacao;

    public SensorResponseDTO(Sensor sensor) {
        this.id = sensor.getId();
        this.localizacao = sensor.getLocalizacao();
    }

}