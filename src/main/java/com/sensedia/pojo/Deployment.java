
package com.sensedia.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Deployment {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("revisionId")
    @Expose
    private Long revisionId;
    @SerializedName("revisionNumber")
    @Expose
    private Long revisionNumber;
    @SerializedName("apiId")
    @Expose
    private Long apiId;
    @SerializedName("apiName")
    @Expose
    private String apiName;
    @SerializedName("apiDescription")
    @Expose
    private String apiDescription;
    @SerializedName("environmentId")
    @Expose
    private Long environmentId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("deployDate")
    @Expose
    private Long deployDate;
    @SerializedName("deploymentSchedule")
    @Expose
    private Object deploymentSchedule;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Deployment() {
    }

    /**
     * 
     * @param apiId
     * @param id
     * @param revisionNumber
     * @param apiName
     * @param status
     * @param deploymentSchedule
     * @param deployDate
     * @param apiDescription
     * @param revisionId
     * @param environmentId
     */
    public Deployment(Long id, Long revisionId, Long revisionNumber, Long apiId, String apiName, String apiDescription, Long environmentId, String status, Long deployDate, Object deploymentSchedule) {
        super();
        this.id = id;
        this.revisionId = revisionId;
        this.revisionNumber = revisionNumber;
        this.apiId = apiId;
        this.apiName = apiName;
        this.apiDescription = apiDescription;
        this.environmentId = environmentId;
        this.status = status;
        this.deployDate = deployDate;
        this.deploymentSchedule = deploymentSchedule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRevisionId() {
        return revisionId;
    }

    public void setRevisionId(Long revisionId) {
        this.revisionId = revisionId;
    }

    public Long getRevisionNumber() {
        return revisionNumber;
    }

    public void setRevisionNumber(Long revisionNumber) {
        this.revisionNumber = revisionNumber;
    }

    public Long getApiId() {
        return apiId;
    }

    public void setApiId(Long apiId) {
        this.apiId = apiId;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getApiDescription() {
        return apiDescription;
    }

    public void setApiDescription(String apiDescription) {
        this.apiDescription = apiDescription;
    }

    public Long getEnvironmentId() {
        return environmentId;
    }

    public void setEnvironmentId(Long environmentId) {
        this.environmentId = environmentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getDeployDate() {
        return deployDate;
    }

    public void setDeployDate(Long deployDate) {
        this.deployDate = deployDate;
    }

    public Object getDeploymentSchedule() {
        return deploymentSchedule;
    }

    public void setDeploymentSchedule(Object deploymentSchedule) {
        this.deploymentSchedule = deploymentSchedule;
    }

}
