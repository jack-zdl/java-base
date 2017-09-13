package java.com.zhang.io;
/*
 *@author zhangdelei@bsgchina.com
 *@data 2017��2��1������9:26:56
 *@Description ѧϰjavaIO��Ŀ¼�µ��ļ�������Ŀ¼���ļ� 
 */

import java.io.File;
import java.io.FilenameFilter;

public class JavaTestIOMenu {
	/*
	 * @author zhangdelei@bsgchina.com
	 * @data 2017��2��1������9:26:56
	 * @Description ����һ���ڲ��࣬ʵ����FilenameFilter�ӿڣ����ڹ����ļ�
	*/
	static abstract class MyFileNameFilter implements FilenameFilter {
		private String suffix = "";
		
		public MyFileNameFilter (String surfix) {
			this.suffix = suffix;
		}
		public boolean accept(File dir, String name) {
			//����ļ�����׺��SUFFIXָ���ĺ�׺��ͬ���򷵻�true,���߷���false
			if(new File(dir,name).isFile()){
				return name.endsWith(suffix);
			}else{
			//����ļ��У���ֱ�ӷ���true
			return false;
			}
			
		}
	}
	
	/**
	 * �г�Ŀ¼�����е��ļ���������Ŀ¼���ļ�·��
	 * @param dirname �ļ��е��ļ�·��
	 */
	public static void listAllFiles(String dirName){
		//���dir�����ļ��ָ�����β�����Զ�����ļ��ָ���
		if(!dirName.endsWith(File.separator)){
			dirName = dirName + File.separator;
		}
		File dirFile = new File(dirName);
		//���dir��Ӧ���ļ������ڣ����߲���һ���ļ��У����˳�
		if(!dirFile.exists() || (!dirFile.isDirectory())){
			System.out.println("Listʧ�ܣ� �Ҳ���Ŀ¼��"+dirName);
			return;
		}
		//�г�
		
	}
}
