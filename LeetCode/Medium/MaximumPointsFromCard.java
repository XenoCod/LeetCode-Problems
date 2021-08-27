
public class MaximumPointsFromCard {
	//Sliding windows variation ....Google coding ques
	static int getMaxPoints(int nums[], int k) {
		int sum=0, n=nums.length;
		for(int i=0; i<k; i++) sum+=nums[i];
		int max=sum;
		for(int i=0; i<k;i++) {
			//Remove from the front and add to back and update the max accodridng and keep its updayting
			sum= sum - nums[k-i-1] + nums[n-i-1];
			max= Math.max(max, sum);
		}
		return max;
	}
	public static void main(String[] args) {
		int nums[]= {1,2,3,4,5,6,1};
		int k=3;
		System.out.println(getMaxPoints(nums, k));
	}

}
