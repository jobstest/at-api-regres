package in.regres.models.register_login;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterLoginUnsuccessfulResponse {
    @JsonProperty("error")
    private String error;
}
