
public class FirstMissingPositive {
	/*
	 * Then the algorithm becomes:

1- Ignore all numbers <=0 and >n since they are outside the range of possible answers (which we proved was [1..n]). We do this by replacing them with the value n+1.
2- For all other integers <n+1, mark their bucket (cell) to indicate the integer exists. (*see below)
3- Find the first cell not marked, that is the first missing integer. If you did not find an unmarked cell, there was no missing integer, so return n+1.

*/
	static int getFirstMissingPositive(int nums[]) {
		int n=nums.length;
		//Step 1: replacing all the elements which are either smaller than 0 or larger than the size
		for(int i=0; i<nums.length; i++) {
			if(nums[i] <= 0 ||  nums[i] > n)
				nums[i] = n + 1;
		}
		//Step 2: Making the present index negetive to spot the answer
		for(int i=0; i<n; i++) {
			int num= Math.abs(nums[i]);
			if(num > n ) continue;
			num= num-1;//For 0 based indexing decereasing the num by 1
			if(nums[num] > 0) {
				nums[num] = -1 * nums[num];
			}
			
			
		}
		//Step 3: Just checking which eleemt has the postive index 
		for(int i=0; i< n; i++) {
			if(nums[i] >=0)
				return i+1;//found the index
		}
		return n+1;//Arrays is full so return the last index
		
		
		
	}
	
	public static void main(String[] args) {
		int nums[]= {1,2, 0};
		System.out.println(getFirstMissingPositive(nums));
		
	}

}
