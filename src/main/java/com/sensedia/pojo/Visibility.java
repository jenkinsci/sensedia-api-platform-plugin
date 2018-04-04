
package com.sensedia.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Visibility {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("visibilityType")
    @Expose
    private String visibilityType;
    @SerializedName("users")
    @Expose
    private List<Object> users = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Visibility() {
    }

    /**
     * 
     * @param id
     * @param users
     * @param visibilityType
     */
    public Visibility(Long id, String visibilityType, List<Object> users) {
        super();
        this.id = id;
        this.visibilityType = visibilityType;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVisibilityType() {
        return visibilityType;
    }

    public void setVisibilityType(String visibilityType) {
        this.visibilityType = visibilityType;
    }

    public List<Object> getUsers() {
        return users;
    }

    public void setUsers(List<Object> users) {
        this.users = users;
    }

}
