/**Project 6
 * Name: Thomas Siganga
 * Collaborator: Ky Vinh Nguyen
 * Date: 4/24/2021
 */

import java.util.*;
import java.io.*;


public class Main {
    public static double prevGraph = Double.POSITIVE_INFINITY;
    public static int count = 1;
    public static double weight = 0;
    public static Scanner readInput = new Scanner(System.in);
    public static ArrayList<Double> weightArr = new ArrayList<Double>();
    public static double val = 0;
    public static String finalPath;
    public static int lastElement = 0;
    public static int start = 0;
    public static void main(String[] args) {  
        //Reads in the graph entire graph for Prim and djikstra to be performed on
        
        Graph genGraph = readGraph("graph6.txt");
        
        
        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(start);
      
        boolean[] visited = new boolean[genGraph.graph.size()];        
        visited[start] = true;
        //printGraph(genGraph);
        System.out.println(java.util.Calendar.getInstance().getTime());
        BrutePaths(genGraph, start, visited, path);
        System.out.printf("%s %.2f\n", finalPath, prevGraph);
        System.out.println(java.util.Calendar.getInstance().getTime() + "\n");
        //sorts from greatest to least
        //System.out.println(java.util.Calendar.getInstance().getTime());
        int firstVal = 0;
        //System.out.println("Brute Force Path: " + syncPathWeight.get(firstVal).nodePath + "\nPath Weight " + syncPathWeight.get(firstVal).weight);
        System.out.println(java.util.Calendar.getInstance().getTime());
        genGraph.prim(0);
        System.out.println(java.util.Calendar.getInstance().getTime());
        //printGraph( genGraph.prim(0));
     
        // make a preorder method that will be conducted on the prim mst
        
        
        /*System.out.println("Specify Graph Type: ");
        String input = readInput.next();
        System.out.print("\nSource vertex for " +  input + ": ");
        int root = readInput.nextInt();
        //only creates the prints graph if either of these 
        if(input.equals("Prim"))
        {
            
        } else if(input.equals("Dijkstra"))
        {
            //printGraph("dijkstraSolution.txt", genGraph.PrimOrDijkstra(input, root));
            
        }
               
        
        System.out.println("\n" + input +" file created");*/
       
     
    }
    public static void minimumGraph(Graph graphG, double weight, String tourPath, ArrayList<Integer> path)
    {
        //prevGraph += graphG.graph.get(start).edges.get(path.get(path.size() - 1)-1).weight;
        //weight += graphG.graph.get(start).edges.get(path.get(path.size() - 1)-1).weight;
        if(prevGraph >= weight)
        {
             
            prevGraph = weight;
            finalPath = tourPath;
        }
        weight = 0;
        
        
    }
    public static void BrutePaths(Graph genGraph, int v, boolean[] visited, ArrayList<Integer> path)
    {
         int indexPoint = v;
         if (path.size() == genGraph.graph.size())
         {
             // set the path to an arrayList
             // set the weight too for this arrayList of objects(We dont have a specific name for it yet)
                
                String fixedPath = Arrays.toString(path.toArray()).replace("[", "").replace("]", "");
                // System.out.println(path.get(genGraph.graph.size()-1).weight);
               // syncPathWeight.add(new Tour(fixedPath, weight));  
              
                 
                double tempWeight = weight + genGraph.graph.get(start).edges.get(path.get(path.size() - 1)-1).weight;
       
               
                minimumGraph(genGraph, tempWeight, fixedPath, path);
                
                
               
              
                //thinking of making an arraylist to hold each of these paths. It would also hold the weights since this is right before they reset making something 
                //similar to project 5;
                
                return;
         }
             
        for(Edge edge: genGraph.graph.get(v).edges)
        {
           
            if(!visited[edge.v])
            {
                visited[edge.v] = true;
            
                weight += edge.weight;
                
                path.add(edge.v);
                weightArr.add(edge.weight);
                
                BrutePaths(genGraph, edge.v, visited, path);
                visited[edge.v] = false;
                weight -= weightArr.get(weightArr.size()-1);
                weightArr.remove(weightArr.size() - 1);
                path.remove(path.size() - 1);
               
            }
         
        } 
    }
         
    
    public static Graph readGraph(String fileName){
        Graph graph = new Graph();
        //set initial values for Nodes in solution graph
        String firstElement;
        int vertex;
        int ID = 0;
        int parent = -1;
        String line;
        double key = Double.POSITIVE_INFINITY; 
        int travelNode;
        double weight;
        boolean visited = false;
        try {
            File input = new File(fileName);                            // Initialize the input File.
            Scanner scan = new Scanner(input);                    // Initialize the Scanner for reading in the text document.
            //scans in whole text file for graph
            while (scan.hasNextLine()) 
            {
                // Creates a new node for each new line in the file.
                graph.addVertex(ID, parent, key);
                firstElement = scan.next();
                
                vertex = Integer.parseInt(firstElement);
                // Reads in the file line by line.
                line = scan.nextLine(); 
                //makes a scanner for each line
                Scanner lineScan = new Scanner(line);
            
                while(lineScan.hasNext())
                {
                    
                    travelNode = Integer.parseInt(lineScan.next());

                    weight = Double.parseDouble(lineScan.next());
                    graph.addEdge(ID, travelNode, weight);
                    
                }
                lineScan.close();       
                ID++;
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Could Not Be Found");
        }
        return graph;
    }
    
    public static void printGraph(Graph graphOut)
    {
        //try {
            //File outputFile = new File(fileName);
            //outputFile.createNewFile();
            //FileWriter graphFile = new FileWriter(fileName);
            //graphFile.DijOrPrim(source, (a,b)->a);
            for(Node node: graphOut.graph)
            {
                System.out.print(node.ID + " ");
                //graphFile.write(node.ID + " ");  
                for(Edge edge: node.edges)
                {  
                    System.out.print(edge.v + " " + edge.weight + " ");
                    //graphFile.write(edge.v + " " + edge.weight + " ");    
                }
                System.out.println();
                //graphFile.write("\n");                
            }
  
            //graphFile.close();
            //} catch (IOException e) {
            //System.out.println("Error Occurred while creating the file");
            //e.printStackTrace();
          //}
    }


} // End Main Class.



