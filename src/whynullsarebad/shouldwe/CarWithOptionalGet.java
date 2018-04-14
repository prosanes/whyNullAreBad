package whynullsarebad.shouldwe;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import whynullsarebad.model.Engine;

@AllArgsConstructor
public class CarWithOptionalGet {
    @Getter
    @Setter
    @NonNull
    private Engine engine;

    @Setter
    private WindowFilm windowFilmOptional;

    public Optional<WindowFilm> getWindowFilm() {
        return Optional.ofNullable(windowFilmOptional);
    }

    @Data
    private class WindowFilm {
        private int opacity;
    }
}
