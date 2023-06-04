/*
CPCS-324 Project, Phase 1
Students Name            | ID         | Section
--------------------------------------------------
Duna Ziad Hejazi         | 2107548    | B0B
Hadeel Ali Alqarni       | 2105488    | B0B
Njoud Naji Alahmadi      | 2109470    | B0B
Sereen Hussain Baageel   | 2105237    | B0B
*/
package AirFreightApp;
import GraphFramework.*;
import java.io.*;
import java.util.*;

public class AFRouteMap extends Graph {

    //CONSTRUCTORS
    public AFRouteMap(boolean equals) {
    }
    
    public AFRouteMap() {
    }

    public AFRouteMap(int officiesNo, int linesNo) {
        super(officiesNo,linesNo);
    }

    //-----------------------------------------------------
    //METHODS
    @Override
    public void addVertex(String label) {
         this.vertex.putIfAbsent(label, new Location(label));
    }
    
    //--------------------------------------------------------------------------
        
    @Override
    public void addEdge(Graph graph,Vertex source, Vertex target, int weight) {

        //CREATE NEW EDGE
        Route e = createEdge(source,target,weight);
        e.setSource(source); //SET SOURCE
        e.setTarget(target); //SET TARGET
        e.setWeight(weight); //SET WEIGHT

        
        //CREATE NEW VERTEX
        Location sourceNode = (Location) graph.vertex.get(e.getSource().getLabel());
        Location targetNode = (Location) graph.vertex.get(e.getTarget().getLabel());


        if (sourceNode.equals(null))
            throw new IllegalArgumentException();

        if (targetNode == null)
            throw new IllegalArgumentException();

        // ADD EDGES TO VERTEX'S EDGELIST
        sourceNode.addEdge(sourceNode,targetNode,weight,isIsDigraph());

    }
    
    //--------------------------------------------------------------------------
    
    public Route createEdge(Vertex source,Vertex target,int weight){  
      return new Route();
      
    }

    //--------------------------------------------------------------------------

    @Override
    public void readGraphFromFile(Graph graph,File readFile) throws FileNotFoundException {


        //CREATING SCANNER OBJECTS
        Scanner input = new Scanner(readFile);
        Scanner choice = new Scanner(System.in);

        //CREATING LINE METHOD
        String[] line = input.nextLine().split(" ");   //line[0] = digraph, line[1] = 1

        //CREATING GRAPH
        graph=new AFRouteMap();

        //SET THE DIRECTION OF GRAPH
        if (line[1].equals("1")) {
            graph.setIsDigraph(true);
        } else {
            graph.setIsDigraph(false);
        }

        //FILL INFO ARRAY
        line = input.nextLine().split(" ");

        //READ EDGE NUMBER
        int numberOfEdges = Integer.parseInt(line[1]);
        System.out.println("numberOfEdges = " + numberOfEdges);

        //READ EDGES
        while (numberOfEdges-- > 0){
            line = input.nextLine().split(" ");
            graph.addVertex(line[0]);
            graph.addVertex(line[1]);
            graph.addEdge(graph,new Location (line[0]),new Location (line[1]), Integer.parseInt(line[2]));
 
        }

        //PRINT MENU
        System.out.println("---------------------------------------------------");
        ShortestPathAlgorithm paths=new ShortestPathAlgorithm();
        System.out.print("Please Enter 1 for the shortest path from a single " +
                "point to all points and 2 for the shortest path from all points to the rest:");
        //CALL METHOD
        paths.computeDijkstraAlg(graph,choice.nextInt());
        System.out.println();

    }

    //--------------------------------------------------------------------------


    //Method To Randomly Generate Graph, Override From Grapph Class
    @Override
    public void makeGraph(Graph graph, int numberOfOffices, int numberOfLines){

        //Create New AFRouteMap Graph With numberOfOffices and numberOfLines and Decleare Varible We Need
        graph = new AFRouteMap(numberOfOffices,numberOfLines);
        Random random = new Random();
        Vertex source = null;
        Vertex target = null;

        //Create The Necessary Edges to ensuring the graph is connected, and generate random wight
        for (int i = 0; i < numberOfOffices - 1 ; i++) {
            int randomWeight = random.nextInt(10) + 1;
            source = new Vertex(String.valueOf(i));
            target = new Vertex(String.valueOf(i + 1));

            //Add Vertex and Edge To Graph
            graph.addVertex(source.getLabel());
            graph.addVertex(target.getLabel());
            graph.addEdge(graph, source, target, randomWeight);
        }

        //Calculate Remainig Edges
        int remaning = numberOfLines - (numberOfOffices - 1);

        //Add The Remaining Edge
        for (int i = 0; i < remaning; i++) {
            String sourceId = String.valueOf( (int)( Math.random() * numberOfOffices) );
            String destinationId = String.valueOf( (int)( Math.random() * numberOfOffices) );
            //Make Sure We Do Not Have A Dublicate
            if (sourceId.equalsIgnoreCase(destinationId)) {
                --i;
                continue;
            }
            //Add The Remainig Edge
            int randomWeight = (int) (1 + Math.random() * 10);
            graph.addEdge(graph,new Vertex (source.getLabel()),new Vertex (target.getLabel()), randomWeight);
            addEdge(graph, source, target, randomWeight);
        }
        //Start Calculating Time For Dijkstra Algorithm
        double startTime = System.nanoTime();

        DBAllSourceSPAlg pathOfAll = new DBAllSourceSPAlg();
        pathOfAll.computeDijkstraAlg(graph, remaning);

        //End Time
        double finishTime = System.nanoTime();

        //Print Message
        System.out.println("\n-----------------------------------------------------");
        System.out.println("Run time for Dijkstra algorithm " + (finishTime - startTime) + " ns \n");
    }


}
