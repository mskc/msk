class LinkedList {
		Node start,end;
		int size;
		class Node{
			int data;
			Node next;
			Node(int data)
			{
				this.data=data;
				next=null;
			}
		}
		public void addLast(int data)
		{
			Node newnode=new Node(data);
			size++;
			if(start==null)
			{
				start=newnode;
				end=newnode;
			}
			else{
				end.next=newnode;
				end=newnode;
			}
		}
		public int removeFirst()
		{
			int t=start.data;
			start=start.next;
			return t;
		}
		public void display()
		{
			Node ptr=start;
			for(int i=1;i<=size;i++)
			{
				System.out.println(ptr.data+ "\n");
				ptr=ptr.next;
			}
		}
}
 class Queue{
LinkedList link=new LinkedList();

public void enqueue(int element){
     link.addLast(element);
}

public int dequeue(){
     return link.removeFirst();
}

public int size(){
    return link.size;
}
 public static void main(String[] args) {
      Queue q=new Queue();
      q.enqueue(1);
      q.enqueue(2);
      q.enqueue(3);
      q.enqueue(4);
      System.out.println(q.dequeue()+ "\n");
      System.out.println(q.dequeue()+ "\n");
      
	}
}
