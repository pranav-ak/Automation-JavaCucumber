import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import javax.print.attribute.standard.OutputDeviceAssigned;

public class Solution {
	
	private static final Scanner scanner = new Scanner(System.in);

	public static void main1(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);
        
        int d = Integer.parseInt(nd[1]);
        
        if(n<=0||n>(Math.pow(10, 5))||d<1||d>(Math.pow(10, 6)))
        {
        	System.out.println("input paramterts out of bound");
        	return;
        }
        
        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            if(aItem<1||aItem>(Math.pow(10, 6)))
            {
            	System.out.println("input paramterts out of bound");
            	return;
            }
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }
        
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
	}

	private static int[] rotLeft(int[] a, int d) {
		
		for(int j =0; j<d; j++)
		{
		
		int temp = a[0];
		for(int i=0;i<a.length;i++)
		{
			if(i<a.length-1)
			{
				a[i] = a[i+1];
			}
		}
		a[a.length-1]=temp;
		}
		return a;
		
	}

}
