package java.io;
/*
 *@author zhangdelei@bsgchina.com
 *@data 2017年2月1日下午9:26:56
 *@Description 学习javaIO的目录下的文件及其子目录的文件 
 */

import java.io.File;
import java.io.FilenameFilter;

public class JavaTestIOMenu {
	/*
	 * @author zhangdelei@bsgchina.com
	 * @data 2017年2月1日下午9:26:56
	 * @Description 这是一个内部类，实现了FilenameFilter接口，用于过滤文件
	*/
	static abstract class MyFileNameFilter implements FilenameFilter{
		private String suffix = "";
		
		public MyFileNameFilter (String surfix) {
			this.suffix = suffix;
		}
		public boolean accept(File dir,String name) {
			//如果文件名后缀与SUFFIX指定的后缀相同，则返回true,或者返回false
			if(new File(dir,name).isFile()){
				return name.endsWith(suffix);
			}else{
			//如果文件夹，则直接返回true
			return false;
			}
			
		}
	}
	
	/**
	 * 列出目录下所有的文件，包括子目录的文件路径
	 * @param dirname 文件夹的文件路径
	 */
	public static void listAllFiles(String dirName){
		//如果dir不以文件分隔符结尾，则自动添加文件分隔符
		if(!dirName.endsWith(File.separator)){
			dirName = dirName + File.separator;
		}
		File dirFile = new File(dirName);
		//如果dir对应的文件不存在，或者不是一个文件夹，则退出
		if(!dirFile.exists() || (!dirFile.isDirectory())){
			System.out.println("List失败！ 找不到目录："+dirName);
			return;
		}
		//列出
		
	}
}
