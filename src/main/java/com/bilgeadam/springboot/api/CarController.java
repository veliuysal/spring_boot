package com.bilgeadam.springboot.api;

import com.bilgeadam.springboot.models.Car;
import com.bilgeadam.springboot.services.CarService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping(path = "/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Car> getAllCarsByYear(@PathVariable("year") Integer year) {
        return carService.getAllCarsByYear(year);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Car> getAllCarsByYearInParam(@RequestParam("year") Integer year) {
        return carService.getAllCarsByYear(year);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Car saveCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Car updateCar(@RequestBody Car car) throws Exception {
        return carService.updateCar(car);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteCategoryInPath(@PathVariable("id") Integer id) throws Exception {
        carService.deleteCategory(id);
        return "Silme İşlemi Başarılı.";
    }
}
