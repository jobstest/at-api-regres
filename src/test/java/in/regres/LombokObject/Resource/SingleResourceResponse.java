package in.regres.LombokObject.Resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import in.regres.LombokObject.Base.Support;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SingleResourceResponse {
	@JsonProperty("data")
	private ResourceData data;
	@JsonProperty("support")
	private Support support;
}