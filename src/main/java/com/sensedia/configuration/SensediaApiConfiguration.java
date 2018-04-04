package com.sensedia.configuration;

import hudson.Extension;
import hudson.util.FormValidation;
import jenkins.model.GlobalConfiguration;
import org.apache.commons.lang.StringUtils;
import org.kohsuke.stapler.DataBoundSetter;
import org.kohsuke.stapler.QueryParameter;

/**
 * Example of Jenkins global configuration.
 */
@Extension
public class SensediaApiConfiguration extends GlobalConfiguration {

    /** @return the singleton instance */
    public static SensediaApiConfiguration get() {
        return GlobalConfiguration.all().get(SensediaApiConfiguration.class);
    }

    private String urlManager;
    private String tokenManager;

    public SensediaApiConfiguration() {
        // When Jenkins is restarted, load any saved configuration from disk.
        load();
    }

    /** @return the currently configured urlManager, if any */
    public String getUrlManager() {
        return urlManager;
    }

    public String getTokenManager() {
        return tokenManager;
    }

    /**
     * Together with {@link #getUrlManager}, binds to entry in {@code config.jelly}.
     * @param urlManager the new value of this field
     */
    @DataBoundSetter
    public void setUrlManager(String urlManager) {
        this.urlManager = urlManager;
        save();
    }

    @DataBoundSetter
    public void setTokenManager(String tokenManager) {
        this.tokenManager = tokenManager;
        save();
    }

    public FormValidation doCheckLabel(@QueryParameter String value, @QueryParameter String value2) {
        if (StringUtils.isEmpty(value) || StringUtils.isEmpty(value2)) {
            return FormValidation.warning("Please specify both parameters.");
        }
        return FormValidation.ok();
    }

}
