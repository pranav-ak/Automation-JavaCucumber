import java.util.Scanner;

public class HashTable {

    static void checkMagazine(String[] magazine, String[] note) {
    	boolean result = false;
    	    	
    	for(String n : note)
    	{	
    		result = false;
    		for (int i=0; i<magazine.length;i++)
    		{
    			if(magazine[i].equals(""))
    			{
    				continue;
    			}
    			
    			if(magazine[i].compareTo(n)==0)
    			{
    				magazine[i]="";
    				result=true;
    				break;
    			}
    			
    		}
    		if(!result)
    		{
    			break;
    		}else
    		{
    			continue;
    		}
    	}
    	if(result)
    	{
    		System.out.println("Yes");
    	}else
    	{
    		System.out.println("No");
    	}
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main1(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }

}
