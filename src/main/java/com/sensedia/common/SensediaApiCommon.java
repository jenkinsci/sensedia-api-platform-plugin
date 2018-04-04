package com.sensedia.common;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.sensedia.pojo.Api;
import com.sensedia.pojo.Environment;
import hudson.FilePath;

import java.io.*;
import java.util.List;

public class SensediaApiCommon {

    public static Api parseApiObjectFromFile(FilePath workspace) throws UnsupportedEncodingException, FileNotFoundException {
        InputStream inputStream = new FileInputStream(workspace+"\\api.json");
        JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
        return new Gson().fromJson(reader, new TypeToken<Api>() {}.getType());
    }

    public static Long getEnviromentId(List<Environment> environments, String enviromentName) {
        for(Environment environment : environments){
            if(environment.getName().toUpperCase().equals(enviromentName.toUpperCase())){
                return environment.getId();
            }
        }
        return 0L;
    }
}
