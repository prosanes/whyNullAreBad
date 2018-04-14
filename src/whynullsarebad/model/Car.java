package whynullsarebad.model;

import lombok.Data;
import lombok.NonNull;
import whynullsarebad.factory.Blueprint;

@Data
public class Car {
    @NonNull
    private Chassi chassi;
    @NonNull
    private Engine engine;
}
