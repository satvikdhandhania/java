/*
 * Author: Satvik Dhandhania
 * Given an array of n integers form all possible combinations of length n from the array.
 */
import java.util.ArrayList;

public class PermutationsOfArray {

	public static void main(String[] args) {
		int arr[] = {1,5,3};
		ArrayList<ArrayList<Integer>> p = new ArrayList< ArrayList<Integer>>();
		boolean flagArray[] = new boolean[arr.length];
		int newArr[] = new int[arr.length];
		// Initialize used flag array to false
		for(int i=0;i<arr.length ; i++){
			flagArray[i] = false;
		}
		formPermutations(arr, 0, flagArray,newArr,p);
		System.out.println(p);
	}
	static void formPermutations(int[] arr, int index, boolean[] flags, int[] newArr, ArrayList<ArrayList<Integer>> p){
		if(index == arr.length){
			// When an array is formed store it in an arraylist
			ArrayList<Integer> t = new ArrayList<Integer>();
			for(int i=0;i<arr.length;i++)
				t.add(newArr[i]);
			p.add(t);
			return;
		}

		for(int j=0;j<arr.length;j++)
		{	
			if(!flags[j])
			{
				// Assign value to newArray
				newArr[index] = arr[j];
				// Omit for next value search
				flags[j] = true;
				// Recursively keep forming the array
				formPermutations(arr,index+1,flags,newArr,p);
				// Undo use of last value so that new values can be formed
				flags[j] = false;
			}
		}

	}
}
