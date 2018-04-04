
package com.sensedia.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Plan {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("defaultPlan")
    @Expose
    private Boolean defaultPlan;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Plan() {
    }

    /**
     * 
     * @param id
     * @param defaultPlan
     * @param name
     */
    public Plan(Long id, String name, Boolean defaultPlan) {
        super();
        this.id = id;
        this.name = name;
        this.defaultPlan = defaultPlan;
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

    public Boolean getDefaultPlan() {
        return defaultPlan;
    }

    public void setDefaultPlan(Boolean defaultPlan) {
        this.defaultPlan = defaultPlan;
    }

}
