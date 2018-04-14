package whynullsarebad.shouldwe;

import java.util.List;
import java.util.Optional;

import whynullsarebad.model.Car;

public class CarReporter {
    public void report(String title, List<Car> cars, Optional<String> descriptionOptional) {
        System.out.println(title);
        cars.forEach(System.out::print);
        descriptionOptional.ifPresent(System.out::println);
    }
}
