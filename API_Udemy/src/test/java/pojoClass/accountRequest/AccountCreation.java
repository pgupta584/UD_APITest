
package pojoClass.accountRequest;

import com.fasterxml.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;
// https://www.jsonschema2pojo.org/ --> Create Pojo Class using this
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "accountHolderID",
    "creditLimit",
    "requestID",
    "statementPreferences",
    "attributes",
    "flags"
})
public class AccountCreation {

    @JsonProperty("name")
    private String name;
    @JsonProperty("accountHolderID")
    private String accountHolderID;
    @JsonProperty("creditLimit")
    private Integer creditLimit;
    @JsonProperty("requestID")
    private String requestID;
    @JsonProperty("statementPreferences")
    private StatementPreferences statementPreferences;
    @JsonProperty("attributes")
    private Attributes__1 attributes;
    @JsonProperty("flags")
    private Flags flags;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("accountHolderID")
    public String getAccountHolderID() {
        return accountHolderID;
    }

    @JsonProperty("accountHolderID")
    public void setAccountHolderID(String accountHolderID) {
        this.accountHolderID = accountHolderID;
    }

    @JsonProperty("creditLimit")
    public Integer getCreditLimit() {
        return creditLimit;
    }

    @JsonProperty("creditLimit")
    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    @JsonProperty("requestID")
    public String getRequestID() {
        return requestID;
    }

    @JsonProperty("requestID")
    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    @JsonProperty("statementPreferences")
    public StatementPreferences getStatementPreferences() {
        return statementPreferences;
    }

    @JsonProperty("statementPreferences")
    public void setStatementPreferences(StatementPreferences statementPreferences) {
        this.statementPreferences = statementPreferences;
    }

    @JsonProperty("attributes")
    public Attributes__1 getAttributes() {
        return attributes;
    }

    @JsonProperty("attributes")
    public void setAttributes(Attributes__1 attributes) {
        this.attributes = attributes;
    }

    @JsonProperty("flags")
    public Flags getFlags() {
        return flags;
    }

    @JsonProperty("flags")
    public void setFlags(Flags flags) {
        this.flags = flags;
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
