

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

class ValidateBst
{
	public static void main (String[] args) throws java.lang.Exception
	{
		ValidateBst v = new ValidateBst();
		int[] array = {1,2,3,4,5,6,7};
        TreeNode root = v.createTree(array);
		if(v.checkBst(root)){
		    System.out.println("true");
		}
		else{
		    System.out.println("false");
		}
	}
	
	public boolean checkBst(TreeNode root){
	    return checkBst(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	public boolean checkBst(TreeNode root,int min,int max){
	    if(root == null){
	        return true;
	    }
	    return (root.data > min) && (root.data < max) && checkBst(root.left,min,root.data) && checkBst(root.right,root.data,max);
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
