
public class SubPalindromeCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String S = "ellollehd";//"wowpurerocks";

		int sub_palindrome_count = S.length();

		char arr[] = S.toCharArray();
		for(int i=1;i<S.length()-1;i++)
		{
			if(arr[i] == arr[i+1]){
				//System.out.println(arr[i]);
				sub_palindrome_count++;
			}

			for(int j=1;j<=i;j++)
			{
				if((i+j) <= S.length()-1) 
				{
					if(arr[i-j]==arr[i+j])
					{
						System.out.println(arr[i-j]);
						sub_palindrome_count++;
					}
					else{
						break;
					}

				}
			}
		}
		System.out.println(sub_palindrome_count);
	}

}
