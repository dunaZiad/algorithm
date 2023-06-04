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
import java.util.Map;
import java.util.Scanner;
public class ShortestPathAlgorithm {
    public void computeDijkstraAlg(Graph graph, int choice){

        //INITIALIZING SOURCE POINT
        Vertex startPoint;
        switch (choice){
            //CASE 1: USING ALGORITHM FOR ONE POINT
            case 1 :
                System.out.print("Please Enter startPoint: ");
                Scanner input=new Scanner(System.in);
                String startPointLabel= input.next();
                SingleSourcesSPAlg pathsOfaSinglePoint=new SingleSourcesSPAlg();
                startPoint=graph.vertex.get(startPointLabel);
                pathsOfaSinglePoint.computeDijkstraAlg(graph, startPoint);
                break;
            //CASE 2: USING ALGORITHM FOR ALL POINTS
            case 2 :
                DBAllSourceSPAlg pathsOfAllPointsOfAllPoints=new DBAllSourceSPAlg();
                pathsOfAllPointsOfAllPoints.computeDijkstraBasedSPAlg(graph);
                break;
        }

    }
}
