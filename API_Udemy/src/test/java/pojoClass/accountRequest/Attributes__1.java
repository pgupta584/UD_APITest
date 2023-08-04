
package pojoClass.accountRequest;

import com.fasterxml.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "currency",
    "account.pd-id",
    "dontPostInterest",
    "dontAssessInterest",
    "issuance.location",
    "ruby.annual-fee.treatment"
})
public class Attributes__1 {

    @JsonProperty("currency")
    private String currency;
    @JsonProperty("account.pd-id")
    private String accountPdId;
    @JsonProperty("dontPostInterest")
    private String dontPostInterest;
    @JsonProperty("dontAssessInterest")
    private String dontAssessInterest;
    @JsonProperty("issuance.location")
    private String issuanceLocation;
    @JsonProperty("ruby.annual-fee.treatment")
    private String rubyAnnualFeeTreatment;
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

    @JsonProperty("dontPostInterest")
    public String getDontPostInterest() {
        return dontPostInterest;
    }

    @JsonProperty("dontPostInterest")
    public void setDontPostInterest(String dontPostInterest) {
        this.dontPostInterest = dontPostInterest;
    }

    @JsonProperty("dontAssessInterest")
    public String getDontAssessInterest() {
        return dontAssessInterest;
    }

    @JsonProperty("dontAssessInterest")
    public void setDontAssessInterest(String dontAssessInterest) {
        this.dontAssessInterest = dontAssessInterest;
    }

    @JsonProperty("issuance.location")
    public String getIssuanceLocation() {
        return issuanceLocation;
    }

    @JsonProperty("issuance.location")
    public void setIssuanceLocation(String issuanceLocation) {
        this.issuanceLocation = issuanceLocation;
    }

    @JsonProperty("ruby.annual-fee.treatment")
    public String getRubyAnnualFeeTreatment() {
        return rubyAnnualFeeTreatment;
    }

    @JsonProperty("ruby.annual-fee.treatment")
    public void setRubyAnnualFeeTreatment(String rubyAnnualFeeTreatment) {
        this.rubyAnnualFeeTreatment = rubyAnnualFeeTreatment;
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
