package circularLL;
 class CircularLLlooplength {
	 static Node start,end;
	 static class Node{
		int data;
		Node next;
		public Node(int d)
		{
			data=d;
			next=null;
		}
	}
	public void insertatend(int d)
	{
		Node newnode=new Node(d);
		if(start==null)
			start=end=newnode;
		else{
			end.next=newnode;
			end=newnode;
		}
	}
	public int looplength(){
		Node slow,fast;
		int loop=0,count=0;
		slow=fast=start;
		while(fast!=null&& slow!=null)
		{
			fast=fast.next;
			if(fast==slow)
			{
				loop=1;
				break;
			}
			slow=slow.next;
			fast=fast.next;
			if(fast==slow){
				loop=1;
				break;
			}
		}
		if(loop==1)
		{
			while(fast.next!=slow)
			{
				count++;
				fast=fast.next;
			}
		}
		return count+1;
	}
	public static void main(String args[])
	{
		CircularLLlooplength link=new CircularLLlooplength();
		link.start = new Node(12);
        link.start.next = new Node(56);
        link.start.next.next = new Node(2);
        link.start.next.next.next = new Node(11);
        link.start.next.next.next.next = link.start.next;
        System.out.println(link.looplength()+ " ");
	}

}
