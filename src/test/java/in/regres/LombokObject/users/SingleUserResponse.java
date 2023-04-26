package in.regres.LombokObject.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import in.regres.LombokObject.base.Support;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SingleUserResponse {
    @JsonProperty("data")
    private UserData data;
    @JsonProperty("support")
    private Support support;
}
