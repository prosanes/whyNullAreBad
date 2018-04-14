package whynullsarebad;

import java.util.Optional;

import org.testng.annotations.Test;
import whynullsarebad.factory.Blueprint;
import whynullsarebad.factory.CarFactory;
import whynullsarebad.model.Car;
import whynullsarebad.model.Chassi;
import whynullsarebad.model.Cylinders;
import whynullsarebad.model.Engine;

import static org.testng.Assert.*;

public class CarBombTest {
    @Test
    public void testExplode() throws Exception {
        Blueprint blueprint = new Blueprint("Dynamo",
                "anyChassiKey",
                "bombCar");

        CarFactory carFactory = new CarFactory();
        Optional<Car> car = carFactory.build(blueprint);

        CarClassifier carClassifier = new CarClassifier();
        car.ifPresent(c -> assertEquals("normalCar", carClassifier.classify(c)));
    }

    @Test
    public void testDoNotExplode() {
        Blueprint blueprint = new Blueprint("S3",
                "anyChassiKey",
                "safeEngine");

        CarFactory carFactory = new CarFactory();
        Optional<Car> car = carFactory.build(blueprint);

        CarClassifier carClassifier = new CarClassifier();
        car.ifPresent(c -> assertEquals("normalCar", carClassifier.classify(c)));
    }

    @Test
    public void testNoLongerExplodes() throws Exception {
        Blueprint blueprint = new Blueprint("dynamo",
                                            "anyChassiKey",
                                            "bombCar");

        CarFactory carFactory = new CarFactory();
        Optional<Car> car = carFactory.build(blueprint);

        CarClassifier carClassifier = new CarClassifier();
        car.ifPresent(c -> assertEquals("normalCar", c));
    }
}