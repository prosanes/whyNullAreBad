package whynullsarebad.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
public class Engine {
    @NonNull
    private Cylinders cylinders;
    @NonNull
    private Integer size;
}
