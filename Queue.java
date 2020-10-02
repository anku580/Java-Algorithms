class Queue 
{ 
    int front, rear, size; 
    int  capacity; 
    int array[]; 
       
    public Queue(int capacity) { 
         this.capacity = capacity; 
         front = this.size = 0;  
         rear = capacity - 1; 
         array = new int[this.capacity]; 
            
    } 
       
    
    boolean isFull(Queue queue) 
    {  return (queue.size == queue.capacity); 
    } 
       
    
    boolean isEmpty(Queue queue) 
    {  return (queue.size == 0); } 
       
   
    void enqueue( int item) 
    { 
        if (isFull(this)) 
            System.out.println("Queue capacity reached"); 
        this.rear = (this.rear + 1)%this.capacity; 
        this.array[this.rear] = item; 
        this.size = this.size + 1; 
    } 
       
   
    void dequeue() 
    { 
        if (isEmpty(this)) 
            System.out.println("The queue is empty");  
        this.front = (this.front + 1)%this.capacity; 
        this.size = this.size - 1; 
    } 
       
   
    int front() 
    { 
        if (isEmpty(this)) 
            return Integer.MIN_VALUE; 
           
        return this.array[this.front]; 
    } 
        
  
    int rear() 
    { 
        if (isEmpty(this)) 
            return Integer.MIN_VALUE; 
           
        return this.array[this.rear]; 
    }

    public static void main(String[] args)
    {
    	Queue q=new Queue(10);
    	q.enqueue(5);
    	q.enqueue(7);
    	q.enqueue(4);
    	q.enqueue(3);
    	System.out.println("front is "+q.front());
    	q.dequeue();
    	q.dequeue();
    	q.dequeue();
    	q.dequeue();
    	q.dequeue();
     }
} 