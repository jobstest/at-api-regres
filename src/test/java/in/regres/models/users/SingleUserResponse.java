package in.regres.models.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import in.regres.models.base.Support;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SingleUserResponse {
    @JsonProperty("data")
    private UserData data;
    @JsonProperty("support")
    private Support support;
}
