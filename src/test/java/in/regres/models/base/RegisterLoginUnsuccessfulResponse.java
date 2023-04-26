package in.regres.models.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class RegisterLoginUnsuccessfulResponse {
    @JsonProperty("error")
    private String error;
}
