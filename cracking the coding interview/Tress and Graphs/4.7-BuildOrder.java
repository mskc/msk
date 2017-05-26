
import java.util.*;
import java.lang.*;
import java.io.*;
class BuildOrder{
    public Project[] findBuildOrder(String[] projects,String[][] dependencies){
        Graph graph = buildGraph(projects,dependencies);
        return orderProjects(graph.getNodes());
    }
    
    public Graph buildGraph(String[] projects,String[][] dependencies){
        Graph graph = new Graph();
        for(String project : projects){
            graph.getOrCreateNode(project);
        }
        for(String[] dependency : dependencies){
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first,second);
        }
        return graph;
    }
    
    Project[] orderProjects(ArrayList<Project> projects){
        Project[] order = new Project[projects.size()];
        int endOfList = addNonDependent(order,projects,0);
        int toBeProcessed = 0;
        while(toBeProcessed < order.length){
            Project current = order[toBeProcessed];
            if(current == null)
                return null;
            ArrayList<Project> children = current.getChildren();
            for(Project child : children){
                child.decrementDependencies();
            }
            endOfList = addNonDependent(order,children,endOfList);
            toBeProcessed++;
        }
        return order;
    }
    public int addNonDependent(Project[] order,ArrayList<Project> projects,int offset){
        for(Project project : projects){
            if(project.getNumberOfDependencies() == 0){
                order[offset] = project;
                offset++;
            }
        }
        return offset;
    }
    public static void main(String[] args){
        BuildOrder b = new BuildOrder();
        String[] projects = new String[]{"a","b","c","d","e","f"};
        String[][] dependencies = new String[][]{{"a","b"},{"a","c"},{"b","c"},{"c","d"},{"d","f"}};
        Project[] order = b.findBuildOrder(projects,dependencies);
        for(Project project : order)
            System.out.println(project.name);
    }
}


class Graph{
    ArrayList<Project> nodes = new ArrayList<Project>();
    HashMap<String,Project> map = new HashMap<String,Project>();
    public Project getOrCreateNode(String name){
        if(!map.containsKey(name)){
            Project node = new Project(name);
            nodes.add(node);
            map.put(name,node);
        }
        return map.get(name);
    }
    
    public void addEdge(String startName,String endName){
        Project start = getOrCreateNode(startName);
        Project end = getOrCreateNode(endName);
        start.addNeighbor(end);
    }
    public ArrayList<Project> getNodes(){
        return nodes;
    }
}


class Project{
    ArrayList<Project> children = new ArrayList<Project>();
    HashMap<String,Project> map = new HashMap<String,Project>();
    String name;
    int dependencies = 0;
    public Project(String n){
        name = n;
    }
    public void addNeighbor(Project node){
        if(!map.containsKey(node.getName())){
            children.add(node);
            map.put(node.getName(),node);
            node.incrementDependencies();
        }
    }
    public void incrementDependencies(){
        dependencies++;
    }
    public void decrementDependencies(){
        dependencies--;
    }
    public String getName(){
        return name;
    }
    public ArrayList<Project> getChildren(){
        return children;
    }
    public int getNumberOfDependencies(){
        return dependencies;
    }
}
	
