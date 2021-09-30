package cardemo1.demo.repo;

import cardemo1.demo.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CarRepo extends JpaRepository<Car,Integer> {
    List<Car> findCarByBrand(String brand);
    List<Car> findCarByBrandAndModel(String brand,String model);
    List<Car> findCarByPricePrDayLessThan(double pricePrDay);
    List<Car> findCarByPricePrDayLessThanEqual(double pricePrDay);


}
