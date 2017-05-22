/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
class Node{
	int data;
	Node next;
	public Node(int value){
		data = value;
	}
}
class LinkedList{
	Node head;
	public void append(int data){
		if(head == null){
			head = new Node(data);
			return ;
		}
		Node current = head;
		while(current.next!=null){
			current = current.next;
		}
		current.next = new Node(data);
}
}
class DeleteMiddle
{
	public static void main (String[] args) throws java.lang.Exception
	{
		LinkedList list = new LinkedList();
		list.append(1);
		list.append(1);
		list.append(5);
		list.append(7);
	    list.append(5);
		DeleteMiddle d = new DeleteMiddle();
		d.print(list.head);
		d.deleteMiddleElement(list.head.next);
		d.print(list.head);
	}
	public void print(Node head){
		if(head == null)
		return;
		while(head!=null){
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
	public void deleteMiddleElement(Node n){
		if(n == null || n.next == null)
		return;
		n.data = n.next.data;
		n.next = n.next.next;
	}
}