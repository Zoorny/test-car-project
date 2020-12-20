package com.tecom.controller;

import com.tecom.database.model.Car;
import com.tecom.database.model.enumerations.Body;
import com.tecom.database.model.enumerations.DriveUnit;
import com.tecom.database.model.enumerations.Transmission;
import com.tecom.database.repository.CarRepository;
import com.tecom.services.CarExportService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class CarController {

    private final CarRepository carRepository;
    private final CarExportService carExportService;

    public CarController(CarRepository carRepository, CarExportService carExportService) {
        this.carRepository = carRepository;
        this.carExportService = carExportService;
    }

    @GetMapping
    public String main(Model model) {
        Iterable<Car> cars = carRepository.findAll();
        model.addAttribute("cars", cars);
        return "main";
    }

    @PostMapping("addRecord")
    public String addRecord(@RequestParam String brand, @RequestParam String model, @RequestParam int releaseYear,
                      @RequestParam int releaseMonth, @RequestParam int engineVolume, @RequestParam String turbocharger,
                      @RequestParam int enginePower, @RequestParam String transmission, @RequestParam String driveUnit,
                      @RequestParam String body, @RequestParam String color, Model appModel) {

        Car car = new Car(brand, model, releaseYear, releaseMonth, engineVolume, Boolean.parseBoolean(turbocharger), enginePower,
                Transmission.valueOf(transmission), DriveUnit.valueOf(driveUnit), Body.valueOf(body), color);
        carRepository.save(car);
        Iterable<Car> cars = carRepository.findAll();
        appModel.addAttribute("cars", cars);
        return "main";
    }

    @PostMapping("deleteRecord")
    public String deleteRecord(@RequestParam String id, Model model) {
        try {
            carRepository.deleteById(Long.valueOf(id));
        } catch (EmptyResultDataAccessException e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
        Iterable<Car> cars = carRepository.findAll();
        model.addAttribute("cars", cars);
        return "main";
    }

    @PostMapping("updateRecord")
    public String updateRecord(@RequestParam String id, @RequestParam String brand, @RequestParam String model, @RequestParam int releaseYear,
                               @RequestParam int releaseMonth, @RequestParam int engineVolume, @RequestParam String turbocharger,
                               @RequestParam int enginePower, @RequestParam String transmission, @RequestParam String driveUnit,
                               @RequestParam String body, @RequestParam String color, Model appModel) {
        Car carUpdate = new Car(brand, model, releaseYear, releaseMonth, engineVolume, Boolean.parseBoolean(turbocharger), enginePower,
                Transmission.valueOf(transmission), DriveUnit.valueOf(driveUnit), Body.valueOf(body), color);
        carRepository.findById(Long.valueOf(id)).ifPresent(car -> updateCar(carUpdate, car));
        Iterable<Car> cars = carRepository.findAll();
        appModel.addAttribute("cars", cars);
        return "main";
    }

    @GetMapping("/export")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=cars.xlsx";

        response.setHeader(headerKey, headerValue);
        Iterable<Car> cars = carRepository.findAll();
        carExportService.export(response, cars);
    }

    @GetMapping("/sort/{field}")
    public String sortByField(@PathVariable String field, Model model) {
        Iterable<Car> cars = carRepository.findAll(Sort.by(Sort.Direction.ASC, field));
        model.addAttribute("cars", cars);
        return "main";
    }

    private void updateCar(Car update, Car entity) {
        entity.setBrand(update.getBrand());
        entity.setModel(update.getModel());
        entity.setReleaseYear(update.getReleaseYear());
        entity.setReleaseMonth(update.getReleaseMonth());
        entity.setEngineVolume(update.getEngineVolume());
        entity.setEnginePower(update.getEnginePower());
        entity.setTurbocharger(update.isTurbocharger());
        entity.setTransmission(update.getTransmission());
        entity.setDriveUnit(update.getDriveUnit());
        entity.setBody(update.getBody());
        entity.setColor(update.getColor());
    }
}
