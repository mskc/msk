

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

class AllSequences
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] array = {1,2,3,4,5,6,7};
        TreeNode root = createTree(array);
        ArrayList<LinkedList<Integer>> result = allSequences(root);
        //System.out.print("[");
        for (LinkedList<Integer> list : result) {
			System.out.println(list);
		}
	}
	
	public static ArrayList<LinkedList<Integer>> allSequences(TreeNode root){
	    ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
	    if(root == null){
	        result.add(new LinkedList<Integer>());
	        return result;
	    }
	    LinkedList<Integer> prefix = new LinkedList<Integer>();
	    prefix.add(root.data);
	    ArrayList<LinkedList<Integer>> leftSeq = allSequences(root.left);
	    ArrayList<LinkedList<Integer>> rightSeq = allSequences(root.right);
	    for(LinkedList<Integer> left : leftSeq){
	        for(LinkedList<Integer> right : rightSeq){
	            ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
	            weaveLists(left,right,weaved,prefix);
	            result.addAll(weaved);
	        }
	    }
	    return result;
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
    public static void weaveLists(LinkedList<Integer> first,LinkedList<Integer> second,ArrayList<LinkedList<Integer>> results,LinkedList<Integer> prefix){
        if(first.size() == 0 || second.size() == 0){
            LinkedList<Integer> result = (LinkedList<Integer>)prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }
        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first,second,results,prefix);
        prefix.removeLast();
        first.addFirst(headFirst);
        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first,second,results,prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }
}
