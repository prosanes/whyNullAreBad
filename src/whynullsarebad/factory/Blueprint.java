package whynullsarebad.factory;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Blueprint {

    private String blueprintOrigin;
    private String chassiKey;
    private String engineKey;
}
