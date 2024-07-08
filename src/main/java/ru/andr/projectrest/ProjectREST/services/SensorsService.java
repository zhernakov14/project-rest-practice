package ru.andr.projectrest.ProjectREST.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.andr.projectrest.ProjectREST.models.Sensor;
import ru.andr.projectrest.ProjectREST.repositories.SensorsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SensorsService {
    private final SensorsRepository sensorsRepository;

    @Autowired
    public SensorsService(SensorsRepository sensorsRepository) {
        this.sensorsRepository = sensorsRepository;
    }

    public Optional<Sensor> findByName(String name) {
        return sensorsRepository.findByName(name);
    }
    @Transactional
    public void save(Sensor sensor) {
        sensorsRepository.save(sensor);
    }
}
