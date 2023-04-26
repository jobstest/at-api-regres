package in.regres.LombokObject.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import in.regres.LombokObject.base.Support;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SingleResourceResponse {
	@JsonProperty("data")
	private ResourceData data;
	@JsonProperty("support")
	private Support support;
}