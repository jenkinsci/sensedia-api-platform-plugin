
package com.sensedia.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Operation {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("destination")
    @Expose
    private String destination;
    @SerializedName("interceptors")
    @Expose
    private List<Interceptor> interceptors = null;
    @SerializedName("apiBroken")
    @Expose
    private Boolean apiBroken;
    @SerializedName("timeout")
    @Expose
    private Object timeout;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("async")
    @Expose
    private Boolean async;
    @SerializedName("urls")
    @Expose
    private List<Object> urls = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Operation() {
    }

    /**
     * 
     * @param id
     * @param interceptors
     * @param urls
     * @param description
     * @param path
     * @param method
     * @param async
     * @param timeout
     * @param apiBroken
     * @param destination
     */
    public Operation(Long id, String destination, List<Interceptor> interceptors, Boolean apiBroken, Object timeout, String description, String method, String path, Boolean async, List<Object> urls) {
        super();
        this.id = id;
        this.destination = destination;
        this.interceptors = interceptors;
        this.apiBroken = apiBroken;
        this.timeout = timeout;
        this.description = description;
        this.method = method;
        this.path = path;
        this.async = async;
        this.urls = urls;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<Interceptor> getInterceptors() {
        return interceptors;
    }

    public void setInterceptors(List<Interceptor> interceptors) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Boolean getAsync() {
        return async;
    }

    public void setAsync(Boolean async) {
        this.async = async;
    }

    public List<Object> getUrls() {
        return urls;
    }

    public void setUrls(List<Object> urls) {
        this.urls = urls;
    }

}
