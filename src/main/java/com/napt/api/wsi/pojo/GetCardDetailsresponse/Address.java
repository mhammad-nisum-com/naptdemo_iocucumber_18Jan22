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
        "addressLineOne",
        "addressLineTwo",
        "addressType",
        "city",
        "countryCode",
        "country",
        "postalCode",
        "state"
})

public class Address {

        @JsonProperty("addressLineOne")
        private String addressLineOne;
        @JsonProperty("addressLineTwo")
        private String addressLineTwo;
        @JsonProperty("addressType")
        private String addressType;
        @JsonProperty("city")
        private String city;
        @JsonProperty("countryCode")
        private String countryCode;
        @JsonProperty("country")
        private String country;
        @JsonProperty("postalCode")
        private String postalCode;
        @JsonProperty("state")
        private String state;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonProperty("addressLineOne")
        public String getAddressLineOne() {
            return addressLineOne;
        }

        @JsonProperty("addressLineOne")
        public void setAddressLineOne(String addressLineOne) {
            this.addressLineOne = addressLineOne;
        }

        @JsonProperty("addressLineTwo")
        public String getAddressLineTwo() {
            return addressLineTwo;
        }

        @JsonProperty("addressLineTwo")
        public void setAddressLineTwo(String addressLineTwo) {
            this.addressLineTwo = addressLineTwo;
        }

        @JsonProperty("addressType")
        public String getAddressType() {
            return addressType;
        }

        @JsonProperty("addressType")
        public void setAddressType(String addressType) {
            this.addressType = addressType;
        }

        @JsonProperty("city")
        public String getCity() {
            return city;
        }

        @JsonProperty("city")
        public void setCity(String city) {
            this.city = city;
        }

        @JsonProperty("countryCode")
        public String getCountryCode() {
            return countryCode;
        }

        @JsonProperty("countryCode")
        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        @JsonProperty("country")
        public String getCountry() {
            return country;
        }

        @JsonProperty("country")
        public void setCountry(String country) {
            this.country = country;
        }

        @JsonProperty("postalCode")
        public String getPostalCode() {
            return postalCode;
        }

        @JsonProperty("postalCode")
        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        @JsonProperty("state")
        public String getState() {
            return state;
        }

        @JsonProperty("state")
        public void setState(String state) {
            this.state = state;
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

