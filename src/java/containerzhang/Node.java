package java.containerzhang;

/**@author  zhangdelei
 * @data 2017年3月22日下午10:02:04
 *@Description TODO
 */
//节点类  

public class Node {
	
	
	     protected Node next; //指针域  
	     protected int data;//数据域  
	       
	     public Node( int data) {  
	           this. data = data;  
	     }  
	       
	     //显示此节点  
	     public void display() {  
	          System. out.print( data + " ");  
	     }  
	
}
