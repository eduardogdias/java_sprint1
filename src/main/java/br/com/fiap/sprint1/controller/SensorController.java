package br.com.fiap.sprint1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.sprint1.dto.sensor.SensorRequestDTO;
import br.com.fiap.sprint1.dto.sensor.SensorResponseDTO;
import br.com.fiap.sprint1.service.SensorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/sensores")
@SuppressWarnings("all")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    
    @GetMapping
    public ResponseEntity listar() {
        List<SensorResponseDTO> sensores = sensorService.listar();
        return ResponseEntity.ok(sensores);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(sensorService.buscarPorId(id));
    }

    
    @PostMapping
    public ResponseEntity criar(@RequestBody @Valid SensorRequestDTO dto) {
        return ResponseEntity.status(201).body(sensorService.criar(dto));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<SensorResponseDTO> atualizar(@PathVariable Integer id, @RequestBody @Valid SensorRequestDTO dto) {
        return ResponseEntity.ok(sensorService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deletar(@PathVariable Integer id) {
        sensorService.deletar(id);

        Map<String, String> resposta = new HashMap<>();
        resposta.put("mensagem", "Sensor com ID " + id + " deletado com sucesso");

        return ResponseEntity.ok(resposta);
    }
}
