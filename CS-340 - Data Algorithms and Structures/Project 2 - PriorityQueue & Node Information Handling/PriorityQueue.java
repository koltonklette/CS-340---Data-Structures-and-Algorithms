//Kolton Klette
//Professor John Matta
//CS-340 - Data Structures and Algorithms
//February 21st, 2021

public class PriorityQueue extends Heap
{
    public PriorityQueue(int maxsize)
    {
       heap = new Node[maxsize];
       location = new int[maxsize];
    }
    
    public void insert(Node newNode)
    {
        heap[heapsize] = newNode; //set to negative infinity in pseudo-code
        location[heapsize] = newNode.ID;
        heapsize++;
        changeKey(newNode.ID, newNode.key);
    }
    
    public Node peek()
    {
        return heap[0]; //return top of the created heap; goes unused
    }
    
    public Node extract()
    {
        if(heapsize < 1)
        {
            System.out.printf("Heap Underflow\n");
            System.exit(0);
        }
        
        Node max = heap[0];
        heap[0] = heap[heapsize - 1];
        heapsize--;
        heapify(0);
        
        return max;
    }
    
    public void changeKey(int i, int k)
    {
        if(k < heap[i].key)
        {
            System.out.printf("New key is smaller than current key\n");
            System.exit(0);
        }
        heap[i].key = k;
        while(i > 0 && heap[parent(i)].key < heap[i].key)
        {
            Node swap = heap[parent(i)];
            heap[parent(i)] = heap[i];
            heap[i] = swap;
            i = parent(i);
        }
    }
}
