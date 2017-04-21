/**
 * Write a function that is given an integer K and an array of integers. 
 * The array represents daily stock price of company A.
 * K represents the number of times you can buy stock.
 * You can buy only one share each time.
 * When you already have a share, you cannot buy more.
 * You can sell your share anytime you want.
 * The function should return the maximum possible profit.
 */

/*
 * k=3 n=4
 * priceList = {10 ,30 , 20, 45}
 * 0  0  0   0 
 * 0  20 20 35
 * 0  20 20 45
 * 
 * */
public class MaxProfitStockKTransactions {


	static public int findMaxProfit(int k, int[] priceList) {
		// Write code here
		if(k == 0){
			return 0;
		}
		int n = priceList.length;
		int profit[][] = new int[k+1][n+1];

		for(int i=0;i<=k;i++){
			profit[i][0] = 0;
		}

		for(int i=0;i<=n;i++){
			profit[0][i] = 0;
		}

		for(int i=1;i<=k;i++)
		{
			int val = Integer.MIN_VALUE;
			for(int j=1;j<n;j++){
				val = Math.max(val, profit[i-1][j-1] - priceList[j-1]);
				profit[i][j] = Math.max(profit[i][j-1], priceList[j] + val);
			}    
		}
		return profit[k][n-1];

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] priceList = {10 ,30 , 20, 45};
		System.out.println(findMaxProfit(3, priceList)) ;
	}

}





//Java



