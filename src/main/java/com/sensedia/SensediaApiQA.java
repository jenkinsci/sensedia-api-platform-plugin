package com.sensedia;

import com.sensedia.common.SensediaApiCommon;
import com.sensedia.pojo.Api;
import com.sensedia.pojo.Interceptor;
import com.sensedia.pojo.Operation;
import com.sensedia.pojo.Resource;
import com.sensedia.common.constants.SensediaPluginConstants;
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
import java.util.List;

public class SensediaApiQA extends Builder implements SimpleBuildStep {

    private final int revisionNumber;
    private final boolean destination;
    private final boolean logInterceptor;
    private final boolean resourceOutOfSize;
    private int resourceSize;

    @DataBoundConstructor
    public SensediaApiQA(int revisionNumber, boolean destination, boolean logInterceptor, boolean resourceOutOfSize, int resourceSize) {
        this.revisionNumber = revisionNumber;
        this.destination = destination;
        this.logInterceptor = logInterceptor;
        this.resourceOutOfSize = resourceOutOfSize;
        this.resourceSize = resourceSize;
    }

    public int getRevisionNumber() {
        return revisionNumber;
    }

    public boolean isDestination() {
        return destination;
    }

    public boolean isLogInterceptor() {
        return logInterceptor;
    }

    public boolean isResourceOutOfSize() {
        return resourceOutOfSize;
    }

    public int getResourceSize() {
        return resourceSize;
    }

    public void setResourceSize(int resourceSize) {
        this.resourceSize = resourceSize;
    }

    @Override
    public void perform(Run<?, ?> run, FilePath workspace, Launcher launcher, TaskListener listener) throws InterruptedException, IOException {

        Api apiJson = SensediaApiCommon.parseApiObjectFromFile(workspace);

        StringBuffer response = new StringBuffer();
        response.append(isDestinationFixed(apiJson.getLastRevision().getResources()));
        response.append(isResourcePathOutOfSize(apiJson));
        response.append(isLogInterceptorUseExceed(apiJson.getLastRevision().getResources()));

        if(response.toString().contains(SensediaPluginConstants.FAILED_STATUS)){
            listener.getLogger().println(response.toString());
            throw new InterruptedException(response.toString());
        }
        else{
            listener.getLogger().println(response.toString());
        }
    }

    private String isDestinationFixed(List<Resource> resources) throws InterruptedException{
        if(isDestination()) {
            for(Resource resource : resources){
                if(resource.getOperations()!=null && !resource.getOperations().isEmpty()){
                    for (Operation operation : resource.getOperations()){
                        if(operation.getDestination()!=null && !operation.getDestination().isEmpty()) {
                            if (operation.getDestination().matches("^(http|https)://.*$")) {
                                return Messages.sensedia_plugin_qa_destination()+SensediaPluginConstants.FAILED_STATUS+" \n";
                            }
                        }
                    }
                }
            }
        }else{
            return Messages.sensedia_plugin_qa_destination()+SensediaPluginConstants.SKIP_STATUS+" \n";
        }
        return Messages.sensedia_plugin_qa_destination()+SensediaPluginConstants.SUCCESS_STATUS+" \n";
    }

    private String isResourcePathOutOfSize(Api apiJson) throws InterruptedException{
        if(isResourceOutOfSize()) {
            int size = 5;
            if(getResourceSize()!=0)size = getResourceSize();
            Long tempBaseSize = countPathSize(apiJson.getBasePath().split("/"));
            for(Resource resource : apiJson.getLastRevision().getResources()) {
                if (resource.getOperations() != null && !resource.getOperations().isEmpty()) {
                    for (Operation operation : resource.getOperations()) {
                        Long tempSize = tempBaseSize;
                        String[] paths = operation.getPath().split("/");
                        tempSize += countPathSize(paths);
                        if(tempSize>size)
                            return Messages.sensedia_plugin_qa_paths()+SensediaPluginConstants.FAILED_STATUS+" \n";
                    }

                }
            }
        }else{
            return Messages.sensedia_plugin_qa_paths()+SensediaPluginConstants.SKIP_STATUS+" \n";
        }
        return Messages.sensedia_plugin_qa_paths()+SensediaPluginConstants.SUCCESS_STATUS+" \n";
    }

    private Long countPathSize(String[] paths){
        Long count = 0L;
        for(String path : paths){
            if(!path.isEmpty())count += 1;
        }
        return count;
    }

    private String isLogInterceptorUseExceed(List<Resource> resources) throws InterruptedException{
        if(isLogInterceptor()) {
            for(Resource resource : resources){
                if(resource.getOperations()!=null && !resource.getOperations().isEmpty()){
                    for (Operation operation : resource.getOperations()){
                        if(countLogInterceptor(operation) > 6) return  Messages.sensedia_plugin_qa_countlog()+SensediaPluginConstants.FAILED_STATUS+" \n";
                    }
                }
            }
        }else{
            return Messages.sensedia_plugin_qa_countlog()+SensediaPluginConstants.SKIP_STATUS+" \n";
        }
        return Messages.sensedia_plugin_qa_countlog()+SensediaPluginConstants.SUCCESS_STATUS+" \n";
    }

    private Long countLogInterceptor(Operation operation){
        Long tempCount = 0L;
        if(operation.getInterceptors()!=null && !operation.getInterceptors().isEmpty()) {
            for (Interceptor interceptor : operation.getInterceptors()) {
                if (interceptor.getType().toUpperCase().equals("LOG")) {
                    tempCount += 1;
                }
            }
        }
        return tempCount;
    }


    @Symbol("sensediaApiQA")
    @Extension
    public static final class DescriptorImpl extends BuildStepDescriptor<Builder> {

        public FormValidation doCheckName(@QueryParameter String value, @QueryParameter String value1, @QueryParameter String value2)
                throws IOException, ServletException {
            return FormValidation.ok();
        }

        @Override
        public String getDisplayName() {
            return Messages.sensedia_plugin_apisuite()+" QA";
        }

        @Override
        public boolean isApplicable(Class<? extends AbstractProject> aClass) {
            return true;
        }

    }

}
