package com.napt.api.safeway.pojo.request.ldap;


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
        "app_id",
        "grant_type",
        "password",
        "user_id"
})
public class Request {

    @JsonProperty("app_id")
    private String app_id;
    @JsonProperty("grant_type")
    private String grant_type;
    @JsonProperty("password")
    private String password;
    @JsonProperty("user_id")
    private String user_id;


    @JsonProperty("app_id")
    public String getAppId() {
        return app_id;
    }

    @JsonProperty("app_id")
    public void setAppId(String appId) {
        this.app_id = appId;
    }

    @JsonProperty("grant_type")
    public String getGrant_Type() {
        return grant_type;
    }

    @JsonProperty("grant_type")
    public void setGrant_type(String grantType) {
        this.grant_type = grantType;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("user_id")
    public String getUser_id() {
        return user_id;
    }

    @JsonProperty("user_id")
    public void setUser_id(String userId) {
        this.user_id = userId;
    }


}