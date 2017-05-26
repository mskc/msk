

import java.util.*;
import java.lang.*;
import java.io.*;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    public TreeNode(int data){
        this.data = data;
    }
}
class Successor
{
	
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
        if(n.left != null)
            n.left.parent = n;
        if(n.right != null)
            n.right.parent = n;
        return n;
    }
    public static TreeNode inorderSucc(TreeNode root){
        if(root == null)
            return null;
        if(root.right != null){
            return leftMostChild(root.right);
        }else{
            TreeNode q = root;
            TreeNode x = q.parent;
            while(x != null && x.left != q){
                q = x;
                x = x.parent;
            }
            return x;
        }
    }
    public static TreeNode leftMostChild(TreeNode n){
        if(n == null)
            return null;
        while(n.left != null){
            n = n.left;
        }
        return n;
    }
    public static TreeNode find(TreeNode root,int val){
        if(root.data == val){
            return root;
        }
        else if(val < root.data)
            return find(root.left,val);
        else return find(root.right,val);
    }
    public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = createTree(array);
		for (int i = 0; i < array.length; i++) {
			TreeNode node = find(root,array[i]);
			TreeNode next = inorderSucc(node);
			if (next != null) {
				System.out.println(node.data + "->" + next.data);
			} else {
				System.out.println(node.data + "->" + null);
			}
		}
	}
}
