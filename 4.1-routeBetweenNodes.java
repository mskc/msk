/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Graph
{
	HashMap<Integer,Node> nodeLookUp = new HashMap<Integer,Node>();
	 static class Node{
	    int id;
	    public State state;
	    LinkedList<Node> adjacent = new LinkedList<Node>();
	    public Node(int id){
	        this.id = id;
	    }
	}
	public List<Node> getNodes(){
	    ArrayList<Node> list = new ArrayList<Node>();
	    list.addAll(nodeLookUp.values());
	    return list;
	}
	public Node getNode(int id){
	    return nodeLookUp.get(id);
	}
	public void setNode(int source,int destination){
	    Node s = getNode(source);
	    Node d = getNode(destination);
	    s.adjacent.add(d);
	}
	public enum State {
		Unvisited, Visited, Visiting;
	} 

	public static void main(String a[])
	{
		Graph g = new Graph();
	    g.nodeLookUp.put(1,new Node(1));
	    g.nodeLookUp.put(2,new Node(2));
	    g.nodeLookUp.put(3,new Node(3));
	    g.nodeLookUp.put(4,new Node(4));
	    g.nodeLookUp.put(5,new Node(5));
	    g.nodeLookUp.put(6,new Node(6));
	    g.setNode(1,2);
	    g.setNode(1,3);
	    g.setNode(2,4);
	    g.setNode(2,5);
	    g.setNode(4,6);
	    g.setNode(5,6);
	    if(g.search(g.getNode(3),g.getNode(5)))
	        System.out.println("path is present");
	    else
	        System.out.println("path is not present");
	}
	
    public  boolean search(Node start,Node end) {  
        LinkedList<Node> q = new LinkedList<Node>();
        for (Node u : getNodes()) {
            u.state = State.Unvisited;
        }
        start.state = State.Visiting;
        q.add(start);
        Node u;
        while(!q.isEmpty()) {
            u = q.removeFirst();
            if (u != null) {
	            for (Node v : u.adjacent) {
	                if (v.state == State.Unvisited) {
	                    if (v == end) {
	                        return true;
	                    } else {
	                        v.state = State.Visiting;
	                        q.add(v);
	                    }
	                }
	            }
	            u.state = State.Visited;
            }
        }
        return false;
    }
}
