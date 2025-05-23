package br.com.fiap.sprint1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity()
@Table(name = "TB_MOTO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Moto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 7)
	private String placa; //7 caracteres
	
	@Column(length = 17)
	private String chassi;  //17 caracteres
	
	private String marca;
	
	@Column(nullable = false, length = 20)
	private String modelo;

}
