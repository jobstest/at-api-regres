package in.regres.models.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SupportResponse {
    @JsonProperty("url")
    private String url;
    @JsonProperty("text")
    private String text;
}
