package com.zhang.io;
/*
 *@author zhangdelei@bsgchina.com
 *@data 2017��2��1������8:35:08
 *@Description ����javaIO���� ���ĳĿ¼�µĵ����ļ���������������
 */

import java.io.File;
import java.util.Date;

public class JavaTestIO {
	/*
	 * @author zhangdelei@bsgchina.com
	 * @data 2017��2��1������8:35:09
	 * @Description TODO
	*/
	public static void println(String s){
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		// ���ļ�·���½�һ���ļ�����·������ʱ����·����Ҳ���������·��
		// ����Ĳ����������ļ��ĳ���·��/
		/** ����·�����ļ��ָ�����ϵͳĬ�ϵ��ļ��ָ����滻����
		 * ԭ���� C:\fumai-project\test �滻��  C:/fumai-project/test
		 */
		File file = new File("C:/fumai-project/test/javaIO.txt");
		println("�ļ���:\t"+file.getName());//����ļ������֣�������·��
		//������·�����е��ļ��ָ�����ϵͳĬ�ϵ��ļ��ָ����滻
		println("�ļ�·��:\t"+file.getPath());
		
		println("����·��:\t"+file.getAbsolutePath());
		println("��Ŀ¼"+file.getParent());
		println("�ļ��Ƿ����:\t"+file.exists());
		println("�Ƿ�ɶ�:\t"+file.canRead());
		println("�Ƿ��д:\t"+file.canWrite());
		println("�Ƿ��������ļ�:\t"+file.isHidden());
		println("�Ƿ�����ͨ�ļ�:\t"+file.isFile());
		println("�Ƿ����ļ�Ŀ¼:\t"+file.isDirectory());
		println("�ļ�·���Ƿ����·��:\t"+file.isAbsolute());
		println("�ļ�·����URL:\t"+file.toURI());
		println("�ļ�����޸�ʱ��:\t"+new Date(file.lastModified()));
		println("�ļ���С:\t"+file.length()+"bytes");
	}

}
