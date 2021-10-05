package cardemo1.demo.conrollers;

import cardemo1.demo.dtos.CarDTO;
import cardemo1.demo.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    @Autowired
    CarService carService;
    @GetMapping
    List<CarDTO> getCars(@RequestParam(required =false) String brand, @RequestParam(required = false)String model){
        if(brand ==null && model != null){
            throw new IllegalArgumentException("please provide model name first");
        }
        return carService.getCars(brand, model);
    }

    //hello  how are you
   @GetMapping("/{id}")
    CarDTO getCar(@PathVariable int id){
        return carService.getCar(id);
   }
   @PostMapping
    CarDTO addCar(@RequestBody CarDTO newCar){
        return carService.addCar(newCar);
   }
   @PutMapping("/{id}")
    CarDTO editCar(@RequestBody CarDTO carToEdit, @PathVariable int id)throws Exception{
        return carService.editCar(carToEdit,id);
   }

   @DeleteMapping("/{id}")
    void deleteCar(@PathVariable int id){
        carService.deleteCar(id);
   }





}
