/*
 * Author: Satvik Dhandhania
 * Fold an array for increasing sequences by and replace sequences with start-stop
 */
public class ArrayFolding {

	public static void main(String[] args) {

		int array[] = {11,12,13,14,15,1,2,3,3,4,4,5,10,11,12,1};
		String s = ""+array[0];
		System.out.println(fold(array,s,1,false));
	}

	static String fold(int[] arr, String s,int index, boolean flag){

		if(arr.length-1 < index){
			// For the last position
			if((arr[index-1]+1) == arr[index-2]){
				return s+arr[index-1];
			} else {
				return s;
			}
		}

		boolean last_flag = false;
		if (index > 1){
			// Update the flag based on last two offsets
			last_flag = ((arr[index-2]+1) == arr[index-1]);
		}
		
		if(!last_flag &&  ((arr[index-1]+1) == arr[index])){
			// Sequence found
			s = s + "-";
		} else if(last_flag && ((arr[index-1]+1) != arr[index])){
			// If a sequence ended add the last number and the next number
			s = s+arr[index-1]+","+arr[index];
		} else if(!last_flag &&  ((arr[index-1]+1) != arr[index])){
			// If the numbers are not in sequence simply add them
			s = s+","+arr[index];
		}

		s =	fold(arr,s,index+1,flag);
		return s;
	}
}
