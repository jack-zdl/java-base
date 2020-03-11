package com.zhang.util;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;

import java.io.File;

/**
 * <p></p>
 *
 * @Author: dl.zhang
 * @Date: 2020/3/11
 */
public class JSONPathTest {

    public void validateJsonPath(){
        String path =System.getProperty("user.dir")+File.separator+"testdata"+ File.separator+"test.json";
        String jsonString = FileUtils.readFileToString(new File(path),"utf-8");
        ReadContext context = JsonPath.parse(json);
    }
}
