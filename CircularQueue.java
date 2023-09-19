/*
	Time complexity: O(1) for all operations.
	Space Complexity: O(N)
	
	Where 'N' is the size of the queue.  
*/

import java.util.ArrayList;

public class CircularQueue {
	// Initialise front and rear of the queue.
	int[] arr;
    int front, rear, size;

	// Initialize your data structure..
	public CircularQueue(int k) {

		arr = new int[k];
        front = rear = -1;
        size = k;

	}

	// Enqueues 'X' into the Queue. Returns true if it gets enqueued into the queue and false otherwise..
	public boolean enqueue(int value) {
		// if queue is full
        if(front == 0 && rear == size - 1 || (rear == (front - 1) % (size - 1)))
            return false;

        // if queue is empty
        else if(front == -1)
            front = rear = 0; 

        // rear in the end and front not on 0 position
        else if(rear == size - 1 && front != 0)
            rear = 0;

        // normal case
        else
            rear++;

        // enqueueing 
        arr[rear] = value;

        return true;
	}
	/*
	   Dequeues top element from Mth Queue. Returns -1 if the queue is empty,
	   otherwise returns the dequeued element.
	*/
	public int dequeue() {
		// queue empty
        if(front == -1)
            return -1;
        
		int data = arr[front];
        arr[front] = -1;

        if(front == rear){
            front = rear = -1;
        }

        else if(front == size -1)
            front = 0;

        else 
            front++;

        return data;
	}
};
