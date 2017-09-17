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
class KthElement
{
	public static void main (String[] args) throws java.lang.Exception
	{
		LinkedList list = new LinkedList();
		list.append(1);
		list.append(1);
		list.append(5);
		list.append(7);
	    list.append(5);
		KthElement kth = new KthElement();
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		kth.kthElementFromLast(list.head,k);
	}
	public int kthElementFromLast(Node head,int k){
		if(head == null)
		return 0;
		int count = kthElementFromLast(head.next,k) + 1;
		if(count == k)
		System.out.println(head.data);
		return count;
	}
}