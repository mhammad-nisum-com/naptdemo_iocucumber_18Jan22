
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
    "actId",
    "erId",
    "siteId",
    "createdDate",
    "status",
    "expectedEndTime",
    "completionTime",
    "actType",
    "batch",
    "routeVanNumber",
    "assignedTo",
    "activityNo",
    "storageTypes",
    "handshakeType",
    "slotStartDate",
    "slotEndDate",
    "fulfillmentType",
    "fulfillment",
    "entityReference",
    "containerActivities",
    "itemActivities",
    "expectedCount",
    "itemQty",
    "processedQty",
    "exceptionQty",
    "pickUpBay",
    "contactFirstName",
    "contactLastName",
    "seqNo",
    "totalSeqNo",
    "stopNumber",
    "bagCountRequired",
    "reProcess",
    "bagCount",
    "customerOrderNumber",
    "nextActivityId",
    "prevActivityId"
})
public class Response {

    @JsonProperty("actId")
    private Integer actId;
    @JsonProperty("erId")
    private Integer erId;
    @JsonProperty("siteId")
    private String siteId;
    @JsonProperty("createdDate")
    private String createdDate;
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
    private Object routeVanNumber;
    @JsonProperty("assignedTo")
    private Object assignedTo;
    @JsonProperty("activityNo")
    private String activityNo;
    @JsonProperty("storageTypes")
    private List<String> storageTypes = null;
    @JsonProperty("handshakeType")
    private Object handshakeType;
    @JsonProperty("slotStartDate")
    private String slotStartDate;
    @JsonProperty("slotEndDate")
    private String slotEndDate;
    @JsonProperty("fulfillmentType")
    private String fulfillmentType;
    @JsonProperty("fulfillment")
    private Fulfillment fulfillment;
    @JsonProperty("entityReference")
    private EntityReference entityReference;
    @JsonProperty("containerActivities")
    private Object containerActivities;
    @JsonProperty("itemActivities")
    private List<ItemActivity> itemActivities = null;
    @JsonProperty("expectedCount")
    private Integer expectedCount;
    @JsonProperty("itemQty")
    private Double itemQty;
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
    @JsonProperty("seqNo")
    private String seqNo;
    @JsonProperty("totalSeqNo")
    private String totalSeqNo;
    @JsonProperty("stopNumber")
    private String stopNumber;
    @JsonProperty("bagCountRequired")
    private Boolean bagCountRequired;
    @JsonProperty("reProcess")
    private Boolean reProcess;
    @JsonProperty("bagCount")
    private Object bagCount;
    @JsonProperty("customerOrderNumber")
    private String customerOrderNumber;
    @JsonProperty("nextActivityId")
    private Object nextActivityId;
    @JsonProperty("prevActivityId")
    private Object prevActivityId;
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

    @JsonProperty("createdDate")
    public String getCreatedDate() {
        return createdDate;
    }

    @JsonProperty("createdDate")
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
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
    public Object getRouteVanNumber() {
        return routeVanNumber;
    }

    @JsonProperty("routeVanNumber")
    public void setRouteVanNumber(Object routeVanNumber) {
        this.routeVanNumber = routeVanNumber;
    }

    @JsonProperty("assignedTo")
    public Object getAssignedTo() {
        return assignedTo;
    }

    @JsonProperty("assignedTo")
    public void setAssignedTo(Object assignedTo) {
        this.assignedTo = assignedTo;
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

    @JsonProperty("fulfillmentType")
    public String getFulfillmentType() {
        return fulfillmentType;
    }

    @JsonProperty("fulfillmentType")
    public void setFulfillmentType(String fulfillmentType) {
        this.fulfillmentType = fulfillmentType;
    }

    @JsonProperty("fulfillment")
    public Fulfillment getFulfillment() {
        return fulfillment;
    }

    @JsonProperty("fulfillment")
    public void setFulfillment(Fulfillment fulfillment) {
        this.fulfillment = fulfillment;
    }

    @JsonProperty("entityReference")
    public EntityReference getEntityReference() {
        return entityReference;
    }

    @JsonProperty("entityReference")
    public void setEntityReference(EntityReference entityReference) {
        this.entityReference = entityReference;
    }

    @JsonProperty("containerActivities")
    public Object getContainerActivities() {
        return containerActivities;
    }

    @JsonProperty("containerActivities")
    public void setContainerActivities(Object containerActivities) {
        this.containerActivities = containerActivities;
    }

    @JsonProperty("itemActivities")
    public List<ItemActivity> getItemActivities() {
        return itemActivities;
    }

    @JsonProperty("itemActivities")
    public void setItemActivities(List<ItemActivity> itemActivities) {
        this.itemActivities = itemActivities;
    }

    @JsonProperty("expectedCount")
    public Integer getExpectedCount() {
        return expectedCount;
    }

    @JsonProperty("expectedCount")
    public void setExpectedCount(Integer expectedCount) {
        this.expectedCount = expectedCount;
    }

    @JsonProperty("itemQty")
    public Double getItemQty() {
        return itemQty;
    }

    @JsonProperty("itemQty")
    public void setItemQty(Double itemQty) {
        this.itemQty = itemQty;
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

    @JsonProperty("bagCount")
    public Object getBagCount() {
        return bagCount;
    }

    @JsonProperty("bagCount")
    public void setBagCount(Object bagCount) {
        this.bagCount = bagCount;
    }

    @JsonProperty("customerOrderNumber")
    public String getCustomerOrderNumber() {
        return customerOrderNumber;
    }

    @JsonProperty("customerOrderNumber")
    public void setCustomerOrderNumber(String customerOrderNumber) {
        this.customerOrderNumber = customerOrderNumber;
    }

    @JsonProperty("nextActivityId")
    public Object getNextActivityId() {
        return nextActivityId;
    }

    @JsonProperty("nextActivityId")
    public void setNextActivityId(Object nextActivityId) {
        this.nextActivityId = nextActivityId;
    }

    @JsonProperty("prevActivityId")
    public Object getPrevActivityId() {
        return prevActivityId;
    }

    @JsonProperty("prevActivityId")
    public void setPrevActivityId(Object prevActivityId) {
        this.prevActivityId = prevActivityId;
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
