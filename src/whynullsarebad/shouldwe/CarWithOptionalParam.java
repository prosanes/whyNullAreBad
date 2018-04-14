package whynullsarebad.shouldwe;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import whynullsarebad.model.Engine;

@Data
@AllArgsConstructor
public class CarWithOptionalParam {
    @NonNull
    private Engine engine;
    @NonNull
    private Optional<WindowFilm> windowFilmOptional;

    @Data
    private class WindowFilm {
        private int opacity;
    }

    // Can we serialize this?
}
