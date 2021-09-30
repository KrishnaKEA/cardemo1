package cardemo1.demo.services;

import cardemo1.demo.dtos.CarDTO;
import cardemo1.demo.entities.Car;
import cardemo1.demo.repo.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarService {
    @Autowired
    CarRepo carRepo;

    public List<CarDTO> getCars(String brand, String model) {
        if (brand != null && model != null) {
            return CarDTO.carDTOsFromCar(carRepo.findCarByBrandAndModel(brand, model));
        }
        if (brand != null && model == null) {
            return CarDTO.carDTOsFromCar(carRepo.findCarByBrand(brand));
        }
        return CarDTO.carDTOsFromCar(carRepo.findAll());
    }

    public CarDTO getCar(int id) {
        Car car = carRepo.findById(id).orElseThrow();
        return new CarDTO(car);
    }

    public CarDTO addCar(CarDTO newCar) {
        Car carToMake = CarDTO.carFromCarDTO(newCar);
        return new CarDTO(carRepo.save(carToMake));
    }

    public CarDTO editCar(CarDTO cartoEdit, int id) {
        Car carOrg = carRepo.findById(id).orElseThrow();
        carOrg.setBrand(cartoEdit.getBrand());
        carOrg.setModel(cartoEdit.getModel());
        carOrg.setPricePrDay(cartoEdit.getPricePrDay());
        return new CarDTO(carRepo.save(carOrg));
    }

    public void deleteCar(int id) {
        carRepo.deleteById(id);
    }

}
