package br.com.fiap.sprint1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.sprint1.entity.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Integer>{

}
