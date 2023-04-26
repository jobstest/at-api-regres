package in.regres.models.create_update;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateResponse {
	@JsonProperty("created_at")
	private String createdAt;
	@JsonProperty("name")
	private String name;
	private String id;
	@JsonProperty("job")
	private String job;
}
