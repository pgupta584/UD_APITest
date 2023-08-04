
package pojoClass.accountRequest;

import com.fasterxml.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cycleID",
    "cycleCode",
    "dispatchModes",
    "attributes"
})
public class StatementPreferences {

    @JsonProperty("cycleID")
    private String cycleID;
    @JsonProperty("cycleCode")
    private Integer cycleCode;
    @JsonProperty("dispatchModes")
    private List<String> dispatchModes;
    @JsonProperty("attributes")
    private Attributes attributes;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("cycleID")
    public String getCycleID() {
        return cycleID;
    }

    @JsonProperty("cycleID")
    public void setCycleID(String cycleID) {
        this.cycleID = cycleID;
    }

    @JsonProperty("cycleCode")
    public Integer getCycleCode() {
        return cycleCode;
    }

    @JsonProperty("cycleCode")
    public void setCycleCode(Integer cycleCode) {
        this.cycleCode = cycleCode;
    }

    @JsonProperty("dispatchModes")
    public List<String> getDispatchModes() {
        return dispatchModes;
    }

    @JsonProperty("dispatchModes")
    public void setDispatchModes(List<String> dispatchModes) {
        this.dispatchModes = dispatchModes;
    }

    @JsonProperty("attributes")
    public Attributes getAttributes() {
        return attributes;
    }

    @JsonProperty("attributes")
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
