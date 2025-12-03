package com.example.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class EnvironmentReader {
    
 private static final String filePath = "src/test/resources/test/Environment.txt";



 public static String getBaseUrl(String environment_key){

    Properties properties = new Properties();
    try{
        FileInputStream fileInputStream = new FileInputStream(filePath);
        properties.load(fileInputStream);
        String url = properties.getProperty(environment_key);

        if (url == null || url.isEmpty()) {
            throw new RuntimeException("Url not foun for this environment" + environment_key);
        }

        return url.trim();
    }
    catch(IOException e){
        throw new RuntimeException("Failed to load file:  " + filePath + "message is:  " + e.getMessage());
    }

 }


}
