import java.util.Scanner;
import java.util.Stack;

public class DualStack {

    public static class MyQueue<Integer> {
        Stack<Integer> stackNewestOnTop = new Stack<Integer>();
        Stack<Integer> stackOldestOnTop = new Stack<Integer>();

        public void enqueue(Integer value) { // Push onto newest stack
            stackNewestOnTop.push(value);
        }

        public Integer peek() {
        	prepareStacks();
			return stackOldestOnTop.pop();
        }

        public Integer dequeue() {
        	prepareStacks();
			Integer j = stackOldestOnTop.pop();
            return j;
        }
        public void prepareStacks() 
        {
        	if(stackOldestOnTop.empty())
        	{
        		while (!stackNewestOnTop.empty())
        		{
        			stackOldestOnTop.push(stackNewestOnTop.pop());
        		}
        	}
        }
    }
    


    
    public static void main1(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if(n<1||n>100000)
        {
        	System.out.println("Error");
        }
        
        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
            else
            {
            	System.out.println("Error");
            }
            
        }
        scan.close();
    }

}
