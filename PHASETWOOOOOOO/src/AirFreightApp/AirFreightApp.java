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
import java.io.*;
import java.util.*;
import GraphFramework.*;
public class AirFreightApp {
   public static void main(String[] args) throws FileNotFoundException {

      //READING DATA FROM INPUTCICSDATA.TXT FILE
      File readFile = new File("input.txt");

      //CHICK IF THE FILE EXEST OR NOT
      if (!readFile.exists()) {
         System.out.println("Input file : " + readFile + ", does not exist.");
         System.exit(0);
      }

      //CREATE WRITING FILE
      File outputFile = new File("Output.txt");

      //CREATING PRINTWRITER OPJECT TO WRITE DATA IN FILE
      PrintWriter WriteFile = new PrintWriter(outputFile);

      //SCANNER FOR READ DATA FROM FILE
      Scanner input = new Scanner(readFile);

      //PRINT HEADER
      System.out.println("--------------- Read Data From File ---------------");

      //---------------------------Requierment |1|----------------------------

      //CREATE AFRouteMap OBJECT
      AFRouteMap graph = new AFRouteMap();

      //CALL readGraphFromFile METHOD
      graph.readGraphFromFile(graph,readFile);
      System.out.println("");

      //---------------------------Requierment |2|----------------------------

      Scanner input2=new Scanner(System.in);

      int n = 0;
      int m = 0;

      System.out.println("\n-----------------------------------------------------");
      System.out.println("> Available cases (where n represents # of vertices and m represents # of edges ) : ");
      System.out.println("1. n = 2,000 - m = 10,000");
      System.out.println("2. n = 3,000 - m = 15,000");
      System.out.println("3. n = 4,000 - m = 20,000");
      System.out.println("4. n = 5,000 - m = 25,000");
      System.out.println("5. n = 6,000 - m = 30,000");
      System.out.print("Enter a Case to Test: ");
      int Choose = input2.nextInt();

      //FOR WRONG INPUT
      while (Choose < 1 || Choose > 5) {
         System.out.println("Invalid input, Please Chose Again");
         System.out.print("> Enter a Case to Test: ");
         Choose = input2.nextInt();
      }

      //Switch to set n and m based on the user choice case
      switch (Choose) {
         case 1: {
            n = 2000;
            m = 10000;
            break;
         }

         case 2: {
            n = 3000;
            m = 15000;
            break;
         }

         case 3: {
            n = 4000;
            m = 20000;
            break;
         }

         case 4: {
            n = 5000;
            m = 25000;
            break;
         }

         case 5: {
            n = 6000;
            m = 30000;
            break;
         }
      }
      AFRouteMap graph1 = new AFRouteMap(n,m);
      graph1.makeGraph(graph1,n, m);
   }
}
