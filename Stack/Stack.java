class Stack 
{ 
    int MAX; 
    int top; 
    int a[]; 
  
    boolean isEmpty() 
    { 
        return (top < 0); 
    } 
    
    Stack() 
    { 
        this.top = -1;
        this.MAX=1000;
        this.a = new int[MAX];
    } 
    
    Stack(int cap)
    {
    	this.top=-1;
    	this.MAX=cap;
    	this.a = new int[MAX];
    }
  
    void push(int x) 
    { 
        if (top >= (MAX - 1)) 
            System.out.println("Stack capacity reached"); 
        else
        	a[++top] = x;   
    } 
  
     void pop() 
    { 
        if (top < 0)
        	System.out.println("Stack empty");
        else 
        	top--;
    } 
  
    int peek() 
    { 
        if (top < 0) {
            return 0; 
        } 
        else { 
            int x = a[top]; 
            return x; 
        } 
    }
    
    public static void main(String[] args)
    {
    	Stack s = new Stack(5);  
        s.push(5); 
        s.push(7); 
        s.push(4); 
        System.out.println(s.peek());
        s.pop();
        System.out.println(s.peek());
        s.pop();
        s.pop();
        s.pop();
    }
}