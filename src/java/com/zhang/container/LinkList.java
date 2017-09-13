package java.com.zhang.container;

/**@author  zhangdelei
 * @data 2017��3��22������10:03:37
 *@Description TODO
 */

public class LinkList {
	
	  public Node first; // ����һ��ͷ���  
	  private int pos = 0;// �ڵ��λ��  
	  
	     public LinkList() {  
	           this. first = null;  
	     }  
	  
	     // ����һ��ͷ�ڵ�  
	     public void addFirstNode( int data) {  
	          Node node = new Node(data);  
	          node. next = first;  
	          first = node;  
	     }  
	  
	     // ɾ��һ��ͷ���,������ͷ���  
	     public Node deleteFirstNode() {  
	          Node tempNode = first;  
	          first = tempNode. next;  
	          return tempNode;  
	     }  
	  
	     // ������λ�ò���ڵ� ��index�ĺ������  
	     public void add(int index, int data) {  
	          Node node = new Node(data);  
	          Node current = first;  
	          Node previous = first;  
	           while ( pos != index) {  
	              previous = current;  
	              current = current. next;  
	               pos++;  
	          }  
	          node. next = current;  
	          previous. next = node;  
	           pos = 0;  
	     }  
	  
	     // ɾ������λ�õĽڵ�  
	     public Node deleteByPos( int index) {  
	          Node current = first;  
	          Node previous = first;  
	           while ( pos != index) {  
	               pos++;  
	              previous = current;  
	              current = current. next;  
	          }  
	           if(current == first) {  
	               first = first. next;  
	          } else {  
	               pos = 0;  
	              previous. next = current. next;  
	          }  
	           return current;  
	     }  
	  
	     // ���ݽڵ��dataɾ���ڵ�(����ɾ����һ��)  
	     public Node deleteByData( int data) {  
	          Node current = first;  
	          Node previous = first; //��ס��һ���ڵ�  
	           while (current. data != data) {  
	               if (current. next == null) {  
	                    return null;  
	              }  
	              previous = current;  
	              current = current. next;  
	          }  
	           if(current == first) {  
	               first = first. next;  
	          } else {  
	              previous. next = current. next;  
	          }  
	           return current;  
	     }  
	  
	     // ��ʾ�����еĽڵ���Ϣ  
	     public void displayAllNodes() {  
	          Node current = first;  
	           while (current != null) {  
	              current.display();  
	              current = current. next;  
	          }  
	          System. out.println();  
	     }  
	  
	     // ����λ�ò��ҽڵ���Ϣ  
	     public Node findByPos( int index) {  
	          Node current = first;  
	           if ( pos != index) {  
	              current = current. next;  
	               pos++;  
	          }  
	           return current;  
	     }  
	  
	     // �������ݲ��ҽڵ���Ϣ  
	     public Node findByData( int data) {  
	          Node current = first;  
	           while (current. data != data) {  
	               if (current. next == null)  
	                    return null;  
	              current = current. next;  
	          }  
	           return current;  
	     }  
}
