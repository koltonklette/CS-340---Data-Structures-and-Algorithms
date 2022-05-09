/**Project 6
 * Name: Thomas Siganga
 * Collaborator: Ky Vinh Nguyen
 * Date: 4/24/2021
 */

public class Edge{
    public int u;
    public int v;
    public double weight;
    // u is the ID, the v is the ID it is going to and the weight is the edge between
    public Edge(int source, int v, double weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
    
     public int compareTo (Edge edge) 
     {
       //A way to compare weights     
       if(this.weight < edge.weight)
       {
           return 1;
       }
       else if(this.weight > edge.weight)
       {
           return -1;
       }
       return 0;    
     } 
}
