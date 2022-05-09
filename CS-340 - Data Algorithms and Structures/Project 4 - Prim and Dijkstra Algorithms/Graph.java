//Kolton Klette
//Professor John Matta
//CS-340 - Data Structures and Algorithms
//March 31st, 2021

import java.util.*;
import java.io.*;

public class Graph
{
    public ArrayList<Node> graph = new ArrayList<Node>();
    Algorithm primOrDijkstra = (String indicator, int source) ->
    {
        //Variable Declaration
        PriorityQueue q = new PriorityQueue(graph.size());
        Graph tempGraph = new Graph();
        double tempVal = 0.0;
        
        //Prepare passed in Prim Graph + Related PriorityQueue
        for(int i = 0; i < graph.size(); i++)
        {
            q.insert(graph.get(i));
        }
        for(Node t : graph)
        {
            Node info = new Node(t.id, t.key, t.parent);
            tempGraph.graph.add(info);
        }
        
        //Decrease Key
        q.changeKey(source, 0.0);
        
        while(!q.isEmpty())
        {
            Node temp = q.extractMin();
            
            if(temp.parent != -1)
            {
                tempGraph.addEdge(temp.parent, temp.id, temp.key);
                tempGraph.addEdge(temp.id, temp.parent, temp.key);
            }
            
            for(int i = 0; i < temp.edges.size(); i++)
            {
                tempVal = (indicator.equals("P") ? temp.edges.get(i).weight : temp.edges.get(i).weight + temp.key);
                Node tempTwo = graph.get(temp.edges.get(i).v);
                
                if(tempTwo.compareTo(q.priorityQueueArray[q.location[tempTwo.id]]) == 0 && tempVal < tempTwo.key)
                {
                    q.priorityQueueArray[q.location[tempTwo.id]].parent = temp.id;
                    q.changeKey(tempTwo.id, tempVal);
                }
            }
        }
        
        return tempGraph;
    };
    
    public void addEdge (int u, int v, double weight)
    {
        Edge tempEdge = new Edge(u, v, weight);
        graph.get(u).edges.add(tempEdge);
    }
    
    public Graph primDijkstra(int input, Graph temp)
    {
        //Variable Declaration
        Scanner cin = new Scanner(System.in);
        
        System.out.printf("Would you like to perform Prim's Algorithm or Dijkstra's Algorithm on the provided information?\n");
        System.out.printf("Please provide 'P' for Prim's Algorithm or 'D' for Dijkstra's Algorithm.\n");
        String userIn = cin.next();
        
        if(userIn.equals("P") || userIn.equals("D"))
        {
            temp = primOrDijkstra.algorithm(userIn, input);
            System.out.printf("\n");
        }
        else
        {
            System.out.printf("Please restart the program and provide the correct type of character.\n");
            System.exit(0);
        }
        
        return temp;
    }
    
    interface Algorithm
    {
        Graph algorithm(String indicator, int info);
    }
}
