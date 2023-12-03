package com.bilgeadam.springboot.services;

import com.bilgeadam.springboot.models.Car;
import com.bilgeadam.springboot.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }


    public List<Car> getAllCarsByYear(Integer year) {
        return carRepository.findAllByYear(year);
    }

    public Car saveCar(Car car) throws Exception {
        Optional<Car> optCar = carRepository.findByYearAndBrandAndModel(car.getYear(), car.getBrand(), car.getModel());
        if (optCar.isPresent()) {
            throw new Exception("Bu kayıt var. Aman dikkat!");
        }
        Integer idValue = carRepository.getMaxId() + 1;
        car.setId(idValue);
        return carRepository.save(car);
    }

    public Car updateCar(Car car) throws Exception {
        if (car.getId() == null)
            throw new Exception("ID boş olamaz");
        Optional<Car> optCar = carRepository.findById(car.getId());
        if (optCar.isEmpty()) {
            throw new Exception("Invalid data");
        }
        return carRepository.save(car);
    }

    public void deleteCategory(Integer id) throws Exception {
        carRepository.deleteById(id);
    }

}
