
package com.sensedia.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LastRevision {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("apiBroken")
    @Expose
    private Boolean apiBroken;
    @SerializedName("revisionNumber")
    @Expose
    private Long revisionNumber;
    @SerializedName("lifeCycle")
    @Expose
    private String lifeCycle;
    @SerializedName("creationDate")
    @Expose
    private Long creationDate;
    @SerializedName("deployments")
    @Expose
    private List<Deployment> deployments = null;
    @SerializedName("resources")
    @Expose
    private List<Resource> resources = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LastRevision() {
    }

    /**
     * 
     * @param id
     * @param resources
     * @param creationDate
     * @param revisionNumber
     * @param lifeCycle
     * @param apiBroken
     * @param deployments
     */
    public LastRevision(Long id, Boolean apiBroken, Long revisionNumber, String lifeCycle, Long creationDate, List<Deployment> deployments, List<Resource> resources) {
        super();
        this.id = id;
        this.apiBroken = apiBroken;
        this.revisionNumber = revisionNumber;
        this.lifeCycle = lifeCycle;
        this.creationDate = creationDate;
        this.deployments = deployments;
        this.resources = resources;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getApiBroken() {
        return apiBroken;
    }

    public void setApiBroken(Boolean apiBroken) {
        this.apiBroken = apiBroken;
    }

    public Long getRevisionNumber() {
        return revisionNumber;
    }

    public void setRevisionNumber(Long revisionNumber) {
        this.revisionNumber = revisionNumber;
    }

    public String getLifeCycle() {
        return lifeCycle;
    }

    public void setLifeCycle(String lifeCycle) {
        this.lifeCycle = lifeCycle;
    }

    public Long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Long creationDate) {
        this.creationDate = creationDate;
    }

    public List<Deployment> getDeployments() {
        return deployments;
    }

    public void setDeployments(List<Deployment> deployments) {
        this.deployments = deployments;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

}
