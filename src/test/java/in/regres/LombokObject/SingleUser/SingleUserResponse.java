package in.regres.LombokObject.SingleUser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SingleUserResponse {
    @JsonProperty("data")
    private SingleUserData data;
    @JsonProperty("support")
    private SingleUserSupport support;
}
