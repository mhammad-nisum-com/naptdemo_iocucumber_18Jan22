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
            "partnerRequestId",
            "firstName",
            "lastName",
            "emailAddress",
            "phone",
            "address",
            "creditCard",
            "terminalId",
            "storeId",
            "associateId",
            "channelType",
            "enrollmentConcept",
            "partnerName"
    })
    public class CardAccountDetails {

        @JsonProperty("partnerRequestId")
        private String partnerRequestId;
        @JsonProperty("firstName")
        private String firstName;
        @JsonProperty("lastName")
        private String lastName;
        @JsonProperty("emailAddress")
        private String emailAddress;
        @JsonProperty("phone")
        private String phone;
        @JsonProperty("address")
        private Address address;
        @JsonProperty("creditCard")
        private CreditCard creditCard;
        @JsonProperty("terminalId")
        private String terminalId;
        @JsonProperty("storeId")
        private String storeId;
        @JsonProperty("associateId")
        private String associateId;
        @JsonProperty("channelType")
        private String channelType;
        @JsonProperty("enrollmentConcept")
        private String enrollmentConcept;
        @JsonProperty("partnerName")
        private String partnerName;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonProperty("partnerRequestId")
        public String getPartnerRequestId() {
            return partnerRequestId;
        }

        @JsonProperty("partnerRequestId")
        public void setPartnerRequestId(String partnerRequestId) {
            this.partnerRequestId = partnerRequestId;
        }

        @JsonProperty("firstName")
        public String getFirstName() {
            return firstName;
        }

        @JsonProperty("firstName")
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        @JsonProperty("lastName")
        public String getLastName() {
            return lastName;
        }

        @JsonProperty("lastName")
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @JsonProperty("emailAddress")
        public String getEmailAddress() {
            return emailAddress;
        }

        @JsonProperty("emailAddress")
        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        @JsonProperty("phone")
        public String getPhone() {
            return phone;
        }

        @JsonProperty("phone")
        public void setPhone(String phone) {
            this.phone = phone;
        }

        @JsonProperty("address")
        public Address getAddress() {
            return address;
        }

        @JsonProperty("address")
        public void setAddress(Address address) {
            this.address = address;
        }
        @JsonProperty("creditCard")
        public CreditCard getCreditCard() {
            return creditCard;
        }

        @JsonProperty("creditCard")
        public void setCreditCard(CreditCard creditCard) {
            this.creditCard = creditCard;
        }



        @JsonProperty("terminalId")
        public String getTerminalId() {
            return terminalId;
        }

        @JsonProperty("terminalId")
        public void setTerminalId(String terminalId) {
            this.terminalId = terminalId;
        }

        @JsonProperty("storeId")
        public String getStoreId() {
            return storeId;
        }

        @JsonProperty("storeId")
        public void setStoreId(String storeId) {
            this.storeId = storeId;
        }

        @JsonProperty("associateId")
        public String getAssociateId() {
            return associateId;
        }

        @JsonProperty("associateId")
        public void setAssociateId(String associateId) {
            this.associateId = associateId;
        }

        @JsonProperty("channelType")
        public String getChannelType() {
            return channelType;
        }

        @JsonProperty("channelType")
        public void setChannelType(String channelType) {
            this.channelType = channelType;
        }

        @JsonProperty("enrollmentConcept")
        public String getEnrollmentConcept() {
            return enrollmentConcept;
        }

        @JsonProperty("enrollmentConcept")
        public void setEnrollmentConcept(String enrollmentConcept) {
            this.enrollmentConcept = enrollmentConcept;
        }

        @JsonProperty("partnerName")
        public String getPartnerName() {
            return partnerName;
        }

        @JsonProperty("partnerName")
        public void setPartnerName(String partnerName) {
            this.partnerName = partnerName;
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

