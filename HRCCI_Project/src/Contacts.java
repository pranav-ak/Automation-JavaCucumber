import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Contacts {
	
	public static Map<Character, ArrayList<String>> Contacts;

	
	public static void addContact(String con)
	{
		ArrayList<String> a = new ArrayList<String>();
		Set ab = new HashSet<String>();

	}
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    	String a = "hacker";
    	String b = "had";
    	String c = "hab";
    	
    	if(a.compareTo(b)<0)
    		System.out.println("hacker < hac");
    	if(a.compareTo(b)==0)
    		System.out.println("hacker = hac");
    	if(a.compareTo(b)>0)
    		System.out.println("hacker > hac");
    	
    	if(b.compareTo(a)<0)
    		System.out.println("hac < hacker");
    	if(b.compareTo(a)==0)
    		System.out.println("hac = hacker");
    	if(b.compareTo(a)>0)
    		System.out.println("hac > hacker");
    	
/*        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int nItr = 0; nItr < n; nItr++) {
            String[] opContact = scanner.nextLine().split(" ");

            String op = opContact[0];

            String contact = opContact[1];
        }

        scanner.close();
*/    }

}
