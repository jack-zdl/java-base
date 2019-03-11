package com.zhang.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.util.TypeUtils;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * <p>1 fastJson的大小写</p>
 * @Author: dl.zhang
 * @CreateDate: 2019/3/5 14:07
 **/
public class FastJsonTest{

    private final Type zoneGroupListRef = new TypeReference<Map<String, List<String>>>() {
    }.getType();


    @Test
    public void fastJson(){
//        TypeUtils.compatibleWithJavaBean =true;
//        JSONObject jsonObject = new JSONObject();
////        com.alibaba.fastjson.util.TypeUtils.compatibleWithJavaBean = true;
////        FastJsonConfig fastJsonConfig = new FastJsonConfig();
////        fastJsonConfig.setSerializerFeatures(
////                SerializerFeature.DisableCircularReferenceDetect,
////                SerializerFeature.WriteMapNullValue,
////                SerializerFeature.WriteNullStringAsEmpty
////        );
//        String jsonStr = "{\"code\":0,\"message\":\"\",\"result\":{\"facts\":{\"ip\":{\"aCUN_ONE_MIN\":0,\"aCUN_TEN_MIN\":0}},\"level\":0}}";
//        jsonObject  = JSONObject.parseObject(jsonStr);
//        System.out.println(jsonObject.get("result"));
//        TestClass testClass = new TestClass();
//        Object object = JSON.toJSON(testClass);
//        System.out.println(object);
//        Object BigDecimalObject = JSON.parse("\"I81833e8936\"");
//        //BigDecimalObject = JSON.toJSON("81833e8936");
//        System.out.println("=="+BigDecimalObject.getClass().equals(BigDecimal.class));
//        System.out.println(""+BigDecimalObject);
        String s = "{\"idc1\":[\"default\"],\"idc2\":[\"default\"]}";

        Map<String, List<String>> zoneGroupMap = JSON.parseObject(s, zoneGroupListRef);
        System.out.println(zoneGroupMap.keySet());
    }

    public class TestClass{
        private String TEST = "1";
        public String getTEST() { return this.TEST;}
    }
}
