//Kolton Klette
//Professor John Matta
//CS-340 - Data Structures and Algorithms
//March 31st, 2021

import java.util.*;
import java.io.*;

public class Edge
{
    public int u = -1;
    public int v = -1;
    public double weight = -1.0;
    
    public Edge(int u, int v, double value)
    {
        this.u = u;
        this.v = v;
        weight = value;
    }
}
