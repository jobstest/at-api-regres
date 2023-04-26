package in.regres.models.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import in.regres.models.base.SupportResponse;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SingleResourceResponse {
    @JsonProperty("data")
    private ResourceDataResponse data;
    @JsonProperty("support")
    private SupportResponse support;
}