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
        "accountId",
        "last4Digits",
        "cardExpiry",
        "cardType",
        "tokenKey",
        "checkCode",
        "matchToken",
        "paymentToken"
})
public class CreditCard {

    @JsonProperty("accountId")
    private String accountId;
    @JsonProperty("last4Digits")
    private String last4Digits;
    @JsonProperty("cardExpiry")
    private String cardExpiry;
    @JsonProperty("cardType")
    private String cardType;
    @JsonProperty("tokenKey")
    private String tokenKey;
    @JsonProperty("checkCode")
    private String checkCode;
    @JsonProperty("matchToken")
    private String matchToken;
    @JsonProperty("paymentToken")
    private String paymentToken;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("accountId")
    public String getAccountId() {
        return accountId;
    }

    @JsonProperty("accountId")
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @JsonProperty("last4Digits")
    public String getLast4Digits() {
        return last4Digits;
    }

    @JsonProperty("last4Digits")
    public void setLast4Digits(String last4Digits) {
        this.last4Digits = last4Digits;
    }

    @JsonProperty("cardExpiry")
    public String getCardExpiry() {
        return cardExpiry;
    }

    @JsonProperty("cardExpiry")
    public void setCardExpiry(String cardExpiry) {
        this.cardExpiry = cardExpiry;
    }

    @JsonProperty("cardType")
    public String getCardType() {
        return cardType;
    }

    @JsonProperty("cardType")
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @JsonProperty("tokenKey")
    public String getTokenKey() {
        return tokenKey;
    }

    @JsonProperty("tokenKey")
    public void setTokenKey(String tokenKey) {
        this.tokenKey = tokenKey;
    }

    @JsonProperty("checkCode")
    public String getCheckCode() {
        return checkCode;
    }

    @JsonProperty("checkCode")
    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    @JsonProperty("matchToken")
    public String getMatchToken() {
        return matchToken;
    }

    @JsonProperty("matchToken")
    public void setMatchToken(String matchToken) {
        this.matchToken = matchToken;
    }

    @JsonProperty("paymentToken")
    public String getPaymentToken() {
        return paymentToken;
    }

    @JsonProperty("paymentToken")
    public void setPaymentToken(String paymentToken) {
        this.paymentToken = paymentToken;
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

