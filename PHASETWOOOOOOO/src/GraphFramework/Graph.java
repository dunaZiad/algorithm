/*
CPCS-324 Project, Phase 1
Students Name            | ID         | Section
--------------------------------------------------
Duna Ziad Hejazi         | 2107548    | B0B
Hadeel Ali Alqarni       | 2105488    | B0B
Njoud Naji Alahmadi      | 2109470    | B0B
Sereen Hussain Baageel   | 2105237    | B0B
*/
package GraphFramework;
import java.io.*;
import java.util.*;

public abstract class Graph{
    
    //ATTRIBUTES
    private int veticesNo;
    private int edgeNo;
    public boolean isDigraph = true;
    public Map<String, Vertex> vertex = new HashMap<>();

   //------------------------------------------------------------------------
    
    //CONSTRUCTERS
    public Graph(){
        this.veticesNo = 0;
        this.edgeNo = 0;
        this.isDigraph = false;
        //this.vertex = new HashMap<>();
        
    }
    public Graph(int veticesNo, int edgeNo) {
        this.veticesNo = veticesNo;
        this.edgeNo = edgeNo;
        this.isDigraph = false;
    }
    
    public Graph(int veticesNo, int edgeNo, boolean isDigraph) {
        this.veticesNo = veticesNo;
        this.edgeNo = edgeNo;
        this.isDigraph = isDigraph;
    }

    public Graph(boolean isDigraph) {
        this.isDigraph = isDigraph;
    }

    public Map<String, Vertex> getVertex() {
        return vertex;
    }

    public void setVertex(Map<String, Vertex> vertex) {
        this.vertex = vertex;
    }

    public boolean isIsDigraph() {
        return isDigraph;
    }

    public void setIsDigraph(boolean isDigraph) {
        this.isDigraph = isDigraph;
    }

    //------------------------------------------------------------------------

    //METHODS
    //ABSTRACT METHOD TO ADD VERTEX INTO THE MAP
    public abstract void addVertex(String label);
  
    //ABSTRACT METHOD TO ADD EDGE BETWEEN TWO VERTEXES 
    public abstract void addEdge(Graph graph,Vertex source,Vertex target,int weight);
    
    //ABSTRACT METHOD TO CREATE A LINE OPJECT FOR EDGE
    public abstract Edge createEdge(Vertex source,Vertex target,int weight);
    
    //ABSTRACT METHOD TO READ GRAPH INFORMATION FROM FILE
    public abstract void readGraphFromFile(Graph graph,File readFile) throws FileNotFoundException;

    //ABSTRACT METHOD TO MAKE RANDOM GRAPH
    public abstract void makeGraph(Graph graph, int numberOfOffices, int numberOfLines);

    }

    