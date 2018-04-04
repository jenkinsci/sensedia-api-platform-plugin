
package com.sensedia.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Api {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("creationDate")
    @Expose
    private Long creationDate;
    @SerializedName("plans")
    @Expose
    private List<Plan> plans = null;
    @SerializedName("basePath")
    @Expose
    private String basePath;
    @SerializedName("privateAPI")
    @Expose
    private Boolean privateAPI;
    @SerializedName("environments")
    @Expose
    private List<Environment> environments = null;
    @SerializedName("lastRevision")
    @Expose
    private LastRevision lastRevision;
    @SerializedName("appsCount")
    @Expose
    private Long appsCount;
    @SerializedName("lastVersion")
    @Expose
    private Boolean lastVersion;
    @SerializedName("apiType")
    @Expose
    private String apiType;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Api() {
    }

    /**
     * 
     * @param plans
     * @param appsCount
     * @param environments
     * @param version
     * @param apiType
     * @param id
     * @param basePath
     * @param creationDate
     * @param lastRevision
     * @param description
     * @param lastVersion
     * @param name
     * @param privateAPI
     */
    public Api(Long id, String name, String description, String version, Long creationDate, List<Plan> plans, String basePath, Boolean privateAPI, List<Environment> environments, LastRevision lastRevision, Long appsCount, Boolean lastVersion, String apiType) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.version = version;
        this.creationDate = creationDate;
        this.plans = plans;
        this.basePath = basePath;
        this.privateAPI = privateAPI;
        this.environments = environments;
        this.lastRevision = lastRevision;
        this.appsCount = appsCount;
        this.lastVersion = lastVersion;
        this.apiType = apiType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Long creationDate) {
        this.creationDate = creationDate;
    }

    public List<Plan> getPlans() {
        return plans;
    }

    public void setPlans(List<Plan> plans) {
        this.plans = plans;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public Boolean getPrivateAPI() {
        return privateAPI;
    }

    public void setPrivateAPI(Boolean privateAPI) {
        this.privateAPI = privateAPI;
    }

    public List<Environment> getEnvironments() {
        return environments;
    }

    public void setEnvironments(List<Environment> environments) {
        this.environments = environments;
    }

    public LastRevision getLastRevision() {
        return lastRevision;
    }

    public void setLastRevision(LastRevision lastRevision) {
        this.lastRevision = lastRevision;
    }

    public Long getAppsCount() {
        return appsCount;
    }

    public void setAppsCount(Long appsCount) {
        this.appsCount = appsCount;
    }

    public Boolean getLastVersion() {
        return lastVersion;
    }

    public void setLastVersion(Boolean lastVersion) {
        this.lastVersion = lastVersion;
    }

    public String getApiType() {
        return apiType;
    }

    public void setApiType(String apiType) {
        this.apiType = apiType;
    }

}
