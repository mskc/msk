

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
class Palindrome
{
	public static void main (String[] args) throws java.lang.Exception
	{
		LinkedList list = new LinkedList();
		list.append(1);
		list.append(2);
		list.append(1);
		list.append(2);
		list.append(1);
		Palindrome p = new Palindrome();
		if(p.isPalindrome(list.head))
		System.out.println("yes");
		else
		System.out.println("no");
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
	public boolean isPalindrome(Node head){
		Node reverse = reverseNode(head);
		print(reverse);
		print(head);
		if(isEqual(head,reverse))
		return true;
		return false;
	}
	public Node reverseNode(Node n){
		if(n == null || n.next == null)
		return n;
		Node head = null;
		while(n!=null){
			Node node = new Node(n.data);
			node.next = head;
			head = node;
			n = n.next;
		}
		return head;
	}
	public boolean isEqual(Node n1,Node n2){
		if(n1 == null && n2 == null)
		return true;
		if((n1 == null && n2 !=null) || (n1 !=null && n2 == null))
		return false;
		if(n1.data != n2.data)
		return false;
		return isEqual(n1.next,n2.next);
	}
}
