# jvm
## 对象加载顺序
```
    父类静态变量- 父类静态代码块-子类静态代码块-父类非静态变量-父类非静态代码块-父类构造函数-子类非静态代码块-子类构造函数。
           自己测试 -- 父类静态代码块-静态属性对象的静态代码块--静态属性对象的静态代码块--静态属性对象的构造函数--子类（自己类）的静态方法--父类非静态代码--父类的构造函数--属性对象的静态代码块--属性对象的非静态代码--属性对象的构造函数--子类的非静态代码块--子类的构造函数
    1   Initialise--static--parent=parent static
    7   StaticOutside static
    8  StaticOutside not static
    9  StaticOutside 构造函数
    3  ObjectInitialise-static---subclass=subclass static
    2  Initialise----parent=parent not static
    5  Initialise----parent=parent 构造函数
    10   outside static
    11  outside not static
    12  outside 构造函数
    4  Initialise----subclass=subclass not static
    6  Initialise----parent=subclass 构造函数

```


