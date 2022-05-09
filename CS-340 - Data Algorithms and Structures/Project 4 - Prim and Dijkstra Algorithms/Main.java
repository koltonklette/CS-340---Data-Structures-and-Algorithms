//Kolton Klette
//Professor John Matta
//CS-340 - Data Structures and Algorithms
//March 31st, 2021

import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] arg)
    {
        //Variable Declaration
        int u;                      //saves the initial starting vertex
        int v;                      //saves the connecting vertex that establishes an edge
        double weight = 0.0;        //saves the weight of the edge provided by input 
        String startVertex = "";    //saves intial id of the node (the starting vertex on the line)
        String temp = "";           //starts reading the looped information in the input containing edges of the startVertex
        Graph graph = new Graph();
        
        //Reading From File Control Block
        System.out.printf("File Input Read Check:\n");
        try
        {
            FileReader input = new FileReader("input.txt");
            Scanner scanner = new Scanner(input);
            while(scanner.hasNextLine())
            {
                startVertex = scanner.next();
                u = Integer.parseInt(startVertex);
                System.out.printf("%d ", u);
                
                //Node tempNode = new Node(u, 999, -1);
                graph.graph.add(new Node(u, Double.POSITIVE_INFINITY, -1));
                
                temp = scanner.nextLine();
                Scanner lineScan = new Scanner(temp);
                while(lineScan.hasNext())
                {
                    v = Integer.parseInt(lineScan.next());
                    weight = Double.parseDouble(lineScan.next());
                    
                    //Adding Edges to Appropriate ArrayList structures
                    graph.addEdge(u, v, weight);
                    
                    System.out.printf("%d %.2f ", v, weight);
                }
                System.out.printf("\n");
                lineScan.close();
            }
            System.out.printf("\n");
            scanner.close();
        }
        catch (Exception e)
        {
            System.out.printf("Ooga booga.\n");
            e.printStackTrace();
        }
        
        //Prim/Dijkstra Test
        System.out.printf("Please select the source node to be used by Prim's or Dijkstra's algorithm: ");
        Scanner cin = new Scanner(System.in);
        int userIn = cin.nextInt();
        System.out.printf("\n");
        
        //Calls on Lambda-Driven Expression To Determine Graph
        graph = graph.primDijkstra(userIn, graph);
        
        //Print/File Creation Control Block
        System.out.printf("Desired Algorithm Output:\n");
            printGraph(graph);
            createGraph(graph, "primDijkstraout.txt");
        
        //End Confirmation
        System.out.printf("Test print-outs are available above; required output text files have been generated.\n");
    }
    
    public static void printGraph(Graph graphToPrint)
    {
        for (int i = 0; i < graphToPrint.graph.size(); i++)
        {
            System.out.printf("%d ", graphToPrint.graph.get(i).id);
            for(int j = 0; j < graphToPrint.graph.get(i).edges.size(); j++)
            {
                System.out.printf("%d ", graphToPrint.graph.get(i).edges.get(j).v);
                System.out.printf("%.2f ", graphToPrint.graph.get(i).edges.get(j).weight);
            }
            System.out.printf("\n");
        }
        System.out.printf("\n");
    }
    
    public static void createGraph(Graph graphToPrint, String fileName)
    {
        try
        {
            //Variable Declaration
            File output = new File(fileName);
            FileWriter fout = new FileWriter(fileName);
            
            output.createNewFile();
            
            for (int i = 0; i < graphToPrint.graph.size(); i++)
            {
                fout.write(graphToPrint.graph.get(i).id + " ");
                for(int j = 0; j < graphToPrint.graph.get(i).edges.size(); j++)
                {
                    fout.write(graphToPrint.graph.get(i).edges.get(j).v + " ");
                    fout.write(graphToPrint.graph.get(i).edges.get(j).weight + " ");
                }
                fout.write("\n");
            }
            fout.write("\n");
            fout.close();
        }
        catch (Exception e)
        {
            System.out.printf("Dinger donger, your code is wronger.\n");
            System.exit(0);
        }
        
    }
    
}
