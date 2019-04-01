package com.zhang.jvm;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/**
 * 功能说明: 类加载器<br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间: 2018/2/2 17:37<br>
 */

public
class BootstrapClassLoaderInitialise {

    @Test
//    public void Test(){
//        CityDto cityDto = new CityDto();
//        cityDto.setCityName("T3\u001cA\u001d");
//        try {
//            System.out.println(SerializeUtils.toJson(cityDto));
//            System.out.println(SerializeUtils.toXml(cityDto));
//        } catch (Exception e) {
//            System.out.println("error");
//        }
//    }

    public static String getEncoding(String str)
    {
        String encode;

        encode = "UTF-16";
        try
        {
            if(str.equals(new String(str.getBytes(), encode)))
            {
                return encode;
            }
        }
        catch(Exception ex) {}

        encode = "ASCII";
        try
        {
            if(str.equals(new String(str.getBytes(), encode)))
            {
                return "字符串<< " + str + " >>中仅由数字和英文字母组成，无法识别其编码格式";
            }
        }
        catch(Exception ex) {}

        encode = "ISO-8859-1";
        try
        {
            if(str.equals(new String(str.getBytes(), encode)))
            {
                return encode;
            }
        }
        catch(Exception ex) {}

        encode = "GB2312";
        try
        {
            if(str.equals(new String(str.getBytes(), encode)))
            {
                return encode;
            }
        }
        catch(Exception ex) {}

        encode = "UTF-8";
        try
        {
            if(str.equals(new String(str.getBytes(), encode)))
            {
                return encode;
            }
        }
        catch(Exception ex) {}

        /*
         *......待完善
         */
        return "未识别编码格式";
    }

//    public static void main(String[] args)
//    {
//        //获取系统默认编码
//        System.out.println("系统默认编码：" + System.getProperty("file.encoding")); //查询结果GBK
//        //系统默认字符编码
//        System.out.println("系统默认字符编码：" + Charset.defaultCharset()); //查询结果GBK
//        //操作系统用户使用的语言
//        System.out.println("系统默认语言：" + System.getProperty("user.language")); //查询结果zh
//
//        System.out.println();
//
//        String s1 = "hi, nice to meet you!";
//        String s2 = "hi, 我来了！";
//
//        System.out.println(getEncoding(s1));
//        System.out.println(getEncoding(s2));
//    }

    public static void main(String[] args) {
        System.out.println("Default Charset=" + Charset.defaultCharset());
        System.out.println("file.encoding=" + System.getProperty("file.encoding"));
        System.out.println("Default Charset=" + Charset.defaultCharset());
        System.out.println("Default Charset in Use=" + getDefaultCharSet());
    }

    private static String getDefaultCharSet() {
        OutputStreamWriter writer = new OutputStreamWriter(new ByteArrayOutputStream());
        String enc = writer.getEncoding();
        return enc;
    }
}
