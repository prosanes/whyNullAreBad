package whynullsarebad.shouldwe;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Vector;
import java.util.stream.Collectors;

import whynullsarebad.model.Car;

public class CarFetcher {
    public Optional<List<Car>> fetchCars(Integer cylynderAmount) {
        List<Car> cars = fetchAllCars().stream()
                                       .filter(car -> car.getEngine().getCylinders().getAmount() == cylynderAmount)
                                       .collect(Collectors.toList());

        if (cars.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(cars);
        }
    }

    private List<Car> fetchAllCars() {
        return new Vector<>();
    }
}
