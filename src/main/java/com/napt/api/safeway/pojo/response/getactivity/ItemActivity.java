
package com.napt.api.safeway.pojo.response.getactivity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "itemId",
    "itemAddress",
    "imageURL",
    "itemDescription",
    "attemptToRemove",
    "qty",
    "pickedUpcCodes",
    "shortedItemUpc",
    "exceptionQty",
    "processedQty",
    "entityReference",
    "instruction",
    "amount",
    "completionTime",
    "subAllowed",
    "seqNumber",
    "subCode",
    "subValue",
    "primaryUpc",
    "uom",
    "pluCode",
    "sellByWeightInd",
    "depName",
    "itemWeight",
    "itemWeightUom",
    "storageType",
    "customerOrderNumber"
})
public class ItemActivity {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("itemId")
    private String itemId;
    @JsonProperty("itemAddress")
    private ItemAddress itemAddress;
    @JsonProperty("imageURL")
    private String imageURL;
    @JsonProperty("itemDescription")
    private String itemDescription;
    @JsonProperty("attemptToRemove")
    private Boolean attemptToRemove;
    @JsonProperty("qty")
    private Double qty;
    @JsonProperty("pickedUpcCodes")
    private List<Object> pickedUpcCodes = null;
    @JsonProperty("shortedItemUpc")
    private List<Object> shortedItemUpc = null;
    @JsonProperty("exceptionQty")
    private Double exceptionQty;
    @JsonProperty("processedQty")
    private Double processedQty;
    @JsonProperty("entityReference")
    private EntityReference_ entityReference;
    @JsonProperty("instruction")
    private Instruction instruction;
    @JsonProperty("amount")
    private Amount amount;
    @JsonProperty("completionTime")
    private Object completionTime;
    @JsonProperty("subAllowed")
    private Boolean subAllowed;
    @JsonProperty("seqNumber")
    private Integer seqNumber;
    @JsonProperty("subCode")
    private String subCode;
    @JsonProperty("subValue")
    private String subValue;
    @JsonProperty("primaryUpc")
    private String primaryUpc;
    @JsonProperty("uom")
    private String uom;
    @JsonProperty("pluCode")
    private String pluCode;
    @JsonProperty("sellByWeightInd")
    private String sellByWeightInd;
    @JsonProperty("depName")
    private String depName;
    @JsonProperty("itemWeight")
    private String itemWeight;
    @JsonProperty("itemWeightUom")
    private String itemWeightUom;
    @JsonProperty("storageType")
    private String storageType;
    @JsonProperty("customerOrderNumber")
    private String customerOrderNumber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("itemId")
    public String getItemId() {
        return itemId;
    }

    @JsonProperty("itemId")
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @JsonProperty("itemAddress")
    public ItemAddress getItemAddress() {
        return itemAddress;
    }

    @JsonProperty("itemAddress")
    public void setItemAddress(ItemAddress itemAddress) {
        this.itemAddress = itemAddress;
    }

    @JsonProperty("imageURL")
    public String getImageURL() {
        return imageURL;
    }

    @JsonProperty("imageURL")
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @JsonProperty("itemDescription")
    public String getItemDescription() {
        return itemDescription;
    }

    @JsonProperty("itemDescription")
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    @JsonProperty("attemptToRemove")
    public Boolean getAttemptToRemove() {
        return attemptToRemove;
    }

    @JsonProperty("attemptToRemove")
    public void setAttemptToRemove(Boolean attemptToRemove) {
        this.attemptToRemove = attemptToRemove;
    }

    @JsonProperty("qty")
    public Double getQty() {
        return qty;
    }

    @JsonProperty("qty")
    public void setQty(Double qty) {
        this.qty = qty;
    }

    @JsonProperty("pickedUpcCodes")
    public List<Object> getPickedUpcCodes() {
        return pickedUpcCodes;
    }

    @JsonProperty("pickedUpcCodes")
    public void setPickedUpcCodes(List<Object> pickedUpcCodes) {
        this.pickedUpcCodes = pickedUpcCodes;
    }

    @JsonProperty("shortedItemUpc")
    public List<Object> getShortedItemUpc() {
        return shortedItemUpc;
    }

    @JsonProperty("shortedItemUpc")
    public void setShortedItemUpc(List<Object> shortedItemUpc) {
        this.shortedItemUpc = shortedItemUpc;
    }

    @JsonProperty("exceptionQty")
    public Double getExceptionQty() {
        return exceptionQty;
    }

    @JsonProperty("exceptionQty")
    public void setExceptionQty(Double exceptionQty) {
        this.exceptionQty = exceptionQty;
    }

    @JsonProperty("processedQty")
    public Double getProcessedQty() {
        return processedQty;
    }

    @JsonProperty("processedQty")
    public void setProcessedQty(Double processedQty) {
        this.processedQty = processedQty;
    }

    @JsonProperty("entityReference")
    public EntityReference_ getEntityReference() {
        return entityReference;
    }

    @JsonProperty("entityReference")
    public void setEntityReference(EntityReference_ entityReference) {
        this.entityReference = entityReference;
    }

    @JsonProperty("instruction")
    public Instruction getInstruction() {
        return instruction;
    }

    @JsonProperty("instruction")
    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }

    @JsonProperty("amount")
    public Amount getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    @JsonProperty("completionTime")
    public Object getCompletionTime() {
        return completionTime;
    }

    @JsonProperty("completionTime")
    public void setCompletionTime(Object completionTime) {
        this.completionTime = completionTime;
    }

    @JsonProperty("subAllowed")
    public Boolean getSubAllowed() {
        return subAllowed;
    }

    @JsonProperty("subAllowed")
    public void setSubAllowed(Boolean subAllowed) {
        this.subAllowed = subAllowed;
    }

    @JsonProperty("seqNumber")
    public Integer getSeqNumber() {
        return seqNumber;
    }

    @JsonProperty("seqNumber")
    public void setSeqNumber(Integer seqNumber) {
        this.seqNumber = seqNumber;
    }

    @JsonProperty("subCode")
    public String getSubCode() {
        return subCode;
    }

    @JsonProperty("subCode")
    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    @JsonProperty("subValue")
    public String getSubValue() {
        return subValue;
    }

    @JsonProperty("subValue")
    public void setSubValue(String subValue) {
        this.subValue = subValue;
    }

    @JsonProperty("primaryUpc")
    public String getPrimaryUpc() {
        return primaryUpc;
    }

    @JsonProperty("primaryUpc")
    public void setPrimaryUpc(String primaryUpc) {
        this.primaryUpc = primaryUpc;
    }

    @JsonProperty("uom")
    public String getUom() {
        return uom;
    }

    @JsonProperty("uom")
    public void setUom(String uom) {
        this.uom = uom;
    }

    @JsonProperty("pluCode")
    public String getPluCode() {
        return pluCode;
    }

    @JsonProperty("pluCode")
    public void setPluCode(String pluCode) {
        this.pluCode = pluCode;
    }

    @JsonProperty("sellByWeightInd")
    public String getSellByWeightInd() {
        return sellByWeightInd;
    }

    @JsonProperty("sellByWeightInd")
    public void setSellByWeightInd(String sellByWeightInd) {
        this.sellByWeightInd = sellByWeightInd;
    }

    @JsonProperty("depName")
    public String getDepName() {
        return depName;
    }

    @JsonProperty("depName")
    public void setDepName(String depName) {
        this.depName = depName;
    }

    @JsonProperty("itemWeight")
    public String getItemWeight() {
        return itemWeight;
    }

    @JsonProperty("itemWeight")
    public void setItemWeight(String itemWeight) {
        this.itemWeight = itemWeight;
    }

    @JsonProperty("itemWeightUom")
    public String getItemWeightUom() {
        return itemWeightUom;
    }

    @JsonProperty("itemWeightUom")
    public void setItemWeightUom(String itemWeightUom) {
        this.itemWeightUom = itemWeightUom;
    }

    @JsonProperty("storageType")
    public String getStorageType() {
        return storageType;
    }

    @JsonProperty("storageType")
    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    @JsonProperty("customerOrderNumber")
    public String getCustomerOrderNumber() {
        return customerOrderNumber;
    }

    @JsonProperty("customerOrderNumber")
    public void setCustomerOrderNumber(String customerOrderNumber) {
        this.customerOrderNumber = customerOrderNumber;
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
