package in.regres.models.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceDataResponse {
	@JsonProperty("color")
	private String color;
	@JsonProperty("year")
	private Integer year;
	@JsonProperty("name")
	private String name;
	private Integer id;
	@JsonProperty("pantone_value")
	private String pantoneValue;
}
