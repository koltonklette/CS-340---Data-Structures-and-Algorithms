//Kolton Klette
//Professor John Matta
//CS-340 - Algorithms and Data Structure
//March 10th, 2021

import java.util.Scanner;
import java.io.FileReader;
import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String []arg)
    {
        //Variable Declaration
            String fileName = "PrideAndPrejudice.txt";
            String temp = "";                               //keeps track of gradual words added into the hashTable
            int hashValue = 0;                              //keeps track of the hash value generated via the .hashCode()
            
            //Hash Table Creation
            Hash hashTableOne = new Hash(500);
            Hash hashTableTwo = new Hash(1000);
            Hash hashTableThree = new Hash(2000);
            Hash hashTableFour = new Hash(5000);
            Hash hashTableFive = new Hash(10000);
            
        //Preliminary File Setup
            try
            {
                //FileReader Creation
                FileReader fileInput = new FileReader(fileName);
                FileReader fileInputTwo = new FileReader(fileName);
                FileReader fileInputThree = new FileReader(fileName);
                FileReader fileInputFour = new FileReader(fileName);
                FileReader fileInputFive = new FileReader(fileName);
                
                //Scanner Object Creation
                Scanner scanFile = new Scanner(fileInput);
                Scanner scanFileTwo = new Scanner(fileInputTwo);
                Scanner scanFileThree = new Scanner(fileInputThree);
                Scanner scanFileFour = new Scanner(fileInputFour);
                Scanner scanFileFive = new Scanner(fileInputFive);
                
                //Fill Tables With Information From The File
                hashTableOne = insertControl(fileInput, scanFile, hashTableOne, temp, hashValue);
                hashTableTwo = insertControl(fileInputTwo, scanFileTwo, hashTableTwo, temp, hashValue);
                hashTableThree = insertControl(fileInputThree, scanFileThree, hashTableThree, temp, hashValue);
                hashTableFour = insertControl(fileInputFour, scanFileFour, hashTableFour, temp, hashValue);
                hashTableFive = insertControl(fileInputFive, scanFileFive, hashTableFive, temp, hashValue);
                
                //Close File immediately after it is used
                scanFile.close();
                
                //Print Hash Tables And Generate .csv files
                hashTableOne.printHash("One");
                hashTableTwo.printHash("Two");
                hashTableThree.printHash("Three");
                hashTableFour.printHash("Four");
                hashTableFive.printHash("Five");
                
                //End Control Notification
                System.out.printf("File creation was successful\n");
            }
            catch (Exception e)
            {
                System.out.printf("An error occured.\n");
                e.printStackTrace();
            }
    }
    
    public static Hash insertControl(FileReader fileInput, Scanner scanFile, Hash table, String temp, int hashValue)
    {
        while(scanFile.hasNext())
        {
             temp = scanFile.next().toLowerCase();
             hashValue = Math.abs(temp.hashCode());
                    
             if(temp != null)
             {
                 table.insert(new WordInfo(), temp, hashValue);
             }
        }
        
        return table;
    }
}


