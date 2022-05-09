//Kolton Klette
//Professor John Matta
//CS-340 - Data Structures and Algorithms
//February 21st, 2021

public class Main {
    public static void main(String[] args) 
    {
        PriorityQueue pq = new PriorityQueue(7);
        pq.insert(new Node(0,3));
        pq.insert(new Node(1,14));
        pq.insert(new Node(2,7));
        pq.insert(new Node(3,9));
        pq.insert(new Node(4,99));
        pq.insert(new Node(5,2));
        pq.insert(new Node(6,46));
        
        for(int i = 0; i < 7; i++)
        {
            System.out.print(pq.extract().key + " ");
        }
    }
}
