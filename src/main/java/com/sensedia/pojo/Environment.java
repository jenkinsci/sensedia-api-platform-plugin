
package com.sensedia.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Environment {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("inboundUrl")
    @Expose
    private String inboundUrl;
    @SerializedName("revisionDeployed")
    @Expose
    private RevisionDeployed revisionDeployed;
    @SerializedName("visibility")
    @Expose
    private Visibility visibility;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Environment() {
    }

    /**
     * 
     * @param revisionDeployed
     * @param id
     * @param inboundUrl
     * @param visibility
     * @param name
     */
    public Environment(Long id, String name, String inboundUrl, RevisionDeployed revisionDeployed, Visibility visibility) {
        super();
        this.id = id;
        this.name = name;
        this.inboundUrl = inboundUrl;
        this.revisionDeployed = revisionDeployed;
        this.visibility = visibility;
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

    public String getInboundUrl() {
        return inboundUrl;
    }

    public void setInboundUrl(String inboundUrl) {
        this.inboundUrl = inboundUrl;
    }

    public RevisionDeployed getRevisionDeployed() {
        return revisionDeployed;
    }

    public void setRevisionDeployed(RevisionDeployed revisionDeployed) {
        this.revisionDeployed = revisionDeployed;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

}
