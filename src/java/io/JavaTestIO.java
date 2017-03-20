package java.io;
/*
 *@author zhangdelei@bsgchina.com
 *@data 2017年2月1日下午8:35:08
 *@Description 测试javaIO的下 获得某目录下的单个文件，及其所属属性
 */

import java.io.File;
import java.util.Date;

public class JavaTestIO {
	/*
	 * @author zhangdelei@bsgchina.com
	 * @data 2017年2月1日下午8:35:09
	 * @Description TODO
	*/
	public static void println(String s){
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		// 用文件路径新建一个文件对象，路径可以时绝对路径，也可以是相对路径
		// 传入的参数被当做文件的抽象路径/
		/** 抽象路径的文件分隔符用系统默认的文件分隔符替换返回
		 * 原来是 C:\fumai-project\test 替换后  C:/fumai-project/test
		 */
		File file = new File("C:/fumai-project/test/javaIO.txt");
		println("文件名:\t"+file.getName());//获得文件的名字，不包含路径
		//将抽象路径名中的文件分隔符用系统默认的文件分隔符替换
		println("文件路径:\t"+file.getPath());
		
		println("绝对路径:\t"+file.getAbsolutePath());
		println("父目录"+file.getParent());
		println("文件是否存在:\t"+file.exists());
		println("是否可读:\t"+file.canRead());
		println("是否可写:\t"+file.canWrite());
		println("是否是隐藏文件:\t"+file.isHidden());
		println("是否是普通文件:\t"+file.isFile());
		println("是否是文件目录:\t"+file.isDirectory());
		println("文件路径是否绝对路径:\t"+file.isAbsolute());
		println("文件路径的URL:\t"+file.toURI());
		println("文件最后修改时间:\t"+new Date(file.lastModified()));
		println("文件大小:\t"+file.length()+"bytes");
	}

}
