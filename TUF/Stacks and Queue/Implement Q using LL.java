/*The structure of the node of the queue is
class QueueNode
{
	int data;
	QueueNode next;
	QueueNode(int a)
	{
	    data = a;
	    next = null;
	}
}*/

class MyQueue
{
    QueueNode front, rear;
    
	void push(int a)
	{
       QueueNode temp=new QueueNode(a);
       if(front==null)
       {
        front=temp;
       rear=temp;
       }
       else
       {
       rear.next=temp;
       rear=temp;
       }
	}
	
    //Function to pop front element from the queue.
	int pop()
	{
	    if(front==null)
	    return -1;
       int val=front.data;
       front=front.next;
       return val;
	}
}




