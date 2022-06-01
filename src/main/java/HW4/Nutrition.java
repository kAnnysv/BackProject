package HW4;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "nutrients"
})
@Data

public class Nutrition {
    @JsonProperty("nutrients")
    private List<Nutrient> nutrients = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


}
