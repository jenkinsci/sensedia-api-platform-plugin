
package com.sensedia.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RevisionDeployed {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("apiId")
    @Expose
    private Long apiId;
    @SerializedName("apiName")
    @Expose
    private String apiName;
    @SerializedName("revisionId")
    @Expose
    private Long revisionId;
    @SerializedName("revisionNumber")
    @Expose
    private Long revisionNumber;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RevisionDeployed() {
    }

    /**
     * 
     * @param apiId
     * @param id
     * @param revisionNumber
     * @param apiName
     * @param revisionId
     */
    public RevisionDeployed(Long id, Long apiId, String apiName, Long revisionId, Long revisionNumber) {
        super();
        this.id = id;
        this.apiId = apiId;
        this.apiName = apiName;
        this.revisionId = revisionId;
        this.revisionNumber = revisionNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
