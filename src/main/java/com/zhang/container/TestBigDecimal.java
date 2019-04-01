package com.zhang.container;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.math.BigDecimal;

/**
 * 这是是为了测试BigDecimal的失去精度的特性，
 * 1 使用String的解决方法
 * 2 自己改装Double转成BigDecimal的方法
 * @author zhangdl
 * @version class v1.0
 * @date 2017/9/27 8:00
 */
public
class TestBigDecimal {

    /**
     * 测试BigDecimal损失精度的案例
     */
    public void test1(){
        BigDecimal errora = new BigDecimal(99999.99);
        System.out.println(errora);
        BigDecimal errorb = BigDecimal.valueOf(99999.99);
        BigDecimal errorc = errorb;
        System.out.println(errorc);
    }

    public void test2(){
        Double d = 9999.99999;
        BigDecimal a = new BigDecimal(d.toString());
        System.out.println(a);
    }

    public  BigDecimal doubleToBigDecimal(double d){
        String doubleStr = String.valueOf(d);
        if(doubleStr.indexOf(".") != -1){
            int pointLen = doubleStr.replaceAll("\\d+\\.", "").length();    // 取得小数点后的数字的位数
            pointLen = pointLen > 16 ? 16 : pointLen;    // double最大有效小数点后的位数为16
            double pow = Math.pow(10, pointLen);
            long tmp = (long)(d * pow);
            return new BigDecimal(tmp).divide(new BigDecimal(pow));
        }
        return new BigDecimal(d);
    }

    /**
     * 使用自定义方法，解决double损失精度问题
     */
    public void test3(){
        double d = 301353.05;//5898895455898954895989;
        System.out.println(doubleToBigDecimal(d));
        System.out.println(d);
        System.out.println(new Double(d).toString());
        System.out.println(new BigDecimal(new Double(d).toString()));
        System.out.println(new BigDecimal(d));
    }

}
