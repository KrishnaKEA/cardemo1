package cardemo1.demo.dtos;

import cardemo1.demo.entities.Car;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CarDTO {
    Integer id;
    String brand;
    String model;
    double pricePrDay;
    public CarDTO(String brand,String model,double pricePrDay){
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
    }
    public CarDTO(Car car){
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.pricePrDay = car.getPricePrDay();
        this.id = car.getId();
    }

    public static List<CarDTO> carDTOsFromCar(Iterable<Car> cars){
        List<CarDTO> dtos = new ArrayList<>();
        for(Car acar :cars){
            CarDTO dcar = new CarDTO(acar);
            dtos.add(dcar);
        }

        return dtos;
    }


    public static Car carFromCarDTO(CarDTO car){
        return new Car(car.getBrand(),car.getModel(),car.getPricePrDay());
    }
}
