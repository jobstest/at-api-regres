package in.regres.LombokObject.SingleUser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SingleUserSupport {
    @JsonProperty("url")
    private String url;
    @JsonProperty("text")
    private String text;

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
