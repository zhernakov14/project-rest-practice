package ru.andr.projectrest.ProjectREST.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.andr.projectrest.ProjectREST.models.Measurement;

public interface MeasurementsRepository extends JpaRepository<Measurement, Integer> {

}
