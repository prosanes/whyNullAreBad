package whynullsarebad.model;

import lombok.Data;
import whynullsarebad.factory.Blueprint;

@Data
public class Car {
    private Chassi chassi;
    private Engine engine;
    private Blueprint blueprint;
}
