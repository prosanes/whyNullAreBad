package whynullsarebad.factory;

import whynullsarebad.model.Car;
import whynullsarebad.model.Chassi;
import whynullsarebad.model.Cylinders;
import whynullsarebad.model.Engine;

public class CarFactory {
    public Car build(Blueprint blueprint) {
        Car car = new Car();
        Chassi chassi = null;
        Engine engine = null;

        if (blueprint.getBlueprintOrigin().equals("S3")) {
            chassi = getChassiFromS3(blueprint.getChassiKey());
            engine = getEngineFromS3(blueprint.getEngineKey());
        } else if (blueprint.getBlueprintOrigin().equals("Dynamo")) {
            chassi = getChassiFromDynamo(blueprint.getChassiKey());
            engine = getEngineFromDynamo(blueprint.getEngineKey());
        }

        car.setChassi(chassi);
        car.setEngine(engine);

        return car;
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
