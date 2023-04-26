package in.regres.models.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import in.regres.models.base.Support;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SingleResourceResponse {
	@JsonProperty("data")
	private ResourceData data;
	@JsonProperty("support")
	private Support support;
}