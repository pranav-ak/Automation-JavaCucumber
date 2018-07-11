import java.util.Scanner;
import java.util.Stack;

public class BalancedBraces {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String[] result = new String[t];
        for (int tItr = 0; tItr < t; tItr++) {
            String expression = scanner.nextLine();
            result[tItr]=getResult(expression);
        }

        scanner.close();
        
        for(String s: result)
        {
        	System.out.println(s);
        }
    }

	private static String getResult(String expression) {
		if(expression.length()%2!=0)
		{
			return "NO";
		}
		Stack<Character> stack = new Stack<>();
		for(char c : expression.toCharArray())
		{
			if(c=='{'||c=='['||c=='(') 
			{
				stack.push(c);
			}
			if(c=='}'||c==']'||c==')')
			{
				char m;
				try {
					m = stack.pop();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					return "NO";
				}
				if(!matchBrackets(m,c))
				{
					return "NO";
				}
			}
		}
		if(stack.empty())
		{
			return "YES";
		}
		else
		{
			return "NO";
		}
	}
	private static boolean matchBrackets(char a,char b)
	{
		switch(a)
		{
			case '{': 
			{
				if(b=='}') 
				{
				return true;	
				}return false;
			}
			case '(': 
			{
				if(b==')') 
				{
				return true;	
				}return false;
			}
			case '[': 
			{
				if(b==']') 
				{
				return true;	
				}return false;
			}
			default:
				return false;
		}
	}
}
