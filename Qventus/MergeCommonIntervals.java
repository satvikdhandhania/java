/*
Author Satvik Dhandhania
Date 5th May 2017   Qventus Round 2

http://www.geeksforgeeks.org/merging-intervals/

Input:
[ [1, 2], [8, 10], [8, 9]]

Output:
[[1, 2], [8, 10]]

Input:
[1, 5], [2,3], [4, 5]

Output:
[1, 5]

[ 1, 3 ] [2,5]

Test cases - Input:
	1.	Actually sorted list  
	2.	[1,9][ 2, 5] [4,8] -> [1,9] 
	3.	[1,6][ 7, 8] [9,11] ->[1,6][ 7, 8] [9,11]  
	4.	[1,3][2,4][3,5] -> [1,5] 
	5.	Beyond a 24 hour clock  
	6.	[-1, 0] -> Invalid 
	7.	[1,1] -> Incorrect  start < end  

*/
void interval( List<List<Integer>> arr ){
    if(arr.length <= 0){
        return;
	}

	// get(0) returns start , get(1) returns end
	int start = arr.get(0).get(0), end  = arr.get(0).get(1);
	for(int i =1;i< arr.length;i++){
		if( end < arr.get(i).get(0)){
	    System.out.println(“[”+start+”,”+ end+”]”);
	    start = arr.get(i).get(0);
	    end = arr.get(i).get(1);
		}
		if(end < arr.get(i).get(1) &&  arr.get(i).get(0) <= end){
	      // New end
		  end = arr.get(i).get(1);
		}
		if(i == (arr.length-1)){
	     System.out.println(“[”+start+”,”+ end+”]”);
		}
	}
 }
