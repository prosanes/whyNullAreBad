package whynullsarebad.model;

import lombok.Data;
import whynullsarebad.factory.Blueprint;

public class Car {
    private Chassi chassi;
    private Engine engine;
    private Blueprint blueprint;

    public void setChassi(Chassi chassi) {
        this.chassi = chassi;
    }

    public Chassi getChassi() {
        return chassi;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Blueprint getBlueprint() {
        return blueprint;
    }

    public void setBlueprint(Blueprint blueprint) {
        this.blueprint = blueprint;
    }
}
