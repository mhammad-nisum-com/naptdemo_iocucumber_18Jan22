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
        "httpStatus",
        "systemContext",
        "cardAccountDetails",
        "creditCard"
})
public class Example {

    @JsonProperty("httpStatus")
    private String httpStatus;
    @JsonProperty("systemContext")
    private SystemContext systemContext;
    @JsonProperty("cardAccountDetails")
    private CardAccountDetails cardAccountDetails;
    @JsonProperty("creditCard")
    private CreditCard creditCard;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("httpStatus")
    public String getHttpStatus() {
        return httpStatus;
    }

    @JsonProperty("httpStatus")
    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    @JsonProperty("systemContext")
    public SystemContext getSystemContext() {
        return systemContext;
    }

    @JsonProperty("systemContext")
    public void setSystemContext(SystemContext systemContext) {
        this.systemContext = systemContext;
    }

    @JsonProperty("cardAccountDetails")
    public CardAccountDetails getCardAccountDetails() {
        return cardAccountDetails;
    }

    @JsonProperty("cardAccountDetails")
    public void setCardAccountDetails(CardAccountDetails cardAccountDetails) {
        this.cardAccountDetails = cardAccountDetails;
    }
    @JsonProperty("creditCard")
    public CreditCard getCreditCard() {
        return creditCard;
    }
    @JsonProperty("creditCard")
    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
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
