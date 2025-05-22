package br.com.fiap.sprint1.entity;

import java.util.List;

import br.com.fiap.sprint1.dto.PatioDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="TB_PATIO")
@Getter
@Setter
@NoArgsConstructor
public class Patio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "O endereço é obrigatório")
    @Size(min = 5, max = 255, message = "O endereço deve ter entre 5 e 255 caracteres")
    private String endereco;

    @OneToMany(mappedBy = "patio")
    private List<Zona> zonas;
	
    
    
	//construtor do DTO
	public Patio(PatioDTO patioDTO) {
		this.nome = patioDTO.getNome();
		this.endereco = patioDTO.getEndereco();
	}


	//contrutor para definir as tabelas do banco (sem coluna para as zonas)
	public Patio(Integer id, String nome, String endereco) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
	}
	
}
