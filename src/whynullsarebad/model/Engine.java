package whynullsarebad.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Engine {
    private Cylinders cylinders;
    private Integer size;
}
