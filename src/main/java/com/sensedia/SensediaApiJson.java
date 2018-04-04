package com.sensedia;

import com.sensedia.configuration.SensediaApiConfiguration;
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
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class SensediaApiJson extends Builder implements SimpleBuildStep {

    private final String apiId;

    @DataBoundConstructor
    public SensediaApiJson(String apiId) {
        this.apiId = apiId;
    }

    public String getApiId() {
        return apiId;
    }

    @Override
    public void perform(Run<?, ?> run, FilePath workspace, Launcher launcher, TaskListener listener) throws InterruptedException {
        try {
            getApiJson(workspace);
        } catch (Exception e) {
            e.printStackTrace();
            throw new InterruptedException(e.getMessage());
        }
    }

    private void getApiJson(FilePath workspace)throws IOException{
        if(SensediaApiConfiguration.get().getUrlManager()==null || SensediaApiConfiguration.get().getUrlManager().isEmpty()){
            throw new RuntimeException("SensediaApiConfiguration 'URL Manager' is not set");
        }
        URL url = new URL(SensediaApiConfiguration.get().getUrlManager()+"/apis/"+getApiId());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Sensedia-Auth", SensediaApiConfiguration.get().getTokenManager());
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode()+ "\n Error: "+conn.getResponseMessage());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        String output;
        Writer out = new OutputStreamWriter(new FileOutputStream(workspace+"\\api.json"), "UTF-8");
        while ((output = br.readLine()) != null){
            out.write(output);
        }
        out.flush();
        out.close();
        br.close();
        conn.disconnect();
    }


    @Symbol("sensediaApiJson")
    @Extension
    public static final class DescriptorImpl extends BuildStepDescriptor<Builder> {

        public FormValidation doCheckName(@QueryParameter String value)
                throws IOException, ServletException {
            if (value.length() == 0)
                return FormValidation.error("Missing parameters");
            return FormValidation.ok();
        }

        @Override
        public String getDisplayName() {
            return Messages.sensedia_plugin_apisuite()+" get json";
        }

        @Override
        public boolean isApplicable(Class<? extends AbstractProject> aClass) {
            return true;
        }

    }

}
