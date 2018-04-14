package whynullsarebad.shouldwe;

import java.util.Optional;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;

import whynullsarebad.model.Car;

public class CarClassifier {
    public String classify(Optional<Car> carOptional) throws Exception {
        if (!carOptional.isPresent()) {
            throw new Exception("No car supplied");
        }

        Car car = carOptional.get();

        if (car.getChassi()
                .getColor() == 3) {
            if (car.getEngine()
                    .getCylinders()
                    .getAmount() < 2) {
                return "coolCar";
            }
        } else {
            if (car.getEngine()
                    .getCylinders()
                    .getAmount() > 10) {
                return "notSoCoolCar";
            }
        }

        return "normalCar";
    }
}
