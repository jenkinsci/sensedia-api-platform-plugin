package com.sensedia;

import com.sensedia.common.SensediaApiCommon;
import com.sensedia.configuration.SensediaApiConfiguration;
import com.sensedia.pojo.Api;
import hudson.Extension;
import hudson.FilePath;
import hudson.Launcher;
import hudson.model.AbstractProject;
import hudson.model.Run;
import hudson.model.TaskListener;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Builder;
import hudson.util.FormValidation;
import jenkins.tasks.SimpleBuildStep;
import org.jenkinsci.Symbol;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.QueryParameter;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SensediaApiDeploy extends Builder implements SimpleBuildStep {

    private final String enviromentName;
    private String revision;

    @DataBoundConstructor
    public SensediaApiDeploy(String enviromentName, String revision) {
        this.enviromentName = enviromentName;
        this.revision = revision;
    }

    public String getEnviromentName() {
        return enviromentName;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    @Override
    public void perform(Run<?, ?> run, FilePath workspace, Launcher launcher, TaskListener listener) throws InterruptedException {
        try {
            if((getEnviromentName()==null || getEnviromentName().isEmpty()))
                throw new InterruptedException("Invalid field 'enviromentName'");

            Api apiJson = SensediaApiCommon.parseApiObjectFromFile(workspace);

            if(getRevision()==null || getRevision().isEmpty())
                setRevision(String.valueOf(apiJson.getLastRevision().getId()));

            deployApi(SensediaApiCommon.getEnviromentId(apiJson.getEnvironments(), getEnviromentName()));

            listener.getLogger().println("Api revisionId "+getRevision()+" deployed!");

        } catch (Exception e) {
            e.printStackTrace();
            throw new InterruptedException(e.getMessage());
        }


    }

    private void deployApi(Long enviromentId) throws IOException, InterruptedException{
        URL url = new URL(SensediaApiConfiguration.get().getUrlManager()+"/deployments/");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Sensedia-Auth", SensediaApiConfiguration.get().getTokenManager());

        String input = "{\"environmentId\": "+enviromentId+", \"revisionId\": "+getRevision()+", \"status\": \"DEPLOYED\"}";

        OutputStream os = conn.getOutputStream();
        os.write(input.getBytes("UTF-8"));
        os.flush();

        if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
            throw new InterruptedException("Failed : HTTP error code : "
                    + conn.getResponseCode()+ "\n Error: "+conn.getResponseMessage());
        }
        conn.disconnect();
    }

    @Symbol("sensediaApiDeploy")
    @Extension
    public static final class DescriptorImpl extends BuildStepDescriptor<Builder> {

        public FormValidation doCheckName(@QueryParameter String value, @QueryParameter String value1, @QueryParameter String value2)
                throws IOException, ServletException {
            if (value.length() == 0 || value1.length() == 0 || value2.length() == 0)
                return FormValidation.error("Missing parameters");
            return FormValidation.ok();
        }

        @Override
        public String getDisplayName() {
            return Messages.sensedia_plugin_apisuite() + "deploy";
        }

        @Override
        public boolean isApplicable(Class<? extends AbstractProject> aClass) {
            return true;
        }

    }

}
