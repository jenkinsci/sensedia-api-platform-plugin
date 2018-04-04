
package com.sensedia.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Interceptor {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("idTemp")
    @Expose
    private Object idTemp;
    @SerializedName("position")
    @Expose
    private Long position;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("executionPoint")
    @Expose
    private String executionPoint;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("parent")
    @Expose
    private Object parent;
    @SerializedName("resource")
    @Expose
    private Object resource;
    @SerializedName("operation")
    @Expose
    private Object operation;
    @SerializedName("planId")
    @Expose
    private Object planId;
    @SerializedName("customInterceptorId")
    @Expose
    private Object customInterceptorId;
    @SerializedName("parentType")
    @Expose
    private String parentType;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Interceptor() {
    }

    /**
     * 
     * @param position
     * @param status
     * @param resource
     * @param parent
     * @param planId
     * @param type
     * @param parentType
     * @param customInterceptorId
     * @param id
     * @param content
     * @param operation
     * @param executionPoint
     * @param idTemp
     */
    public Interceptor(Long id, Object idTemp, Long position, String type, String content, String executionPoint, String status, Object parent, Object resource, Object operation, Object planId, Object customInterceptorId, String parentType) {
        super();
        this.id = id;
        this.idTemp = idTemp;
        this.position = position;
        this.type = type;
        this.content = content;
        this.executionPoint = executionPoint;
        this.status = status;
        this.parent = parent;
        this.resource = resource;
        this.operation = operation;
        this.planId = planId;
        this.customInterceptorId = customInterceptorId;
        this.parentType = parentType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Object getIdTemp() {
        return idTemp;
    }

    public void setIdTemp(Object idTemp) {
        this.idTemp = idTemp;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExecutionPoint() {
        return executionPoint;
    }

    public void setExecutionPoint(String executionPoint) {
        this.executionPoint = executionPoint;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getParent() {
        return parent;
    }

    public void setParent(Object parent) {
        this.parent = parent;
    }

    public Object getResource() {
        return resource;
    }

    public void setResource(Object resource) {
        this.resource = resource;
    }

    public Object getOperation() {
        return operation;
    }

    public void setOperation(Object operation) {
        this.operation = operation;
    }

    public Object getPlanId() {
        return planId;
    }

    public void setPlanId(Object planId) {
        this.planId = planId;
    }

    public Object getCustomInterceptorId() {
        return customInterceptorId;
    }

    public void setCustomInterceptorId(Object customInterceptorId) {
        this.customInterceptorId = customInterceptorId;
    }

    public String getParentType() {
        return parentType;
    }

    public void setParentType(String parentType) {
        this.parentType = parentType;
    }

}
