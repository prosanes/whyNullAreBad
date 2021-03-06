package whynullsarebad

import org.testng.annotations.Test
import whynullsarebad.factory.Blueprint
import whynullsarebad.factory.CarFactory
import whynullsarebad.model.Car

import org.testng.Assert.*

class CarBombTest {
    @Test
    @Throws(Exception::class)
    fun testExplode() {
        val blueprint = Blueprint("Dynamo",
                "anyChassiKey",
                "bombCar")

        val carFactory = CarFactory()
        val car = carFactory.build(blueprint)

        val carClassifier = CarClassifier()
        assertEquals("normalCar", carClassifier.classify(car))
    }

    @Test
    fun testDoNotExplode() {
        val blueprint = Blueprint("S3",
                "anyChassiKey",
                "safeEngine")

        val carFactory = CarFactory()
        val car = carFactory.build(blueprint)

        val carClassifier = CarClassifier()
        assertEquals("normalCar", carClassifier.classify(car))
    }
}