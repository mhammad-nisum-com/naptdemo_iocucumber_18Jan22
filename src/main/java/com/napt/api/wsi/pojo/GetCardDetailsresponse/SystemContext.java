package com.napt.api.wsi.pojo.GetCardDetailsresponse;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "environmentIdentifier",
        "sourceSystemIdentifier",
        "transactionId",
        "transactionTime",
        "testingMode"
})
public class SystemContext {

    @JsonProperty("environmentIdentifier")
    private String environmentIdentifier;
    @JsonProperty("sourceSystemIdentifier")
    private String sourceSystemIdentifier;
    @JsonProperty("transactionId")
    private String transactionId;
    @JsonProperty("transactionTime")
    private String transactionTime;
    @JsonProperty("testingMode")
    private Boolean testingMode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("environmentIdentifier")
    public String getEnvironmentIdentifier() {
        return environmentIdentifier;
    }

    @JsonProperty("environmentIdentifier")
    public void setEnvironmentIdentifier(String environmentIdentifier) {
        this.environmentIdentifier = environmentIdentifier;
    }

    @JsonProperty("sourceSystemIdentifier")
    public String getSourceSystemIdentifier() {
        return sourceSystemIdentifier;
    }

    @JsonProperty("sourceSystemIdentifier")
    public void setSourceSystemIdentifier(String sourceSystemIdentifier) {
        this.sourceSystemIdentifier = sourceSystemIdentifier;
    }

    @JsonProperty("transactionId")
    public String getTransactionId() {
        return transactionId;
    }

    @JsonProperty("transactionId")
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @JsonProperty("transactionTime")
    public String getTransactionTime() {
        return transactionTime;
    }

    @JsonProperty("transactionTime")
    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    @JsonProperty("testingMode")
    public Boolean getTestingMode() {
        return testingMode;
    }

    @JsonProperty("testingMode")
    public void setTestingMode(Boolean testingMode) {
        this.testingMode = testingMode;
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