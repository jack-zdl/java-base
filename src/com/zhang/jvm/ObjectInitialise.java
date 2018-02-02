package com.zhang.jvm;

/**
 * 功能说明: 对象初始化<br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间: 2018/2/2 16:21<br>
 */

/**
 * 外部类-作为父类
 */
class Initialise {
    public static  String  parentAttri = "parent";

    static {
        parentAttri = "parent static";
        System.out.println("1   Initialise--static--parent="+parentAttri);
    }

    {
        parentAttri = "parent not static";
        System.out.println("2  Initialise----parent="+parentAttri);
    }

    Initialise(){
        parentAttri = "parent 构造函数";
        System.out.println("5  Initialise----parent="+parentAttri);
    }
}
/**
 * 外部类
 */
class  Outside{
    public static  String  parentAttri = "outside";

    static {
        parentAttri = "outside static";
        System.out.println("7   "+parentAttri);
    }

    {
        parentAttri = "outside not static";
        System.out.println("8  "+parentAttri);
    }

    Outside(){
        parentAttri = "outside 构造函数";
        System.out.println("9  "+parentAttri);
    }
}

/**
 * 作为子类
 */
public class ObjectInitialise extends Initialise{ //extends Initialise
    public static  String  parentAttri = "subclass ";
    public  Outside out = new Outside();

    static {
        parentAttri = "subclass static";
        System.out.println("3  ObjectInitialise-static---subclass="+parentAttri);
    }

    {
        parentAttri = "subclass not static";
        System.out.println("4  Initialise----subclass="+parentAttri);
    }

    ObjectInitialise(){
        parentAttri = "subclass 构造函数";
        System.out.println("6  Initialise----parent="+parentAttri);
    }

    public static void main(String[] args) {
        ObjectInitialise objectInitialise = new ObjectInitialise();
    }
}
