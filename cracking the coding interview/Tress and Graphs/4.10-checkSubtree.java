/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int data){
        this.data = data;
    }
}
class Codechef
{
    public static boolean containsTree(TreeNode t1, TreeNode t2) {
		if (t2 == null) {
			return true; 
		}
		return subTree(t1, t2);
	}
	
	public static boolean subTree(TreeNode r1, TreeNode r2) {
		if (r1 == null) {
			return false; 
		} else if (r1.data == r2.data && matchTree(r1,r2)) {
			return true;
		}
		return subTree(r1.left, r2) || subTree(r1.right, r2); 
	}

	public static boolean matchTree(TreeNode r1, TreeNode r2) {
		if (r1 == null && r2 == null) {
			return true; 
		} else if (r1 == null || r2 == null) { 
			return false; 
		} else if (r1.data != r2.data) {  
			return false; 
		} else {
			return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
		}
	}public static TreeNode createTree(int[] array){
        if(array.length == 0)
            return null;
        return createTree(array,0,array.length - 1);
    }
    
    public static TreeNode createTree(int[] array,int start,int end){
        if(end < start){
            return null;
        }
        int mid = (end + start)/2;
        TreeNode n = new TreeNode(array[mid]);
        n.left = createTree(array,start,mid - 1);
        n.right = createTree(array,mid + 1,end);
        return n;
    }
	public static void main(String[] args){
	    int[] array1 = {1,2,3,4,5,6,7};
        TreeNode root1 = createTree(array1);
        int[] array2 = {1,2,3};
        TreeNode root2 = createTree(array2);
        if(containsTree(root1,root2))
            System.out.println("subtree");
        else
            System.out.println("not a subtree");
	}
}
