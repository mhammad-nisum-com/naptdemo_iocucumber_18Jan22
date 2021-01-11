
package com.napt.api.safeway.pojo.response.getactivity;

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
    "bay",
    "aisleSeq",
    "level",
    "side",
    "deptShortName"
})
public class ItemAddress {

    @JsonProperty("bay")
    private String bay;
    @JsonProperty("aisleSeq")
    private String aisleSeq;
    @JsonProperty("level")
    private String level;
    @JsonProperty("side")
    private String side;
    @JsonProperty("deptShortName")
    private String deptShortName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("bay")
    public String getBay() {
        return bay;
    }

    @JsonProperty("bay")
    public void setBay(String bay) {
        this.bay = bay;
    }

    @JsonProperty("aisleSeq")
    public String getAisleSeq() {
        return aisleSeq;
    }

    @JsonProperty("aisleSeq")
    public void setAisleSeq(String aisleSeq) {
        this.aisleSeq = aisleSeq;
    }

    @JsonProperty("level")
    public String getLevel() {
        return level;
    }

    @JsonProperty("level")
    public void setLevel(String level) {
        this.level = level;
    }

    @JsonProperty("side")
    public String getSide() {
        return side;
    }

    @JsonProperty("side")
    public void setSide(String side) {
        this.side = side;
    }

    @JsonProperty("deptShortName")
    public String getDeptShortName() {
        return deptShortName;
    }

    @JsonProperty("deptShortName")
    public void setDeptShortName(String deptShortName) {
        this.deptShortName = deptShortName;
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
