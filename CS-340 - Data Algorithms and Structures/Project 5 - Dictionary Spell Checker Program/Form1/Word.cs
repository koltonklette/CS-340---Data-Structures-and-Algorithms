//Kolton Klette
//John Matta
//CS-340 - Algorithms and Data Structures
//April 12th, 2021

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Form1
{
    public class Word: IComparable<Word>
    {
        int penaltyCount;
        string word;

        public Word(string word, int penaltyCount)
        {
            this.penaltyCount = penaltyCount;
            this.word = word;
        }

        public string getWord()
        {
            return word;
        }

        public int getPenaltyCount()
        {
            return penaltyCount;
        }

        public void setPenaltyCount(int newPenalty)
        {
            this.penaltyCount = newPenalty;
        }

        public int CompareTo(Word tempObj)
        {
            if(this.penaltyCount < tempObj.penaltyCount)
            {
                return -1;
            }
            else if(this.penaltyCount > tempObj.penaltyCount)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
    }
}
