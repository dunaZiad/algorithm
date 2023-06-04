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
public class DBAllSourceSPAlg extends ShortestPathAlgorithm {
    public void computeDijkstraBasedSPAlg(Graph graph){

        //INITIALIZING STARTING POINT
        Vertex startPoint=graph.vertex.values().iterator().next();

        //CREATING SingleSourcesSPAlg OBJECT TO CALL ALGORITHM
        SingleSourcesSPAlg shortestPaths = new SingleSourcesSPAlg();

        //LOOP TO GO THROUGH EVERYSINGLE VERTEX
        for (Vertex source : graph.getVertex().values()) {
            shortestPaths.computeDijkstraAlg(graph,source);
        }
    }


}
