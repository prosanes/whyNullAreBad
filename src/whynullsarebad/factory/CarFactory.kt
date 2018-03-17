package whynullsarebad.factory

import whynullsarebad.model.Car
import whynullsarebad.model.Chassi
import whynullsarebad.model.Cylinders
import whynullsarebad.model.Engine

class CarFactory {
    fun build(blueprint: Blueprint): Car {
        val car = Car()
        var chassi: Chassi? = null
        var engine: Engine? = null

        if (blueprint.blueprintOrigin == "S3") {
            chassi = getChassiFromS3(chassiKey = blueprint.chassiKey)
            engine = getEngineFromS3(engineKey = blueprint.engineKey)
        } else if (blueprint.blueprintOrigin == "Dynamo") {
            chassi = getChassiFromDynamo(key = blueprint.chassiKey)
            engine = getEngineFromDynamo(key = blueprint.engineKey)
        }

        car.chassi = chassi;
        car.engine = engine

        return car
    }

    private fun getEngineFromS3(engineKey: String?): Engine {
        return Engine(Cylinders(7), 8)
    }

    private fun getChassiFromS3(chassiKey: String?): Chassi {
        return Chassi(5, 6)
    }

    private fun getChassiFromDynamo(key: String?): Chassi {
        return Chassi(1, 2)
    }

    private fun getEngineFromDynamo(key: String?): Engine {
        return if (key == "bombCar") {
            var size : Int? = 2
//            Engine(cylinders =  null, size = size)
            Engine(cylinders = null!!, size = size!!)
        } else {
            Engine(Cylinders(2), 4)
        }
    }
}
