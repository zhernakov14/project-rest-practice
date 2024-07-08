package ru.andr.projectrest.ProjectREST.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.andr.projectrest.ProjectREST.models.Sensor;

import java.util.Optional;

public interface SensorsRepository extends JpaRepository<Sensor, Integer> {
    Optional<Sensor> findByName(String name);
}
