
package com.sensedia.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Resource {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("destination")
    @Expose
    private Object destination;
    @SerializedName("interceptors")
    @Expose
    private List<Object> interceptors = null;
    @SerializedName("apiBroken")
    @Expose
    private Boolean apiBroken;
    @SerializedName("timeout")
    @Expose
    private Object timeout;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("operations")
    @Expose
    private List<Operation> operations = null;
    @SerializedName("config")
    @Expose
    private Config config;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Resource() {
    }

    /**
     * 
     * @param id
     * @param interceptors
     * @param description
     * @param name
     * @param config
     * @param operations
     * @param timeout
     * @param apiBroken
     * @param destination
     */
    public Resource(Long id, Object destination, List<Object> interceptors, Boolean apiBroken, Object timeout, String name, String description, List<Operation> operations, Config config) {
        super();
        this.id = id;
        this.destination = destination;
        this.interceptors = interceptors;
        this.apiBroken = apiBroken;
        this.timeout = timeout;
        this.name = name;
        this.description = description;
        this.operations = operations;
        this.config = config;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Object getDestination() {
        return destination;
    }

    public void setDestination(Object destination) {
        this.destination = destination;
    }

    public List<Object> getInterceptors() {
        return interceptors;
    }

    public void setInterceptors(List<Object> interceptors) {
        this.interceptors = interceptors;
    }

    public Boolean getApiBroken() {
        return apiBroken;
    }

    public void setApiBroken(Boolean apiBroken) {
        this.apiBroken = apiBroken;
    }

    public Object getTimeout() {
        return timeout;
    }

    public void setTimeout(Object timeout) {
        this.timeout = timeout;
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

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

}
