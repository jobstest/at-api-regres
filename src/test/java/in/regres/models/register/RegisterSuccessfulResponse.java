package in.regres.models.register;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterSuccessfulResponse {
    private Integer id;
    private String token;
}
