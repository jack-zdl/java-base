1 探究反射机制
    测试 对象.getClass 和 Class.forName("某包下的某个类") 和 类.class
2 Class.getDeclaredField(String name)
    返回一个 Field 对象，该对象反映此 Class 对象所表示的类或接口的指定已声明字段（包括私有成员）。
3 Class.getDeclaredFields();
    返回 Field 对象的一个数组，该数组包含此 Class 对象所表示的类或接口所声明的所有字段（包括私有成员）。
4 Class.getFields();
    返回一个包含某些 Field 对象的数组，该数组包含此 Class 对象所表示的类或接口的所有可访问公共字段。
