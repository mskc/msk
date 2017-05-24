

import java.util.*;
import java.lang.*;
import java.io.*;

class TreeNode
{
   int data;
   TreeNode left,right;
   public TreeNode(int data){
       this.data = data;
   }
}
class Helper{
    public static void main(String[] args){
        Helper h = new Helper();
        int[] array = {1,2,3,4,5,6,7};
        TreeNode root = h.minimumTree(array);
        h.print(root);
        System.out.println();
        System.out.println(h.height(root));
    }
    public TreeNode minimumTree(int[] array){
        if(array.length == 0)
            return null;
        return minimumTree(array,0,array.length - 1);
    }
    public TreeNode minimumTree(int[] array,int start,int end){
        if(end < start){
            return null;
        }
        int mid = (end + start)/2;
        TreeNode n = new TreeNode(array[mid]);
        n.left = minimumTree(array,start,mid - 1);
        n.right = minimumTree(array,mid + 1,end);
        return n;
    }
    public void print(TreeNode root){
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode t = q.poll();
                System.out.print(t.data + " ");
                if(t.left != null){
                    q.offer(t.left);
                }
                if(t.right != null){
                    q.offer(t.right);
                }
        }
    }
    public int height(TreeNode root){
        if(root == null)
            return -1;
        int leftHeight = height(root.left) + 1;
        int rightHeight = height(root.right) + 1;
        return Math.max(leftHeight,rightHeight);
        
    }
}
 
