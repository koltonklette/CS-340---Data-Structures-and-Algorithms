/**Project 6
 * Name: Thomas Siganga
 * Collaborator: Ky Vinh Nguyen
 * Date: 4/24/2021
 */
import java.util.ArrayList;

public class Graph {
    public ArrayList<Node> graph = new ArrayList<Node>();
    
    public Graph() {
       
    
    }
    //Like edge but for Vertex, just here for easier readablity
    public void addVertex(int ID, int parent, double key)
    {
        graph.add(new Node(ID, parent, key));
    }
    //adds edge
    public void addEdge(int u, int v, double weight)
    {
        graph.get(u).edges.add(new Edge(u, v, weight));
    }
   
   
    public void Approximation(Graph prim, ArrayList<Node> verticeList, int start)
    {
        double weight = 0;
        int counter = 0;
        int lastNode = 0;
        for(Node node: verticeList)
        {
            System.out.print(node.ID + " ");
            for(Edge edge: node.edges)
            {
                
                        if((verticeList.size() > counter+1) && edge.v == (verticeList.get(counter+1).ID))
                        {
                            weight += edge.weight;
                        }
            }
            //updates the new last node
            lastNode = node.ID;
            counter++;
        }
        double finishTour = verticeList.get(start).edges.get(lastNode-1).weight;
        weight += finishTour;
        System.out.println(weight);

    }
    
   
    //Lambda function for Prim or Djikstra
   public Graph prim(int r)
    {   
        //new graph for storing prim results(Since we already have a graph for reading the file)
        Graph prim = new Graph(); 
        PriorityQueue pq = new PriorityQueue(graph.size()); 
        ArrayList<Node> TList = new ArrayList<Node>();
        //Basically adds Nodes to the new graph and inserts these nodes into the priority queue
        for (Node initialNode : graph) 
        { 
            //uses values that were intialized from main for each iteration(Ex. parent = -1. key = infinity)
            Node insertNode = new Node(initialNode.ID, initialNode.parent, initialNode.key);
            prim.graph.add(insertNode);
        } 
        //I will become Professor Matta
        for(int JohnMatta = 0; JohnMatta < graph.size(); JohnMatta++)
        {
            pq.insert(graph.get(JohnMatta));            
        }
        // Every Node without its Edges are added to Prim's graph because they will all be visited.
        //brings up 0 to the front of the queue
        pq.changeKey(r, 0.0); 
        //TList.add(new Node(r, 0, 0));
        while (!pq.isEmpty()) {                                                         
            Node nodeCheck = pq.extract(); 
            TList.add(nodeCheck);
            // creates an undirected edge when the node has a parent from the extracted node
            if (nodeCheck.parent != -1)                                                                  
            {
                
                
                prim.addEdge(nodeCheck.parent, nodeCheck.ID, nodeCheck.key);
                prim.addEdge(nodeCheck.ID, nodeCheck.parent, nodeCheck.key);
            }
            
            //Goes through each node connected to the current vertex that it is on
            for (Edge edge: nodeCheck.edges)      
            {
                //gets the edge that is being traveled to in this instance
                Node traveledNode = graph.get(edge.v);                                
           
                
                /*Checks if the node that it is traveling to is in the priority queue along with also checking if that Node's current key is greater than the weight
                /updates necessary values if the edge weight is less than the key.
                */
                if (traveledNode.compareTo(pq.priorityQueueArray[pq.location[traveledNode.ID]]) == 0 && edge.weight < traveledNode.key)
                {
                    //using location table to get the ID for the node being traveled to and sets it to the extracted node's ID(updates parent)
                    pq.priorityQueueArray[pq.location[traveledNode.ID]].parent = nodeCheck.ID;                      
                    //performs changekey which changes the node's key to the extracted node's weight
                    pq.changeKey(traveledNode.ID, edge.weight);                                 
                }
            }
        }
        Approximation(prim, TList, r);
       
        return prim;
    }
    
}




    
//interface for labmda function

