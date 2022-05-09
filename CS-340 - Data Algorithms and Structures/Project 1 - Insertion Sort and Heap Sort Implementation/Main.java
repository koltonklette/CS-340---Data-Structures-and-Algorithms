//Kolton Klette
//Professor John Matta
//CS-340 - Algorithms and Data Structures
//January 24th, 2021

//Imports
import java.util.Random;

public class Main
{   
    public static void main(String[] args)
    {
       //Variable Declaration
       double totalTime = 0.0;
       
       //Array Declaration
       int[] arrayOneRand = new int [100000];
       int[] arrayTwoRand = new int [200000];
       int[] arrayThreeRand = new int [300000];
       int[] arrayFourRand = new int [400000];
       int[] arrayFiveRand = new int [500000];
            
       int[] arrayOneSeq = new int [100000];
       int[] arrayTwoSeq = new int [200000];
       int[] arrayThreeSeq = new int [300000];
       int[] arrayFourSeq = new int [400000];
       int[] arrayFiveSeq = new int [500000];
       
       //InsertionSort/HeapSort Variable Creation
       InsertionSort inSortOne = new InsertionSort();
       InsertionSort inSortTwo = new InsertionSort();
       InsertionSort inSortThree = new InsertionSort();
       InsertionSort inSortFour = new InsertionSort();
       InsertionSort inSortFive = new InsertionSort();
                
       HeapSort heSortOne = new HeapSort();
       HeapSort heSortTwo = new HeapSort();
       HeapSort heSortThree = new HeapSort();
       HeapSort heSortFour = new HeapSort();
       HeapSort heSortFive = new HeapSort();
        
       //Fill Random Number Arrays with Random Numbers
       arrayOneRand = fillRandomNum(arrayOneRand, 100000);
       arrayTwoRand = fillRandomNum(arrayTwoRand, 200000);
       arrayThreeRand = fillRandomNum(arrayThreeRand, 300000);
       arrayFourRand = fillRandomNum(arrayFourRand, 400000);
       arrayFiveRand = fillRandomNum(arrayFiveRand, 500000);
        
       //Fill Sequential Number Arrays With Sequential Numbers
       arrayOneSeq = fillSequentialNum(arrayOneSeq, 100000);
       arrayTwoSeq = fillSequentialNum(arrayTwoSeq, 200000);
       arrayThreeSeq = fillSequentialNum(arrayThreeSeq, 300000);
       arrayFourSeq = fillSequentialNum(arrayFourSeq, 400000);
       arrayFiveSeq = fillSequentialNum(arrayFiveSeq, 500000);
        
       //Sorting Handling Block
        //Preliminary Setup
        System.out.printf("*****Time Statistics for InsertionSort and HeapSort*****\n\n");
       
       
       /*Trial One: InsertionSort + HeapSort on Random/Sequential Data*/
           System.out.printf("Trial One Stats:\n");
           System.out.printf("----------------\n");
            
           //Random Sort Setup
           inSortOne.array = arrayOneRand;
           heSortOne.array = arrayOneRand;
            
           //InsertionSort - Random
           totalTime = timeCalcInsert(inSortOne);
           System.out.printf("Insertion Sort (Random): %.2f\n", totalTime);
            
           //HeapSort - Random
           totalTime = timeCalcHeap(heSortOne);
           System.out.printf("HeapSort (Random): %.2f\n", totalTime);
            
           //Sequential Sort Setup
           inSortOne.array = arrayOneSeq;
           heSortOne.array = arrayOneSeq;
            
           //InsertionSort - Sequential
           totalTime = timeCalcInsert(inSortOne);
           System.out.printf("InsertionSort (Sequential): %.2f\n", totalTime);
            
           //HeapSort - Sequential
           totalTime = timeCalcHeap(heSortOne);
           System.out.printf("HeapSort (Sequential): %.2f\n\n", totalTime);
           
       /*Trial Two: InsertionSort + HeapSort on Random/Sequential Data*/
           System.out.printf("Trial Two Stats:\n");
           System.out.printf("----------------\n");
            
           //Random Sort Setup
           inSortTwo.array = arrayTwoRand;
           heSortTwo.array = arrayTwoRand;
            
           //InsertionSort - Random
           totalTime = timeCalcInsert(inSortTwo);
           System.out.printf("Insertion Sort (Random): %.2f\n", totalTime);
            
           //HeapSort - Random
           totalTime = timeCalcHeap(heSortTwo);
           System.out.printf("HeapSort (Random): %.2f\n", totalTime);
            
           //Sequential Sort Setup
           inSortTwo.array = arrayTwoSeq;
           heSortTwo.array = arrayTwoSeq;
            
           //InsertionSort - Sequential
           totalTime = timeCalcInsert(inSortTwo);
           System.out.printf("InsertionSort (Sequential): %.2f\n", totalTime);
            
           //HeapSort - Sequential
           totalTime = timeCalcHeap(heSortTwo);
           System.out.printf("HeapSort (Sequential): %.2f\n\n", totalTime);
           
        /*Trial Three: InsertionSort + HeapSort on Random/Sequential Data*/
           System.out.printf("Trial Three Stats:\n");
           System.out.printf("------------------\n");
            
           //Random Sort Setup
           inSortThree.array = arrayThreeRand;
           heSortThree.array = arrayThreeRand;
            
           //InsertionSort - Random
           totalTime = timeCalcInsert(inSortThree);
           System.out.printf("Insertion Sort (Random): %.2f\n", totalTime);
            
           //HeapSort - Random
           totalTime = timeCalcHeap(heSortThree);
           System.out.printf("HeapSort (Random): %.2f\n", totalTime);
            
           //Sequential Sort Setup
           inSortThree.array = arrayThreeSeq;
           heSortThree.array = arrayThreeSeq;
            
           //InsertionSort - Sequential
           totalTime = timeCalcInsert(inSortThree);
           System.out.printf("InsertionSort (Sequential): %.2f\n", totalTime);
            
           //HeapSort - Sequential
           totalTime = timeCalcHeap(heSortThree);
           System.out.printf("HeapSort (Sequential): %.2f\n\n", totalTime);
        
        /*Trial Four: InsertionSort + HeapSort on Random/Sequential Data*/
           System.out.printf("Trial Four Stats:\n");
           System.out.printf("-----------------\n");
            
           //Random Sort Setup
           inSortFour.array = arrayFourRand;
           heSortFour.array = arrayFourRand;
            
           //InsertionSort - Random
           totalTime = timeCalcInsert(inSortFour);
           System.out.printf("Insertion Sort (Random): %.2f\n", totalTime);
            
           //HeapSort - Random
           totalTime = timeCalcHeap(heSortFour);
           System.out.printf("HeapSort (Random): %.2f\n", totalTime);
            
           //Sequential Sort Setup
           inSortFour.array = arrayFourSeq;
           heSortFour.array = arrayFourSeq;
            
           //InsertionSort - Sequential
           totalTime = timeCalcInsert(inSortFour);
           System.out.printf("InsertionSort (Sequential): %.2f\n", totalTime);
            
           //HeapSort - Sequential
           totalTime = timeCalcHeap(heSortFour);
           System.out.printf("HeapSort (Sequential): %.2f\n\n", totalTime);
           
        /*Trial Five: InsertionSort + HeapSort on Random/Sequential Data*/
           System.out.printf("Trial Five Stats:\n");
           System.out.printf("-----------------\n");
            
           //Random Sort Setup
           inSortFive.array = arrayFiveRand;
           heSortFive.array = arrayFiveRand;
            
           //InsertionSort - Random
           totalTime = timeCalcInsert(inSortFive);
           System.out.printf("Insertion Sort (Random): %.2f\n", totalTime);
            
           //HeapSort - Random
           totalTime = timeCalcHeap(heSortFive);
           System.out.printf("HeapSort (Random): %.2f\n", totalTime);
            
           //Sequential Sort Setup
           inSortFive.array = arrayFiveSeq;
           heSortFive.array = arrayFiveSeq;
            
           //InsertionSort - Sequential
           totalTime = timeCalcInsert(inSortFive);
           System.out.printf("InsertionSort (Sequential): %.2f\n", totalTime);
            
           //HeapSort - Sequential
           totalTime = timeCalcHeap(heSortFive);
           System.out.printf("HeapSort (Sequential): %.2f\n\n", totalTime);
           
        //Ending Of List Print
           System.out.printf("***************************************************\n");
    }
    
    public static int[] fillRandomNum(int[] array, int arraySize)
    {
        int randNum = 0;
        for (int i = 0; i < arraySize; i++)
        {
            Random randGen = new Random();
            randNum = randGen.nextInt(50);
            array[i] = randNum;
        }
        return array;
    }
    
    public static int[] fillSequentialNum(int array[], int arraySize)
    {
        int temp = 1;
        for (int i = 0; i < arraySize; i++)
        {
            array[i] = temp;
            temp = temp + 1;
        }
        return array;
    }
    
    public static double timeCalcInsert(InsertionSort inSort)
    {
        //Variable Declaration
        double totalTime = 0.0;
        double timeStart = 0.0;
        double timeFinish = 0.0;
        
        //Time Calculation + Sort
        timeStart = System.currentTimeMillis();
        inSort.sort();
        timeFinish = System.currentTimeMillis();
        
        totalTime = timeFinish - timeStart;
        
        return totalTime;
    }
    
    public static double timeCalcHeap(HeapSort heSort)
    {
        //Variable Declaration
        double totalTime = 0.0;
        double timeStart = 0.0;
        double timeFinish = 0.0;
        
        //Time Calculation + Sort
        timeStart = System.currentTimeMillis();
        heSort.sort();
        timeFinish = System.currentTimeMillis();
        
        totalTime = timeFinish - timeStart;
        
        return totalTime;
    }
    
    //Test Function: Used to Confirm Validity of Sorting Methods
    public static void printArray(int array[])
    {
        System.out.printf("Unsorted: ");
        for(int i = 0; i < array.length; i++)
        {
            System.out.printf("%d, ", array[i]);
        }
        System.out.printf("\n");
    }
}