

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

class CheckBalanced
{
	public static void main (String[] args) throws java.lang.Exception
	{
		CheckBalanced c = new CheckBalanced();
		int[] array = {1,2,3,4,5,6,7};
        TreeNode root = c.createTree(array);
		if(c.checkBalncedTree(root)){
		    System.out.println("true");
		}
		else{
		    System.out.println("false");
		}
	}
	
	public boolean checkBalncedTree(TreeNode root){
	    int result = checkHeight(root);
	    return result != Integer.MIN_VALUE;
	}
	public int checkHeight(TreeNode root){
	    if(root == null){
	        return -1;
	    }
	    int leftHeight = checkHeight(root.left);
	    if(leftHeight == Integer.MIN_VALUE){
	        return Integer.MIN_VALUE;
	    }
	    int rightHeight = checkHeight(root.right);
	    if(rightHeight == Integer.MIN_VALUE){
	        return Integer.MIN_VALUE;
	    }
	    int heightDiff = leftHeight - rightHeight;
	    if(Math.abs(heightDiff) > 1){
	        return Integer.MIN_VALUE;
	    }
	    else{
	        return leftHeight + rightHeight + 1;
	    }
	}
	
	public TreeNode createTree(int[] array){
        if(array.length == 0)
            return null;
        return createTree(array,0,array.length - 1);
    }
    
    public TreeNode createTree(int[] array,int start,int end){
        if(end < start){
            return null;
        }
        int mid = (end + start)/2;
        TreeNode n = new TreeNode(array[mid]);
        n.left = createTree(array,start,mid - 1);
        n.right = createTree(array,mid + 1,end);
        return n;
    }
}
