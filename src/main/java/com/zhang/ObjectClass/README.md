## 反射机制
```
    1 探究反射机制
        测试 对象.getClass 和 Class.forName("某包下的某个类") 和 类.class
    2 Class.getDeclaredField(String name)
        返回一个 Field 对象，该对象反映此 Class 对象所表示的类或接口的指定已声明字段（包括私有成员）。
    3 Class.getDeclaredFields();
        返回 Field 对象的一个数组，该数组包含此 Class 对象所表示的类或接口所声明的所有字段（包括私有成员）。
    4 Class.getFields();
        返回一个包含某些 Field 对象的数组，该数组包含此 Class 对象所表示的类或接口的所有可访问公共字段。
```
## 数组初始化
```
    一维数组的声明方式： type var[]; 或type[] var;
    初始化
        1 动态初始化:数组定义与为数组分配空间和赋值的操作分开进行；
             int a[] ;  数组定义
             a = new int[3] ; 为数组分配空间
             a[0] = 0 ;   a[1] = 1 ;   a[2] = 2 ;  赋值的操作
        2 静态初始化：在定义数字的同时就为数组元素分配空间并赋值；
             int a[] = {0,1,2} ;  定义数组同时分配元素
        3 默认初始化：数组是引用类型，它的元素相当于类的成员变量，因此数组分配空间后，
            每个元素也被按照成员变量的规则被隐士初始化。
    1 int[] a = new int[5];新建数组，指定数组长度，默认值都为0;
    2 int[] a ={1,2,3,4,5};直接给数组赋值，这样就新建一个

```

