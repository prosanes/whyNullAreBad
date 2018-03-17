package whynullsarebad.model;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Chassi {
    private Integer model;
    private Integer color;

    public Chassi(Integer model, Integer color) {
        this.model = model;
        this.color = color;
    }

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }
}
