//Kolton Klette
//Professor John Matta
//CS-340 - Algorithms and Data Structures
//January 24th, 2021
public class InsertionSort implements Sortable
{
        public int[] array;
        
        public InsertionSort()
        {
            
        }
        
        public void sort()
        {
            int n = array.length;
            for (int i = 1; i < n; ++i)
            {
                int key = array[i];
                int j = i - 1;
                while (j >= 0 && array[j] > key)
                {
                    array[j + 1] = array[j];
                    j = j - 1;
                }
                array[j + 1] = key;
            }
        }
        
        public void printArray(int array[])
        {
            System.out.printf("Insertion Sort: ");
            for(int i = 0; i < array.length; i++)
            {
                System.out.printf("%d ", array[i]);
            }
            System.out.printf("\n");
        }
}   