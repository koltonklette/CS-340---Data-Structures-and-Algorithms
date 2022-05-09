//Kolton Klette
//John Matta
//CS-340 - Algorithms and Data Structures
//April 12th, 2021

using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Form1
{
    public partial class Form1 : Form
    {
        //Global Variables
        List<Word> listOfWords = new List<Word>();

        public Form1()
        {
            InitializeComponent();
        }

        public void readDictionary()
        {
            ///Variable Declaration
            string tempWord;
            string textFile = @"C:\Users\Kolton\Desktop\Project_5_C_Attempt\Project 5 (C# Attempt)\Form1\dictionary.txt";

            //Actual File Reading
            System.IO.StreamReader fileName = new System.IO.StreamReader(textFile);
            while( (tempWord = fileName.ReadLine()) != null)
            {
                listOfWords.Add(new Word(tempWord, 0));
            }
            fileName.Close();

            //Suspend Screen
            System.Console.ReadLine();
        }

        public bool vowelCheck(char currentChar)
        {
            String vowels = "aeiou"; //creates string value used to compare to input word, to check for the existence of a vowel at a given index
            if(vowels.IndexOf(currentChar) == -1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public void assignPenalty(string typedWord, Word wordFromDictionary, int noMatch, int notMatch, int gap)
        {
            //Variable Declaration
            string tempWord = wordFromDictionary.getWord();
            int inputLength = typedWord.Length;
            int bestMatch = tempWord.Length;
            int overallLength = inputLength + bestMatch + 1;
            int[,]array = new int[overallLength, overallLength];

            //"Clean" values contained in the 2D array so that they are equal to zero
            for(int i = 0; i < overallLength; i++)
            {
                for (int j = 0; j < overallLength; j++)
                {
                    array[i, j] = 0;
                }
            }

            //Set gap values in the array
            for (int k = 0; k < overallLength; k++)
            {
                array[k, 0] = k * gap;
                array[0, k] = k * gap;
            }

            for(int l = 1; l <= inputLength; l++)
            {
                for(int m = 1; m <= bestMatch; m++)
                {
                    if (typedWord[l - 1] == tempWord[m - 1])
                    {
                        array[l, m] = array[l - 1, m - 1];
                    }
                    else if ((((vowelCheck(typedWord[l - 1])) == true) && (vowelCheck(tempWord[m - 1]) == true)) ||
                           (((vowelCheck(typedWord[l - 1])) == false) && (vowelCheck(tempWord[m - 1]) == false)))
                    {
                        array[l, m] = Math.Min(Math.Min(array[l - 1, m - 1] + noMatch, array[l - 1, m] + gap), array[l, m - 1] + gap);
                    }
                    else
                    {
                        array[l, m] = Math.Min(Math.Min(array[l - 1, m - 1] + notMatch, array[l - 1, m] + gap), array[l, m - 1] + gap);
                    }
                }
            }

            wordFromDictionary.setPenaltyCount(array[inputLength, bestMatch]);
        }


        private void button1_Click(object sender, EventArgs e)
        {
            listBox1.Items.Clear();
            readDictionary();
            string checkWord = textBox1.Text.ToLower();
            for(int i = 0; i < listOfWords.Count; i++)
            {
                assignPenalty(checkWord, listOfWords[i], 3, 1, 2);
            }
            listOfWords.Sort();
            for(int i = 0; i < 10; i++)
            {
                listBox1.Items.Add(listOfWords[i].getWord());
            }
        }

        //Filler GUI Coding (generated VIA Visual Studio)
        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }
    }
}
