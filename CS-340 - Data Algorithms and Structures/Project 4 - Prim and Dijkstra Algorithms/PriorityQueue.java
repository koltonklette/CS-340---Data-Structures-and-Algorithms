//Kolton Klette
//Professor John Matta
//CS-340 - Data Structures and Algorithms
//March 31st, 2021

import java.util.*;
import java.io.*;

public class PriorityQueue
{
    protected Node[] priorityQueueArray;
    protected int heapsize;
    protected int[] location;
    
    public PriorityQueue(int maxsize)
    {
        heapsize = 0;
        priorityQueueArray = new Node[maxsize];
        location = new int[maxsize];
    }
    
    public int parent(int i)
    {
        return (i - 1) / 2;
    }
    
    public int left(int i)
    {
        int temp = 2 * i + 1;
        return temp;
    }
    
    public int right(int i)
    {
        int temp = 2 * i + 2;
        return temp;
    }
    
    public void heapify(int i)
    {
        //Variable Declaration
        int smallest = i;
        int left = left(i);
        int right = right(i);
        
        //If Conditionals For Setting Up The Heap
        if( (left <= heapsize) && (priorityQueueArray[left].compareTo(priorityQueueArray[i]) > 0) )
        {
            smallest = left;
        }
        
        if( (right <= heapsize) && (priorityQueueArray[right].compareTo(priorityQueueArray[smallest]) > 0) )
        {
            smallest = right;
        }
        
        if(smallest != i)
        {
            //exchange heap[i] with heap[smallest]
            Node temp = priorityQueueArray[i];
            priorityQueueArray[i] = priorityQueueArray[smallest];
            priorityQueueArray[smallest] = temp;
            
            //swap the location table as well
            location[priorityQueueArray[smallest].id] = smallest;
            location[priorityQueueArray[i].id] = i;
            
            //Recursive Heapify
            heapify(smallest);
        }
    }
    
    public void buildheap()
    {
        for(int i = (priorityQueueArray.length / 2) - 1; i >= 0; i--)
        {
            heapify(i);
        }
    }
    
    void insert(Node newNode)
    {
        priorityQueueArray[heapsize] = newNode;
        location[heapsize] = newNode.id;
        heapsize++;
        changeKey(newNode.id, newNode.key);
    }
    
    public Node extractMin()
    {
        if(heapsize < 1)
        {
            System.out.printf("Heap Underflow\n");
            System.exit(0);
        }
        
        Node temp = priorityQueueArray[0];
        priorityQueueArray[0] = priorityQueueArray[heapsize - 1];
        heapsize--;
        heapify(0);
        
        return temp;
    }
    
    public boolean isEmpty()
    {
        boolean empty;
        if (heapsize == 0)
        {
            empty = true;
        }
        else
        {
            empty = false;
        }
        return empty;
    }
    
    /*Acts as decreaseKey method needed for both algorithms. Retains original name for clarity of readability*/
    public void changeKey(int i, double k)
    {
        int tempLocation = location[i];
        
        priorityQueueArray[tempLocation].key = k;
        while(tempLocation > 0 && priorityQueueArray[tempLocation].compareTo(priorityQueueArray[parent(tempLocation)]) > 0)
        {
             //Swap Control
             Node swap = priorityQueueArray[parent(tempLocation)];
             priorityQueueArray[parent(tempLocation)] = priorityQueueArray[tempLocation];
             priorityQueueArray[tempLocation] = swap;
                
             //Location Table Control
             location[priorityQueueArray[parent(tempLocation)].id] = parent(tempLocation);
             location[priorityQueueArray[tempLocation].id] = tempLocation;
             tempLocation = parent(tempLocation);
        }
        
    }
}
