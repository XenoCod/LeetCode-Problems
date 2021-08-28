
public class MaxDistanceToClosetPerson {
	static int maxDistance(int nums[]) {
		/*
		 You are given an array representing a row of seats where seats[i] = 1 represents 		a person sitting in the ith seat, and seats[i] = 0 represents that the ith seat is 		empty (0-indexed).
		There is at least one empty seat, and at least one person sitting.
		Alex wants to sit in the seat such that the distance between him and the closest 		person to him is maximized. 
		Return that maximum distance to the closest person.
		 */
		//We keep to pointer, left & right
		int left=-1, res=0, n=nums.length;
		for(int right=0; right<n;right++) {
			//if we see 0 we keep moving forward
			if(nums[right] == 1) {
				if(left == -1) {
					res= Math.max(res, right );
				}
				else {
					res = Math.max(res,(right - left)/2 );
				}
				left= right;
			}
		}
		
		//Edge case if the nums array ends with 0
		if(nums[n-1] == 0) {
			res = Math.max(res, n-1- left);
		}
		
		return res;
		
		
	}
	public static void main(String[] args) {
		int nums[]= {1,0,0,0,1,0,1};
		System.out.println(maxDistance(nums));
	}

}
