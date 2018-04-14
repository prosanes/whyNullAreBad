package whynullsarebad.shouldwe;

import java.util.Optional;

import whynullsarebad.model.Car;
import whynullsarebad.model.Chassi;
import whynullsarebad.model.Cylinders;
import whynullsarebad.model.Engine;

public class CarClassifierNullChecked {
    public String classify(Car car) throws Exception {
        Chassi chassi = car.getChassi();
        if (chassi != null) {
            Integer color = chassi.getColor();

            if (color != null) {
                Engine engine = car.getEngine();
                if (engine != null) {
                    Cylinders cylinders = engine.getCylinders();
                    if (cylinders != null) {
                        int amount = cylinders.getAmount();

                        if (color == 3) {
                            if (amount < 2) {
                                return "coolCar";
                            }
                        } else {
                            if (amount > 10) {
                                return "notSoCoolCar";
                            }
                        }

                        return "normalCar";
                    }
                }
            }
        }

        return "deformedCar";
    }
}
