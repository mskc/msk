package stack;

public class Stack {
	int maxsize;
	int[] a;
	int top;
	public Stack(int m)
	{
		maxsize=m;
		a=new int[m];
		top=-1;
	}
	public void push(int d)
	{
		if(top==maxsize)
			System.out.println("stack is full");
		else
		a[++top]=d;
	}
	public int pop(){
		if(top==-1)
		{
			System.out.println("stack is empty");
			return 0;
		}
		else
		return a[top--];
	}
    public int peek(){
    	return a[top];
    }
    public void display()
    {
    	for(int i=0;i<=top;i++)
    	System.out.println(a[i]+ " ");
    }
	public static void main(String[] args) {
		Stack s=new Stack(15);
		s.push(3);
		s.push(4);
		s.push(8);
		s.push(7);
		s.push(14);
		s.pop();
		System.out.println(s.peek()+ " ");
		s.display();
	}

}
