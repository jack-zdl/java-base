# jvm
## 对象加载顺序 see ObjectInitialise.JAVA
```
    父类静态变量- 父类静态代码块-子类静态代码块-父类非静态变量-父类非静态代码块-父类构造函数-子类非静态代码块-子类构造函数。
           自己测试 -- 父类静态代码块-静态属性对象的静态代码块--静态属性对象的非静态代码块--静态属性对象的构造函数--
           子类（自己类）的静态方法--父类非静态代码--父类的构造函数--属性对象的静态代码块--属性对象的非静态代码--
           属性对象的构造函数--子类的非静态代码块--子类的构造函数
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
##  类加载机制
```
    加载-验证-准备-解析-初始化（编译）-使用-卸载
    1 其中加载五个阶段，加载-验证-准备-解析-初始化，其中加载，验证，准备，初始化这四个阶段顺序是一定的，这四个是按顺序开始，
        但是不是按顺序完成，这些阶段通常交叉混合进行，一般在一个阶段进行时调用或激活另一个阶段。但是解析的阶段不一定。
        它在某些情况下可以在初始化阶段之后开始，这是为了支持Java语言的运行时绑定（也成为动态绑定或晚期绑定）
    	* 静态绑定：即前期绑定。在程序执行前方法已经被绑定，此时由编译器或其它连接程序实现。针对java，
    	简单的可以理解为程序编译期的绑定。java当中的方法只有final，static，private和构造方法是前期绑定的。
    	* 动态绑定：即晚期绑定，也叫运行时绑定。在运行时根据具体对象的类型进行绑定。在java中，几乎所有的方法都是后期绑定的。
    2 加载
        1 通过一个类的全限定名来获取其定义的二进制字节流
        2 将这个字节流所代表的静态存储结构转化为方法区的运行时数据结构
        3 在Java堆中生成一个代表这个类的java.lang.Class对象，作为对方法区中这些数据的访问入口
    类加载器 顾名思义，即加载类的东西。使用双亲委派机制
        1 类的加载过程采用委托模式实现
        2 每个 ClassLoader 都有一个父加载器。
        3 类加载器在加载类之前会先递归的去尝试使用父加载器加载。
        4 虚拟机有一个内建的启动类加载器（bootstrap ClassLoader），该加载器没有父加载器，但是可以作为其他加载器的父加载器
    加载器
        启动类加载器：Bootstrap ClassLoader 
            （跟上面相同。它负责加载存放在JDK\jre\lib(JDK代表JDK的安装目录，下同)下，或被-Xbootclasspath参数指定的路径中的，
            并且能被虚拟机识别的类库（如rt.jar，所有的java.*开头的类均被Bootstrap ClassLoader加载）。
            启动类加载器是无法被Java程序直接引用的。）
                    |
        扩展类加载器：Extension ClassLoader
            （该加载器由sun.misc.Launcher$ExtClassLoader实现，它负责加载JDK\jre\lib\ext目录中，
            或者由java.ext.dirs系统变量指定的路径中的所有类库（如javax.*开头的类），开发者可以直接使用扩展类加载器。）
                    |
        应用程序类加载器：Application ClassLoader
            （该类加载器由sun.misc.Launcher$AppClassLoader来实现，它负责加载用户类路径（ClassPath）所指定的类，
            开发者可以直接使用该类加载器，如果应用程序中没有自定义过自己的类加载器，一般情况下这个就是程序中默认的类加载器。）
        类似这种关系的类加载器就是双亲委派模型。（他们相互组合）
            双亲委派模型的工作流程是：如果一个类加载器收到了类加载的请求，它首先不会自己去尝试加载这个类，
            而是把请求委托给父加载器去完成，依次向上，因此，所有的类加载请求最终都应该被传递到顶层的启动类加载器中，
            只有当父加载器在它的搜索范围中没有找到所需的类时，即无法完成该加载，子加载器才会尝试自己去加载该类。
    3 验证
        符合当前虚拟机的要求，而且不会危害虚拟机自身的安全。不同的虚拟机对类验证的实现可能会有所不同，但大致都会完成以下
        四个阶段的验证：文件格式的验证、元数据的验证、字节码验证和符号引用验证。
    4 准备
        准备阶段是正式为类变量分配内存并设置类变量初始值的阶段，这些内存都将在方法区中分配。对于该阶段有以下几点需要注意：
        1、这时候进行内存分配的仅包括类变量（static），而不包括实例变量，实例变量会在对象实例化时随着对象一块分配在Java堆中。
        2、这里所设置的初始值通常情况下是数据类型默认的零值（如0、0L、null、false等），而不是被在Java代码中被显式地赋予的值
        假设一个类变量的定义为：
            public static int value = 3；
            那么变量value在准备阶段过后的初始值为0，而不是3，因为这时候尚未开始执行任何Java方法，
            而把value赋值为3的putstatic指令是在程序编译后，存放于类构造器<clinit>（）方法之中的，
            所以把value赋值为3的动作将在初始化阶段才会执行。
            数据类型         默认零值
            int                 0
            long                0
            short               short(0)
            chart               '\u0000
            byte                byte0
            boolean             false
            float               0.0f
            double              0.0d
            reference           null
        如果类字段的字段属性表中存在ConstantValue属性，即同时被final和static修饰，
        那么在准备阶段变量value就会被初始化为ConstValue属性所指定的值。
    5 解析
        
```
	    



