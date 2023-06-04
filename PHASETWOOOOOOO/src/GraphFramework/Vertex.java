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
import java.util.*;
public class Vertex {
    //ATTRIBUTES
    private String label;
    private char id;
    private boolean isVisited;
    private List<Edge> adjList = new ArrayList<>();
    private Vertex parent;
    private int city;
    private static int cityCounter = 1;

    //----------------------------------------------------------------

    //CONSTRUCTORS
    public Vertex(String label) {
        this.label = label;
        this.city = cityCounter++;
    }

    public Vertex(char id) {
        this.id = id;
        this.city = cityCounter++;
    }

    public Vertex(int city) {
        this.city = city;
    }

    //----------------------------------------------------------------

    //GETTERS AND SETTERS
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isIsVisited() {
        return isVisited;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public List<Edge> getEdges() {
        return adjList;
    }

    public void setAdjList(List<Edge> adjList) {
        this.adjList = adjList;
    }

    public char getId() {
        return id;
    }

    public void setId(char id) {
        this.id = id;
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    //-----------------------------------------------------------
    //METHODS
    public void displayInfo() {
        System.out.print(label);
    }

    public String toString() {
        if (this.parent == null) {
            return "loc. " + this.label + ": city " + this.city;
        } else {
            return this.parent.toString() + " – loc. " + this.label + ": city " + this.city;
        }
    }

    public void addEdge(Vertex source, Vertex target, int weight, boolean directed) {
        if (!directed) {
            this.adjList.add(new Edge(source, target, weight));
            target.getEdges().add(new Edge(target, source, weight));
        } else {
            this.adjList.add(new Edge(source, target, weight));
        }
    }
}
