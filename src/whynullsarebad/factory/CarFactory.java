package whynullsarebad.factory;

import java.util.Optional;

import whynullsarebad.model.Car;
import whynullsarebad.model.Chassi;
import whynullsarebad.model.Cylinders;
import whynullsarebad.model.Engine;

public class CarFactory {
    public Optional<Car> build(Blueprint blueprint) {
        Car car = null;
        Chassi chassi = null;
        Engine engine = null;

        if (blueprint.getBlueprintOrigin().equals("S3")) {
            chassi = getChassiFromS3(blueprint.getChassiKey());
            engine = getEngineFromS3(blueprint.getEngineKey());
            car = new Car(chassi, engine);
        } else if (blueprint.getBlueprintOrigin().equals("Dynamo")) {
            chassi = getChassiFromDynamo(blueprint.getChassiKey());
            engine = getEngineFromDynamo(blueprint.getEngineKey());
            car = new Car(chassi, engine);
        }

        return Optional.ofNullable(car);
    }

    private Engine getEngineFromS3(String engineKey) {
        return new Engine(new Cylinders(7), 8);
    }

    private Chassi getChassiFromS3(String chassiKey) {
        return new Chassi(5,6);
    }

    private Chassi getChassiFromDynamo(String key) {
        return new Chassi(1, 2);
    }

    private Engine getEngineFromDynamo(String key) {
        if (key.equals("bombCar")) {
            return new Engine(null, 2);
        } else {
            return new Engine(new Cylinders(2), 4);
        }
    }
}
