package in.regres.LombokObject.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceData {
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
