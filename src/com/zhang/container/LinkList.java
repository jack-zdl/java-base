package com.zhang.container;

/**@author  zhangdelei
 * @data 2017??3??22??????10:03:37
 *@Description TODO
 */

public class LinkList {
	
	  public Node first; // ???????????  
	  private int pos = 0;// ???????  
	  
	     public LinkList() {  
	           this. first = null;  
	     }  
	  
	     // ???????????  
	     public void addFirstNode( int data) {  
	          Node node = new Node(data);  
	          node. next = first;  
	          first = node;  
	     }  
	  
	     // ??????????,??????????  
	     public Node deleteFirstNode() {  
	          Node tempNode = first;  
	          first = tempNode. next;  
	          return tempNode;  
	     }  
	  
	     // ????????ò????? ??index????????  
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
	  
	     // ?????????????  
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
	  
	     // ???????data??????(????????????)  
	     public Node deleteByData( int data) {  
	          Node current = first;  
	          Node previous = first; //???????????  
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
	  
	     // ???????????????  
	     public void displayAllNodes() {  
	          Node current = first;  
	           while (current != null) {  
	              current.display();  
	              current = current. next;  
	          }  
	          System. out.println();  
	     }  
	  
	     // ??????ò????????  
	     public Node findByPos( int index) {  
	          Node current = first;  
	           if ( pos != index) {  
	              current = current. next;  
	               pos++;  
	          }  
	           return current;  
	     }  
	  
	     // ????????????????  
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
