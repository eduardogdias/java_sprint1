package br.com.fiap.sprint1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.sprint1.dto.PatioDTO;
import br.com.fiap.sprint1.entity.Patio;
import br.com.fiap.sprint1.repository.PatioRepository;
import jakarta.transaction.Transactional;

@Service
public class PatioService {

    @Autowired
    private PatioRepository patioRepository;

    // listar
    public List<Patio> listarPatios() {
        return patioRepository.findAll();
    }

    // buscar
    public Patio buscarPatioPorId(Integer id) {
        Optional<Patio> patio = patioRepository.findById(id);  // optional -> retorna o patio se encontrado, ou null
        return patio.orElse(null);  
    }

    // criar
    @Transactional          // @Transactional -> faz um rollback na alteracoes se o metodo gerar excecao 
    public Patio criarPatio(PatioDTO patioDTO) {
        Patio patio = new Patio();
        patio.setNome(patioDTO.getNome());
        patio.setEndereco(patioDTO.getEndereco());
        return patioRepository.save(patio);
    }

    // atualizar
    @Transactional
    public Patio atualizarPatio(Integer id, PatioDTO patioDTO) {
        Patio patio = buscarPatioPorId(id);
        if (patio != null) {
            patio.setNome(patioDTO.getNome());
            patio.setEndereco(patioDTO.getEndereco());
            return patioRepository.save(patio);
        }
        return null; 
    }

    // deletar
    @Transactional
    public boolean deletarPatio(Integer id) {
        Patio patio = buscarPatioPorId(id);
        if (patio != null) {
            patioRepository.delete(patio);
            return true; 
        }
        return false; 
    }
}


