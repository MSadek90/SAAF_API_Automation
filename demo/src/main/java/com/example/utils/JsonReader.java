package com.example.utils;

import com.example.Pojo.RegisterRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;



public class JsonReader {
 

    private static final String filePath = "src/test/resources/TestData/user.json";


    public static RegisterRequest[] readUsers() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filePath), RegisterRequest[].class);
    }
}

