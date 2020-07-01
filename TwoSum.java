/* 
In Two Sum we are given a array with distinct values and a value(say K)
We have to find whether there exist any two numbers which sums to k 
*/
/*
Here we are going to use Two approaches to solve this
1. Two pointer Technique
2. Using HashSet 
*/
import java.io.*;
import java.util.*;

public class TwoSum
{
 public static void main(String[] args) throws Exception
 {
 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 	int test = Integer.parseInt(br.readLine());
 	while(test-- > 0)
 	{
 		int n = Integer.parseInt(br.readLine());
 		String[] inp = br.readLine().split(" ");
 		int[] arr = new int[n];
 		for(int i = 0 ; i < n ; ++i)
 		{
 			arr[i] = Integer.parseInt(inp[i]);
 		}
 		int k = Integer.parseInt(br.readLine());
 		bw.write(twoPointer(arr,k)+"\n");
 		bw.write(usingHashSet(arr,k)+"\n");
 	}
 	bw.flush();
 }
 public static boolean twoPointer(int[] arr,int k)
 {
 	Arrays.sort(arr);
 	int left = 0 , right = arr.length - 1;
 	while(left < right)
 	{
 		if(arr[left] + arr[right] == k) return true;
 		else if(arr[left] + arr[right] < k) left++;
 		else right--;
 	}
 	return false;
 }
 public static String usingHashSet(int[] arr, int k)
 {
 	HashSet<Integer> hs = new HashSet<Integer>();
 	String res = "";
 	for(int i = 0 ; i < arr.length ; ++i)
 	{
 		int x = k - arr[i];
 		if(hs.contains(x)) res += ("[" + x + "," + arr[i] + "]\n");
 		else
 		{
 			hs.add(arr[i]);
 		}
 	}
 	return res;
 	
 }
}

