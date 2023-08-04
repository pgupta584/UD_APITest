
package pojoClass.accountRequest;

import com.fasterxml.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "creditBlocked",
    "debitBlocked",
    "delinquent",
    "foreclosed",
    "dontAssessInterest",
    "dontPostInterest",
    "dontAssessFees",
    "dontPostFees",
    "dontAllowHold",
    "dontAllowJit",
    "dontAllowMemo",
    "dontAllowMandate",
    "dontAllowLien",
    "disableTransactionPolicyChecks"
})
public class Flags {

    @JsonProperty("creditBlocked")
    private Boolean creditBlocked;
    @JsonProperty("debitBlocked")
    private Boolean debitBlocked;
    @JsonProperty("delinquent")
    private Boolean delinquent;
    @JsonProperty("foreclosed")
    private Boolean foreclosed;
    @JsonProperty("dontAssessInterest")
    private Boolean dontAssessInterest;
    @JsonProperty("dontPostInterest")
    private Boolean dontPostInterest;
    @JsonProperty("dontAssessFees")
    private Boolean dontAssessFees;
    @JsonProperty("dontPostFees")
    private Boolean dontPostFees;
    @JsonProperty("dontAllowHold")
    private Boolean dontAllowHold;
    @JsonProperty("dontAllowJit")
    private Boolean dontAllowJit;
    @JsonProperty("dontAllowMemo")
    private Boolean dontAllowMemo;
    @JsonProperty("dontAllowMandate")
    private Boolean dontAllowMandate;
    @JsonProperty("dontAllowLien")
    private Boolean dontAllowLien;
    @JsonProperty("disableTransactionPolicyChecks")
    private Boolean disableTransactionPolicyChecks;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("creditBlocked")
    public Boolean getCreditBlocked() {
        return creditBlocked;
    }

    @JsonProperty("creditBlocked")
    public void setCreditBlocked(Boolean creditBlocked) {
        this.creditBlocked = creditBlocked;
    }

    @JsonProperty("debitBlocked")
    public Boolean getDebitBlocked() {
        return debitBlocked;
    }

    @JsonProperty("debitBlocked")
    public void setDebitBlocked(Boolean debitBlocked) {
        this.debitBlocked = debitBlocked;
    }

    @JsonProperty("delinquent")
    public Boolean getDelinquent() {
        return delinquent;
    }

    @JsonProperty("delinquent")
    public void setDelinquent(Boolean delinquent) {
        this.delinquent = delinquent;
    }

    @JsonProperty("foreclosed")
    public Boolean getForeclosed() {
        return foreclosed;
    }

    @JsonProperty("foreclosed")
    public void setForeclosed(Boolean foreclosed) {
        this.foreclosed = foreclosed;
    }

    @JsonProperty("dontAssessInterest")
    public Boolean getDontAssessInterest() {
        return dontAssessInterest;
    }

    @JsonProperty("dontAssessInterest")
    public void setDontAssessInterest(Boolean dontAssessInterest) {
        this.dontAssessInterest = dontAssessInterest;
    }

    @JsonProperty("dontPostInterest")
    public Boolean getDontPostInterest() {
        return dontPostInterest;
    }

    @JsonProperty("dontPostInterest")
    public void setDontPostInterest(Boolean dontPostInterest) {
        this.dontPostInterest = dontPostInterest;
    }

    @JsonProperty("dontAssessFees")
    public Boolean getDontAssessFees() {
        return dontAssessFees;
    }

    @JsonProperty("dontAssessFees")
    public void setDontAssessFees(Boolean dontAssessFees) {
        this.dontAssessFees = dontAssessFees;
    }

    @JsonProperty("dontPostFees")
    public Boolean getDontPostFees() {
        return dontPostFees;
    }

    @JsonProperty("dontPostFees")
    public void setDontPostFees(Boolean dontPostFees) {
        this.dontPostFees = dontPostFees;
    }

    @JsonProperty("dontAllowHold")
    public Boolean getDontAllowHold() {
        return dontAllowHold;
    }

    @JsonProperty("dontAllowHold")
    public void setDontAllowHold(Boolean dontAllowHold) {
        this.dontAllowHold = dontAllowHold;
    }

    @JsonProperty("dontAllowJit")
    public Boolean getDontAllowJit() {
        return dontAllowJit;
    }

    @JsonProperty("dontAllowJit")
    public void setDontAllowJit(Boolean dontAllowJit) {
        this.dontAllowJit = dontAllowJit;
    }

    @JsonProperty("dontAllowMemo")
    public Boolean getDontAllowMemo() {
        return dontAllowMemo;
    }

    @JsonProperty("dontAllowMemo")
    public void setDontAllowMemo(Boolean dontAllowMemo) {
        this.dontAllowMemo = dontAllowMemo;
    }

    @JsonProperty("dontAllowMandate")
    public Boolean getDontAllowMandate() {
        return dontAllowMandate;
    }

    @JsonProperty("dontAllowMandate")
    public void setDontAllowMandate(Boolean dontAllowMandate) {
        this.dontAllowMandate = dontAllowMandate;
    }

    @JsonProperty("dontAllowLien")
    public Boolean getDontAllowLien() {
        return dontAllowLien;
    }

    @JsonProperty("dontAllowLien")
    public void setDontAllowLien(Boolean dontAllowLien) {
        this.dontAllowLien = dontAllowLien;
    }

    @JsonProperty("disableTransactionPolicyChecks")
    public Boolean getDisableTransactionPolicyChecks() {
        return disableTransactionPolicyChecks;
    }

    @JsonProperty("disableTransactionPolicyChecks")
    public void setDisableTransactionPolicyChecks(Boolean disableTransactionPolicyChecks) {
        this.disableTransactionPolicyChecks = disableTransactionPolicyChecks;
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
