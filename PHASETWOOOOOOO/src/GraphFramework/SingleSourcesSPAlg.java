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
public class SingleSourcesSPAlg extends ShortestPathAlgorithm {
   public void computeDijkstraAlg(Graph graph, Vertex source) {

       //HASHMAP TO STORE DISTANCES
       Map<Vertex, Integer> distances = new HashMap<>();

       //PRIORITY QUEUE FOR HANDLING VERTICES
       PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

       distances.put(source, 0);

       //INITIALIZE DISTANCES AND ADD VERTICES TO THE QUEUE
       for (Vertex vertex : graph.getVertex().values()) {
           if (vertex != source) {
               distances.put(vertex, Integer.MAX_VALUE);
           }
           queue.add(vertex);
       }

       //MAIN LOOP OF DIJKSTRA'S ALGORITHM
       while (!queue.isEmpty()) {
           Vertex u = queue.poll();

           //CHECK IF DISTANCE IS UNREACHABLE
           if (distances.get(u) == Integer.MAX_VALUE) {
               break;
           }

               for (Edge edge : u.getEdges()) {
                   Vertex v = edge.target;
                   int weight = edge.weight;

                   int distanceThroughU = distances.get(u) + weight;
                   if (distanceThroughU < distances.get(v)) {
                       queue.remove(v);
                       distances.put(v, distanceThroughU);
                       v.setParent(u);
                       queue.add(v);
                   }
               }
           }


       //PRINTING INFO
       System.out.println("The starting point location is " + (source.getLabel()));
       System.out.println("The routes from location " + source.getLabel() + " to the rest of the locations are:");

           for (Map.Entry<Vertex, Integer> entry : distances.entrySet()) {

               //SKPING PRINTING ROUTE TO VERTES ITSELF
               if (entry.getKey().getLabel().equals(source.getLabel())){
                   continue;
               }
               //PRINT UNREACHABLE ROUTES
               else if(entry.getValue() == Integer.MAX_VALUE){
                   System.out.println("There is no Route from loc. "+source.getLabel() +" to loc. "+entry.getKey());
               }
               //PRINT REACHABLE ROUTES
               else {
               System.out.println(entry.getKey().toString() + " --- route length: " + entry.getValue());
               }
           }
           System.out.println();

    }
}
