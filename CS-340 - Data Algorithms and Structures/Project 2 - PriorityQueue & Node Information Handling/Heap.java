//Kolton Klette
//Professor John Matta
//CS-340 - Data Structures and Algorithms
//February 21st, 2021

public class Heap
{
    protected Node[] heap;
    protected int heapsize;
    protected int[] location;
    
    public Heap()
    {
        
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
        int largest = i;
        int left = left(i);
        int right = right(i);
        
        //If Conditionals For Setting Up The Heap
        if(left < heapsize && heap[left].key > heap[largest].key)
        {
            largest = left;
        }
        
        if(right < heapsize && heap[right].key > heap[largest].key)
        {
            largest = right;
        }
        
        if(largest != i)
        {
            //exchange heap[i] with heap[largest]
            Node temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;
            
            //swap the location table as well
            location[heap[largest].ID] = largest;
            location[heap[i].ID] = i;
            
            //Recursive Heapify
            heapify(largest);
        }
    }
    
    public void buildheap()
    {
        for(int i = (heap.length / 2) - 1; i >= 0; i--)
        {
            heapify(i);
        }
    }
}
