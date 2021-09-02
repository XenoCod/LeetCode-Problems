
public class SlidingWindow {
	
	
	int findMaxSubArray(int nums[], int size) {
		int sum=0, max= Integer.MIN_VALUE;
		int start=0, end=0;
		while(end < nums.length) {
			sum+= nums[end];
			if(end- start + 1< size) end++;
			else if(end - start + 1 == size) {
				max= Math.max(max, sum);
				sum= sum- nums[start];
				start++;
				end++;
			}
		}
		return max;
	}
	public static void main(String[] args) {
		int nums[]= {4,7,1,3,5,2,9,1,5};
		int size=5;
		SlidingWindow obj= new SlidingWindow();
		System.out.println(obj.findMaxSubArray(nums, size));
	}

}
