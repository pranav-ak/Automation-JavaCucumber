import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MakeingAnagrams {
    private static final Scanner scanner = new Scanner(System.in);
	public static void main1(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

	        String a = scanner.nextLine();

	        String b = scanner.nextLine();

	        int res = makeAnagram(a, b);

	        bufferedWriter.write(String.valueOf(res));
	        bufferedWriter.newLine();

	        bufferedWriter.close();

	        scanner.close();

	}

	private static int makeAnagram(String a, String b) {
		// TODO Auto-generated method stub
		
		HashMap<Character, Integer> map1 = getStringMap(a);
		HashMap<Character, Integer> map2 = getStringMap(b);
		Set<Character> alphSet = new HashSet<>();
				alphSet.addAll(map1.keySet());
				alphSet.addAll(map2.keySet());
		int counter =0;
		for(char alphabet : alphSet )
		{
			int count1=0,count2 =0;
					if(map1.get(alphabet)!=null)
					{
						count1=map1.get(alphabet);
					}
					if(map2.get(alphabet)!=null)
					{
						count2 = map2.get(alphabet);
					}
			if(count1!=count2)
			{
				counter = counter +Math.abs(count1-count2);
			}
		}
		
		return counter;
	}
	
	private static HashMap<Character, Integer> getStringMap(String input)
	{
		HashMap<Character, Integer> map = new HashMap<>();
		for (char c : input.toCharArray())
		{
			if(map.containsKey(c))
			{
				map.put(c, (map.get(c)+1));
			}
			else
			{
				map.put(c, 1);
			}
		}
		return map;
	}

}
