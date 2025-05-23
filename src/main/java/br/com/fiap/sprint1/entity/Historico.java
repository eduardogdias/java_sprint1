package br.com.fiap.sprint1.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_HISTORICO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private int posicao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_moto", nullable = false)
    private Moto moto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_zona", nullable = false)
    private Zona zona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_sensor", nullable = false)
    private Sensor sensor;
}

