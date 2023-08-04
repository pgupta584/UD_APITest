
package pojoClass.accountRequest;

import com.fasterxml.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "currency",
    "account.pd-id"
})
public class Attributes {

    @JsonProperty("currency")
    private String currency;
    @JsonProperty("account.pd-id")
    private String accountPdId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("account.pd-id")
    public String getAccountPdId() {
        return accountPdId;
    }

    @JsonProperty("account.pd-id")
    public void setAccountPdId(String accountPdId) {
        this.accountPdId = accountPdId;
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
