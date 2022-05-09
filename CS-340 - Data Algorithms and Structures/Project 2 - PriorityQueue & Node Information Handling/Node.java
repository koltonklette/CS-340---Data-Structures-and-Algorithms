//Kolton Klette
//Professor John Matta
//CS-340 - Data Structures and Algorithms
//February 21st, 2021

public class Node implements Comparable<Node>
{
    public int ID;
    public int key;
    
    public Node(int ID, int key)
    {
        this.ID = ID;
        this.key = key;
    }
    
    @Override
    public int compareTo (Node node2)
    {
       if(ID > node2.ID)
       {
           return 1;
       }
       else if(node2.ID < ID)
       {
           return -1;
       }
       return 0; 
    }
}
