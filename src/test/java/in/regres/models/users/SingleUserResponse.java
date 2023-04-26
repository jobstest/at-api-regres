package in.regres.models.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import in.regres.models.base.SupportResponse;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SingleUserResponse {
    @JsonProperty("data")
    private UserDataResponse data;
    @JsonProperty("support")
    private SupportResponse support;
}
