package ru.andr.projectrest.ProjectREST.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.andr.projectrest.ProjectREST.dto.SensorDTO;
import ru.andr.projectrest.ProjectREST.models.Sensor;
import ru.andr.projectrest.ProjectREST.services.SensorsService;
import ru.andr.projectrest.ProjectREST.util.ErrorResponse;
import ru.andr.projectrest.ProjectREST.util.ErrorsUtil;
import ru.andr.projectrest.ProjectREST.util.MeasurementException;
import ru.andr.projectrest.ProjectREST.util.SensorValidator;

import java.time.LocalDateTime;
import java.util.List;

import static ru.andr.projectrest.ProjectREST.util.ErrorsUtil.returnErrorsUtil;

@RestController
@RequestMapping("/sensors")
public class SensorsController {

    private final SensorsService sensorsService;
    private final ModelMapper modelMapper;
    private final SensorValidator sensorValidator;

    public SensorsController(SensorsService sensorsService, ModelMapper modelMapper, SensorValidator sensorValidator) {
        this.sensorsService = sensorsService;
        this.modelMapper = modelMapper;
        this.sensorValidator = sensorValidator;
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> save(@RequestBody @Valid SensorDTO sensorDTO,
                                           BindingResult bindingResult) {

        sensorValidator.validate(convertToSensor(sensorDTO), bindingResult);

        if(bindingResult.hasErrors()) {
            returnErrorsUtil(bindingResult);
        }

        sensorsService.save(convertToSensor(sensorDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private Sensor convertToSensor(SensorDTO sensorDTO) {
        return modelMapper.map(sensorDTO, Sensor.class);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(MeasurementException e) {
        ErrorResponse response = new ErrorResponse(
                e.getMessage(),
                LocalDateTime.now().toString());
        // В HTTP ответе тело ответа (response) и статус в заголовке
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST); // статус BAD_REQUEST
    }
}
