

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
class ListOfDepths{
    public static void main(String[] args){
        ListOfDepths h = new ListOfDepths();
        int[] array = {1,2,3,4,5,6,7};
        TreeNode root = h.createTree(array);
        ArrayList<LinkedList<TreeNode>> result = h.listsOfDepths(root);
        h.print(result);
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
    public ArrayList<LinkedList<TreeNode>> listsOfDepths(TreeNode root){
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
        if(root == null)
            return result;
        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        current.add(root);
        while(current.size() > 0){
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<TreeNode>();
            for(TreeNode parent : parents){
                if(parent.left != null){
                    current.add(parent.left);
                }
                if(parent.right != null){
                    current.add(parent.right);
                }
            }
        }
        return result;
    }
    public void print(ArrayList<LinkedList<TreeNode>> result){
        System.out.print("[");
        for(LinkedList i : result){
            System.out.print("[");
            for(Object j : i){
                System.out.print(((TreeNode) j).data + " ");
            }
            System.out.print("]");
        }
        System.out.print("]");
    }
}
 
