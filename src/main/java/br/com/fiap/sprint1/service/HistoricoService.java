package br.com.fiap.sprint1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.sprint1.dto.historico.HistoricoRequestDTO;
import br.com.fiap.sprint1.dto.historico.HistoricoResponseDTO;
import br.com.fiap.sprint1.entity.Historico;
import br.com.fiap.sprint1.entity.Moto;
import br.com.fiap.sprint1.entity.Sensor;
import br.com.fiap.sprint1.entity.Zona;
import br.com.fiap.sprint1.repository.HistoricoRepository;
import br.com.fiap.sprint1.repository.MotoRepository;
import br.com.fiap.sprint1.repository.SensorRepository;
import br.com.fiap.sprint1.repository.ZonaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class HistoricoService {

    @Autowired
    private HistoricoRepository historicoRepository;

    @Autowired
    private MotoRepository motoRepository;

    @Autowired
    private ZonaRepository zonaRepository;

    @Autowired
    private SensorRepository sensorRepository;

    

    //GET
    @Transactional
    public List<HistoricoResponseDTO> listar() {
        return historicoRepository.findAll().stream()
                .map(HistoricoResponseDTO::new)
                .collect(Collectors.toList());
    }

    //GET por ID
    @Transactional
    public HistoricoResponseDTO buscarPorId(Integer id) {
        Historico historico = historicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Histórico não encontrado"));
        return new HistoricoResponseDTO(historico);
    }

    //GET por motoID
    @Transactional
    public List<HistoricoResponseDTO> buscarPorMotoId(Integer motoId) {
        List<Historico> historicos = historicoRepository.findByMotoId(motoId);

        if (historicos.isEmpty()) {
            throw new EntityNotFoundException("Nenhum histórico encontrado para a moto com ID " + motoId);
        }

        return historicos.stream().map(HistoricoResponseDTO::new).collect(Collectors.toList());
    }

    //POST
    @Transactional
    public HistoricoResponseDTO criar(HistoricoRequestDTO dto) {
        Moto moto = motoRepository.findById(dto.getMotoId())
                .orElseThrow(() -> new EntityNotFoundException("Moto não encontrada"));

        Zona zona = zonaRepository.findById(dto.getZonaId())
                .orElseThrow(() -> new EntityNotFoundException("Zona não encontrada"));

        Sensor sensor = sensorRepository.findById(dto.getSensorId())
                .orElseThrow(() -> new EntityNotFoundException("Sensor não encontrado"));

        Historico historico = new Historico();
        historico.setPosicao(dto.getPosicao());
        historico.setMoto(moto);
        historico.setZona(zona);
        historico.setSensor(sensor);

        return new HistoricoResponseDTO(historicoRepository.save(historico));
    }
    
    //PUT
    @Transactional
    public HistoricoResponseDTO atualizar(Integer id, HistoricoRequestDTO dto) {
        Historico historico = historicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Histórico não encontrado"));

        Moto moto = motoRepository.findById(dto.getMotoId())
                .orElseThrow(() -> new EntityNotFoundException("Moto não encontrada"));

        Zona zona = zonaRepository.findById(dto.getZonaId())
                .orElseThrow(() -> new EntityNotFoundException("Zona não encontrada"));

        Sensor sensor = sensorRepository.findById(dto.getSensorId())
                .orElseThrow(() -> new EntityNotFoundException("Sensor não encontrado"));

        historico.setPosicao(dto.getPosicao());
        historico.setMoto(moto);
        historico.setZona(zona);
        historico.setSensor(sensor);

        return new HistoricoResponseDTO(historicoRepository.save(historico));
    }

    //DELETE
    @Transactional
    public void deletar(Integer id) {
        Historico historico = historicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Histórico não encontrado"));
        historicoRepository.delete(historico);
    }
}

