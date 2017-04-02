/*
 * Author: Satvik Dhandhania
 * From two different arrays identify two elements such that they have the minimum absolute difference
 */
public class PairOfMinDiff {

	int a,b;
	int difference;
	// Constructor
	PairOfMinDiff(){
		a = b = -1;
		difference = Integer.MAX_VALUE;
	}
	
	public void set(int x, int y){
		a = x;
		b = y;
		difference = Math.abs(a-b);
	}
	public void print(){

		System.out.println("Array1 Element="+a+"\nArray2 Element="+b);
	}
	// Check for a better match
	public boolean betterMatch(int x, int y){
		int diff = Math.abs(x-y);
		if(diff<difference)
			return true;
		return false;
	}


	public static void main(String[] args) {
		int a1[] = {111, 53, 100, 300, 403, 32, 0324, 4554, 543};
		int a2[] = {1110, 511, 1007, 5431, 453, 42 , 34,653,232};
		PairOfMinDiff p = new PairOfMinDiff();		
		// Quicksort one of the arrays
		sort(a1,0,a1.length-1);
		for(int i=0;i<a2.length;i++)
			p = binarySearch(a1, 0, a1.length-1, a2[i], p);
		p.print();

	}
	// Binary search to check in window cases 
	static PairOfMinDiff binarySearch(int [] array, int low, int high, int k, PairOfMinDiff p){
		int mid = (low + high) / 2;
		if(p.betterMatch(array[mid], k))
			p.set(array[mid], k);
		if(mid >= 1)
		{
			if(p.betterMatch(array[mid-1], k))
				p.set(array[mid-1], k);
		}
		if ((mid+1) < array.length){
			if(p.betterMatch(array[mid+1], k))
				p.set(array[mid+1], k);
		}
		if(low > high){
			return p;
		} else if (array[mid] == k) {
			return p;
		} else if (array[mid] < k) {
			return  binarySearch(array, mid + 1, high, k, p);
		} else {
			return binarySearch(array, low, mid - 1, k, p);
		}

	}
	// Quick Sort partitioning
	static int partition(int arr[], int low, int high){
		int pivot = arr[high]; 
		int i = low-1;
		for (int j=low; j<=high-1; j++){
			if (arr[j] <= pivot){
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int tmp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = tmp;
		return i+1;
	}
	// Sorting logic
	static void sort(int arr[], int low, int high)
	{
		if (low < high)
		{
			int pivot = partition(arr, low, high);
			sort(arr, low, pivot-1);
			sort(arr, pivot+1, high);
		}
	}
}
