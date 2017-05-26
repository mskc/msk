

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

class FirstCommonAncester
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] array = {1,2,3,4,5,6,7};
        TreeNode root = createTree(array);
        TreeNode result = commonAncester(root,3,5);
		if(result != null)
		    System.out.println(result.data);
		else
		    System.out.println("not found");
	}
	
	public static TreeNode commonAncester(TreeNode root,int a,int b){
	    if(root == null)
	        return null;
	    if(root.data == a || root.data == b)
	        return root;
	     TreeNode left = commonAncester(root.left,a,b);
	     TreeNode right = commonAncester(root.right,a,b);
	     if(left != null && right != null)
	        return root;
	     return left!=null ? left : right;
	}
	
	
	public static TreeNode createTree(int[] array){
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
}
