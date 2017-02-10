package heap;
class Heap {
	Heap1 h;
	class Heap1{
		int capacity;
		int count;
		int[] a;
	 public Heap1(int capacity){
		 this.capacity=capacity;
		 a=new int[capacity];
	 }
	}
	 public void buildheap(int[] b,int n)
	 {
		 h=new Heap1(n);
		 System.out.println("r");
		 for(int i=0;i<n;i++){
			 h.a[i]=b[i];
		 }
		 h.count=n;
		 for(int i=(n-1)/2;i>=0;i--){
			 percolatedown(h,i);
	 }
	 }
	 public int leftchild(Heap1 h,int i)
	 {
		 int left=2*i+1;
		 if(left>=h.capacity)
			 return -1;
			return left; 
	 }
	 public int rightchild(Heap1 h,int i)
	 {
		 int right=2*i+2;
		 if(right>=h.capacity)
			 return -1;
			return right; 
	 }
	 public void percolatedown(Heap1 h,int i)
	 {
		 int l,r,max,temp;
		 l=leftchild(h,i);
		 r=rightchild(h,i);
		 if(l!=-1&&h.a[l]>h.a[i])
			 max=l;
		 else
			 max=i;
		 if(r!=-1&&h.a[r]>h.a[max])
			 max=r;
		 if(max!=i)
		 {
			 temp=h.a[i];
			 h.a[i]=h.a[max];
			 h.a[max]=temp;
		 }
		 if(max==i)
			 return;
		 else
			 percolatedown(h,max);
	 }
	 public void display(){
		 for(int i=0;i<h.count;i++)
			 System.out.println(h.a[i]+ " ");
	 }

	public static void main(String[] args) {
		Heap s=new Heap();
		int b[]={2,6,4,5,8};
		s.buildheap(b,5);
		s.display();
	}

}
