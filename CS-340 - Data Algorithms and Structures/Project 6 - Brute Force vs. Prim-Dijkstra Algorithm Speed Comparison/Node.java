/**Project 6
 * Name: Thomas Siganga
 * Collaborator: Ky Vinh Nguyen
 * Date: 4/24/2021
 */

import java.util.ArrayList;

public class Node implements Comparable<Node> {
    public int ID;
    public ArrayList<Edge> edges = new ArrayList<Edge>();
    public double key;
    public int parent;
    public double totalWeight;
    //ID is what node it is in the graph, parent is where it came from when executing an algorithm, key is the distance between
    public Node(int ID, int parent, double key) {
        this.ID = ID;
        this.key = key;
        this.parent = parent;
        this.totalWeight = totalWeight;
      
    }
    public void addWeight(double weight)
    {
        totalWeight += weight;
        
    }

    @Override
    public int compareTo(Node node2) {
        if(this.key < node2.key)
       {
           return 1;
       }
       else if(this.key > node2.key)
       {
           return -1;
       }
       return 0;
    }
}
