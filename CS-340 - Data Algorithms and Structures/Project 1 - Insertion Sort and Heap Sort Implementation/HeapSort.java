//Kolton Klette
//Professor John Matta
//CS-340 - Algorithms and Data Structures
//January 24th, 2021
public class HeapSort implements Sortable
{
        public int[] array;
        
        public HeapSort()
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
        
        public void maxHeapify(int[] array, int n, int i)
        {
            //Variable declaration
            int largest = i;
            int left = left(i);
            int right = right(i);
            //int length = array.length;
            int swap;
            
            //If Conditionals For Setting Up the Heap
            if(left < n && array[left] > array[largest])
            {
                largest = left;
            }
            
            if(right < n && array[right] > array[largest])
            {
                largest = right;
            }
            
            if(largest != i)
            {
                swap = array[i];
                array[i] = array[largest];
                array[largest] = swap;
                
                //Recursive Heapify
                maxHeapify(array, n, largest);
            }
        }
        
        public void sort()
        {
            //Variable Declaration
            int n = array.length;
            int temp;
            
            //Building the Heap via maxHeapify
            for(int i = n / 2 - 1; i >= 0; i--)
            {
                maxHeapify(array, n, i);
            }
            
            //Extracts Elements from the Heap
            for(int i = n - 1; i > 0 ; i--)
            {
                //Changes Root to end of heap
                temp = array[0];
                array[0] = array[i];
                array[i] = temp;
                
                //Calls maxHeapify on the heap
                maxHeapify(array, i, 0);
            }
        }
        
        public void printArray(int array[])
        {
            System.out.printf("Heap Sort: ");
            for(int i = 0; i < array.length; i++)
            {
                System.out.printf("%d, ", array[i]);
            }
            System.out.printf("\n");
        }
}