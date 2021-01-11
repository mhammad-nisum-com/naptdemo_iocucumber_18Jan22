
package com.napt.api.safeway.pojo.response.searchactivities;

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
    "actId",
    "erId",
    "siteId",
    "status",
    "expectedEndTime",
    "completionTime",
    "actType",
    "batch",
    "routeVanNumber",
    "activityNo",
    "storageTypes",
    "entityIds",
    "assignedTo",
    "handshakeType",
    "slotStartDate",
    "slotEndDate",
    "entityReference",
    "expectedCount",
    "processedQty",
    "exceptionQty",
    "pickUpBay",
    "contactFirstName",
    "contactLastName",
    "stopNumber",
    "bagCountRequired",
    "reProcess",
    "itemQty",
    "seqNo",
    "totalSeqNo",
    "customerOrderNumber",
    "prevActivityId",
    "fulfillment",
    "fulfillmentType"
})
public class Datum {

    @JsonProperty("actId")
    private Integer actId;
    @JsonProperty("erId")
    private Integer erId;
    @JsonProperty("siteId")
    private String siteId;
    @JsonProperty("status")
    private String status;
    @JsonProperty("expectedEndTime")
    private String expectedEndTime;
    @JsonProperty("completionTime")
    private Object completionTime;
    @JsonProperty("actType")
    private String actType;
    @JsonProperty("batch")
    private String batch;
    @JsonProperty("routeVanNumber")
    private String routeVanNumber;
    @JsonProperty("activityNo")
    private String activityNo;
    @JsonProperty("storageTypes")
    private List<String> storageTypes = null;
    @JsonProperty("entityIds")
    private List<String> entityIds = null;
    @JsonProperty("assignedTo")
    private Object assignedTo;
    @JsonProperty("handshakeType")
    private Object handshakeType;
    @JsonProperty("slotStartDate")
    private String slotStartDate;
    @JsonProperty("slotEndDate")
    private String slotEndDate;
    @JsonProperty("entityReference")
    private EntityReference entityReference;
    @JsonProperty("expectedCount")
    private Integer expectedCount;
    @JsonProperty("processedQty")
    private Object processedQty;
    @JsonProperty("exceptionQty")
    private Object exceptionQty;
    @JsonProperty("pickUpBay")
    private Object pickUpBay;
    @JsonProperty("contactFirstName")
    private String contactFirstName;
    @JsonProperty("contactLastName")
    private String contactLastName;
    @JsonProperty("stopNumber")
    private String stopNumber;
    @JsonProperty("bagCountRequired")
    private Boolean bagCountRequired;
    @JsonProperty("reProcess")
    private Boolean reProcess;
    @JsonProperty("itemQty")
    private Double itemQty;
    @JsonProperty("seqNo")
    private String seqNo;
    @JsonProperty("totalSeqNo")
    private String totalSeqNo;
    @JsonProperty("customerOrderNumber")
    private String customerOrderNumber;
    @JsonProperty("prevActivityId")
    private Object prevActivityId;
    @JsonProperty("fulfillment")
    private Fulfillment fulfillment;
    @JsonProperty("fulfillmentType")
    private String fulfillmentType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("actId")
    public Integer getActId() {
        return actId;
    }

    @JsonProperty("actId")
    public void setActId(Integer actId) {
        this.actId = actId;
    }

    @JsonProperty("erId")
    public Integer getErId() {
        return erId;
    }

    @JsonProperty("erId")
    public void setErId(Integer erId) {
        this.erId = erId;
    }

    @JsonProperty("siteId")
    public String getSiteId() {
        return siteId;
    }

    @JsonProperty("siteId")
    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("expectedEndTime")
    public String getExpectedEndTime() {
        return expectedEndTime;
    }

    @JsonProperty("expectedEndTime")
    public void setExpectedEndTime(String expectedEndTime) {
        this.expectedEndTime = expectedEndTime;
    }

    @JsonProperty("completionTime")
    public Object getCompletionTime() {
        return completionTime;
    }

    @JsonProperty("completionTime")
    public void setCompletionTime(Object completionTime) {
        this.completionTime = completionTime;
    }

    @JsonProperty("actType")
    public String getActType() {
        return actType;
    }

    @JsonProperty("actType")
    public void setActType(String actType) {
        this.actType = actType;
    }

    @JsonProperty("batch")
    public String getBatch() {
        return batch;
    }

    @JsonProperty("batch")
    public void setBatch(String batch) {
        this.batch = batch;
    }

    @JsonProperty("routeVanNumber")
    public String getRouteVanNumber() {
        return routeVanNumber;
    }

    @JsonProperty("routeVanNumber")
    public void setRouteVanNumber(String routeVanNumber) {
        this.routeVanNumber = routeVanNumber;
    }

    @JsonProperty("activityNo")
    public String getActivityNo() {
        return activityNo;
    }

    @JsonProperty("activityNo")
    public void setActivityNo(String activityNo) {
        this.activityNo = activityNo;
    }

    @JsonProperty("storageTypes")
    public List<String> getStorageTypes() {
        return storageTypes;
    }

    @JsonProperty("storageTypes")
    public void setStorageTypes(List<String> storageTypes) {
        this.storageTypes = storageTypes;
    }

    @JsonProperty("entityIds")
    public List<String> getEntityIds() {
        return entityIds;
    }

    @JsonProperty("entityIds")
    public void setEntityIds(List<String> entityIds) {
        this.entityIds = entityIds;
    }

    @JsonProperty("assignedTo")
    public Object getAssignedTo() {
        return assignedTo;
    }

    @JsonProperty("assignedTo")
    public void setAssignedTo(Object assignedTo) {
        this.assignedTo = assignedTo;
    }

    @JsonProperty("handshakeType")
    public Object getHandshakeType() {
        return handshakeType;
    }

    @JsonProperty("handshakeType")
    public void setHandshakeType(Object handshakeType) {
        this.handshakeType = handshakeType;
    }

    @JsonProperty("slotStartDate")
    public String getSlotStartDate() {
        return slotStartDate;
    }

    @JsonProperty("slotStartDate")
    public void setSlotStartDate(String slotStartDate) {
        this.slotStartDate = slotStartDate;
    }

    @JsonProperty("slotEndDate")
    public String getSlotEndDate() {
        return slotEndDate;
    }

    @JsonProperty("slotEndDate")
    public void setSlotEndDate(String slotEndDate) {
        this.slotEndDate = slotEndDate;
    }

    @JsonProperty("entityReference")
    public EntityReference getEntityReference() {
        return entityReference;
    }

    @JsonProperty("entityReference")
    public void setEntityReference(EntityReference entityReference) {
        this.entityReference = entityReference;
    }

    @JsonProperty("expectedCount")
    public Integer getExpectedCount() {
        return expectedCount;
    }

    @JsonProperty("expectedCount")
    public void setExpectedCount(Integer expectedCount) {
        this.expectedCount = expectedCount;
    }

    @JsonProperty("processedQty")
    public Object getProcessedQty() {
        return processedQty;
    }

    @JsonProperty("processedQty")
    public void setProcessedQty(Object processedQty) {
        this.processedQty = processedQty;
    }

    @JsonProperty("exceptionQty")
    public Object getExceptionQty() {
        return exceptionQty;
    }

    @JsonProperty("exceptionQty")
    public void setExceptionQty(Object exceptionQty) {
        this.exceptionQty = exceptionQty;
    }

    @JsonProperty("pickUpBay")
    public Object getPickUpBay() {
        return pickUpBay;
    }

    @JsonProperty("pickUpBay")
    public void setPickUpBay(Object pickUpBay) {
        this.pickUpBay = pickUpBay;
    }

    @JsonProperty("contactFirstName")
    public String getContactFirstName() {
        return contactFirstName;
    }

    @JsonProperty("contactFirstName")
    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    @JsonProperty("contactLastName")
    public String getContactLastName() {
        return contactLastName;
    }

    @JsonProperty("contactLastName")
    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    @JsonProperty("stopNumber")
    public String getStopNumber() {
        return stopNumber;
    }

    @JsonProperty("stopNumber")
    public void setStopNumber(String stopNumber) {
        this.stopNumber = stopNumber;
    }

    @JsonProperty("bagCountRequired")
    public Boolean getBagCountRequired() {
        return bagCountRequired;
    }

    @JsonProperty("bagCountRequired")
    public void setBagCountRequired(Boolean bagCountRequired) {
        this.bagCountRequired = bagCountRequired;
    }

    @JsonProperty("reProcess")
    public Boolean getReProcess() {
        return reProcess;
    }

    @JsonProperty("reProcess")
    public void setReProcess(Boolean reProcess) {
        this.reProcess = reProcess;
    }

    @JsonProperty("itemQty")
    public Double getItemQty() {
        return itemQty;
    }

    @JsonProperty("itemQty")
    public void setItemQty(Double itemQty) {
        this.itemQty = itemQty;
    }

    @JsonProperty("seqNo")
    public String getSeqNo() {
        return seqNo;
    }

    @JsonProperty("seqNo")
    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    @JsonProperty("totalSeqNo")
    public String getTotalSeqNo() {
        return totalSeqNo;
    }

    @JsonProperty("totalSeqNo")
    public void setTotalSeqNo(String totalSeqNo) {
        this.totalSeqNo = totalSeqNo;
    }

    @JsonProperty("customerOrderNumber")
    public String getCustomerOrderNumber() {
        return customerOrderNumber;
    }

    @JsonProperty("customerOrderNumber")
    public void setCustomerOrderNumber(String customerOrderNumber) {
        this.customerOrderNumber = customerOrderNumber;
    }

    @JsonProperty("prevActivityId")
    public Object getPrevActivityId() {
        return prevActivityId;
    }

    @JsonProperty("prevActivityId")
    public void setPrevActivityId(Object prevActivityId) {
        this.prevActivityId = prevActivityId;
    }

    @JsonProperty("fulfillment")
    public Fulfillment getFulfillment() {
        return fulfillment;
    }

    @JsonProperty("fulfillment")
    public void setFulfillment(Fulfillment fulfillment) {
        this.fulfillment = fulfillment;
    }

    @JsonProperty("fulfillmentType")
    public String getFulfillmentType() {
        return fulfillmentType;
    }

    @JsonProperty("fulfillmentType")
    public void setFulfillmentType(String fulfillmentType) {
        this.fulfillmentType = fulfillmentType;
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
