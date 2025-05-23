package br.com.fiap.sprint1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.sprint1.entity.Historico;

public interface HistoricoRepository extends JpaRepository<Historico, Integer> {
	List<Historico> findByMotoId(Integer motoId);

}
