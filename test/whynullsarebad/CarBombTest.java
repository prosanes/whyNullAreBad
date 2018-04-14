package whynullsarebad;

import org.testng.annotations.Test;
import whynullsarebad.factory.Blueprint;
import whynullsarebad.factory.CarFactory;
import whynullsarebad.model.Car;

import static org.testng.Assert.*;

public class CarBombTest {
    @Test
    public void testExplode() throws Exception {
        Blueprint blueprint = new Blueprint("Dynamo",
                "anyChassiKey",
                "bombCar");

        CarFactory carFactory = new CarFactory();
        Car car = carFactory.build(blueprint);

        CarClassifier carClassifier = new CarClassifier();
        assertEquals("normalCar", carClassifier.classify(car));
    }

    @Test
    public void testDoNotExplode() {
        Blueprint blueprint = new Blueprint("S3",
                "anyChassiKey",
                "safeEngine");

        CarFactory carFactory = new CarFactory();
        Car car = carFactory.build(blueprint);

        CarClassifier carClassifier = new CarClassifier();
        assertEquals("normalCar", carClassifier.classify(car));
    }

    @Test
    public void testExplode2() throws Exception {
        Blueprint blueprint = new Blueprint("dynamo",
                                            "anyChassiKey",
                                            "bombCar");

        CarFactory carFactory = new CarFactory();
        Car car = carFactory.build(blueprint);

        CarClassifier carClassifier = new CarClassifier();
        assertEquals("normalCar", carClassifier.classify(car));
    }
}