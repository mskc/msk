

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
	public void append(Node n){
		if(head == null){
			head = n;
			return ;
		}
		Node current = head;
		while(current.next!=null){
			current = current.next;
		}
		current.next = n;
}
}
class Intersection
{
	public static void main (String[] args) throws java.lang.Exception
	{
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		list1.append(new Node(1));
		list1.append(new Node(2));
		list1.append(new Node(3));
		list1.append(new Node(4));
		list1.append(new Node(5));
		list2.append(new Node(6));
		list2.append(new Node(7));
		list2.append(new Node(8));
		list2.append(list1.head.next.next);
		Intersection i = new Intersection();
		if(i.contains(list1.head,list2.head))
		System.out.println("yes");
		else
		System.out.println("no");
	}
	public boolean contains(Node head1,Node head2){
		if(head1 == null || head2 == null)
		return false;
		HashSet<Node> hs = new HashSet<Node>();
		while(head1 != null){
			if(hs.contains(head1))
			break;
			hs.add(head1);
			head1 = head1.next;
		}
		while(head2 != null){
			if(hs.contains(head2))
			return true;
			head2 = head2.next;
		}
		return false;
	}
}
