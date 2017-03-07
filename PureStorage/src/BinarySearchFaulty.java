
public class BinarySearchFaulty {

	static int sorted(int []ele, int tar){
		if(ele ==  null || ele.length<=0) 
			return -1;
		int left =0, right =  ele.length-1;
		while(left<right)
		{
			int mid = (left+right+1)/2;
			if(ele[mid]>tar)
				right = mid -1;
			else 
				left = mid + 1; 
		}
		if (ele[right] == tar) 
			return right;
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[] = {1,2,3};
		 System.out.println(arr.length);
		 for(int i=0;i<arr.length;i++)
			 System.out.print(arr[i]+ " ");
		 System.out.println("\n"+sorted(arr,2));
	}

}
