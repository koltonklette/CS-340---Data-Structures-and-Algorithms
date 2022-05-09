//Kolton Klette
//Professor John Matta
//CS-340 - Data Structures and Algorithms
//March 31st, 2021

import java.util.*;
import java.io.*;

public class Node implements Comparable<Node> 
{
    int id = 0;
    ArrayList<Edge> edges = new ArrayList<Edge>();
    double key = 0.0;
    int parent = 0;
    
    public Node(int id, double key, int parent)
    {
        this.id = id;
        this.key = key;
        this.parent = parent;
    }
    
    @Override
    public int compareTo (Node n)
    {
       if(this.key - n.key > 0)
       {
           return -1;
       }
       else if(this.key - n.key < 0)
       {
           return 1;
       }
       return 0;
    }
}
