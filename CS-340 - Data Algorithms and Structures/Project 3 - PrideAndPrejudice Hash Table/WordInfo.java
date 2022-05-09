//Kolton Klette
//Professor John Matta
//CS-340 - Algorithms and Data Structure
//March 10th, 2021

public class WordInfo
{
    //Global Variables
    String word;      //saves the word read from the file.
    int count = 1;    //saves and tracks the number of times a single word appears
    int steps = 1;    //saves and tracks the number of steps needed to reach a specific word

    public WordInfo()
    {
        
    }
    
    public void setWord(String word)
    {
        this.word = word;
    }
    
    public void increaseCount()
    {
        count++;
    }
    
    public void calculateSteps(int iterate, int count)
    {
        steps = count * iterate; 
    }
    
    public String getWord()
    {
        return word;
    }
    
    public int getCount()
    {
        return count;
    }
    
    public int getSteps()
    {
        return steps;
    }
}