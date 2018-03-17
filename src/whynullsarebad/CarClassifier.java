package whynullsarebad;

import whynullsarebad.model.Car;

public class CarClassifier {
    public String classify(Car car) {
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
