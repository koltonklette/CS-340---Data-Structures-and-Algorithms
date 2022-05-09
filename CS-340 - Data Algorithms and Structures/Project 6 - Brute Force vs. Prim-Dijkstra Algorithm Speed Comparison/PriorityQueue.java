/**Project 6
 * Name: Thomas Siganga
 * Collaborator: Ky Vinh Nguyen
 * Date: 4/24/2021
 */


public class PriorityQueue implements dijkstraOrPrim {
    Node[] priorityQueueArray;
    int heapsize;
    int[] location;
    public PriorityQueue(int maxsize) {
        heapsize = 0;
        priorityQueueArray = new Node[maxsize];
        location = new int[maxsize];
    }
    public int parent(int i) {
        return (i-1) / 2;
    }
    public int left(int i) {
        return (2*i) + 1;
    }
    public int right(int i) {
        return (2*i) + 2;
    }
    public void heapify(int i) {
        int middle = i;
        int left = left(i);
        int right = right(i);
        
        
        if (left < heapsize && priorityQueueArray[left].compareTo(priorityQueueArray[middle]) > 0) {
            middle = left;
        }

        if (right < heapsize && priorityQueueArray[right].compareTo(priorityQueueArray[middle]) > 0) {
            middle = right;
        }

        if (middle != i) 
        {
            // exchange heap[i] with heap[significant]
            Node temp = priorityQueueArray[i];
            priorityQueueArray[i] = priorityQueueArray[middle];
            priorityQueueArray[middle] = temp;
            // swap the location table as well
            location[priorityQueueArray[middle].ID] = middle;
            location[priorityQueueArray[i].ID] = i;
            heapify(middle);
        }
    }

    public void buildheap() 
    {
        for(int i = heapsize / 2; i >= 0; i--)
        {
            heapify(i);
        }
    }
    //first element in the pq array
    public Node peek() 
    {
           return priorityQueueArray[0];
    }
    //Check if graph is empty
    public boolean isEmpty() 
    {
        if (heapsize == 0) 
        {
            return true;
        } else {
            return false;
        }
    }
    /*Adds a Node to the heap array every time this function is called
     / and also adds the IDs to the location table
     */
    public void insert(Node newNode) 
    {
        priorityQueueArray[heapsize] = newNode;
        location[heapsize] = newNode.ID;
        changeKey(heapsize, priorityQueueArray[heapsize].key);
        heapsize++;
    }

    public Node extract() 
    {
        //error checks the key to see if the heap is empty
        if (heapsize < 1) 
        {
            System.err.println("heap underflow");
            System.exit(1);
        }
        //assigns the max variable to the first Node then assigns the end of the heap to the beginning
        Node min = peek();
        priorityQueueArray[0] = priorityQueueArray[heapsize-1];
        heapsize--;
        heapify(0);
        return min;
    }

  
    public void changeKey(int nodeID, double key) 
    {
            int l = location[nodeID]; //stores the location
            //sets the key for the index of the array
            priorityQueueArray[l].key = key;
            //swaps the key up the heap to the right position
            while (l > 0 && priorityQueueArray[l].compareTo(priorityQueueArray[parent(l)]) > 0) 
            {
                Node temp = priorityQueueArray[l];
                priorityQueueArray[l] = priorityQueueArray[parent(l)];
                priorityQueueArray[parent(l)] = temp; 
                    
                location[priorityQueueArray[parent(l)].ID] = parent(l);
                location[priorityQueueArray[l].ID] = l;
                l = parent(l);
            
                
            }
        }
}
