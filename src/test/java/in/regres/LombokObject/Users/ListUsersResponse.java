package in.regres.LombokObject.Users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import in.regres.LombokObject.Base.Support;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListUsersResponse {
    @JsonProperty("per_page")
    private Integer perPage;
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("data")
    private List<UserData> data;
    @JsonProperty("page")
    private Integer page;
    @JsonProperty("total_pages")
    private Integer totalPages;
    @JsonProperty("support")
    private Support support;
}