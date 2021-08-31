
public class BinarySearch {
	int solve(int nums[], int target) {
		
		int first= help(nums, target, true);
		int last= help(nums, target, false);
		System.out.println(first+ " "+ last);
		return last - first +1;
	}
	
	int help(int nums[], int target, boolean first) {
		
			int low= 0, high= nums.length-1;
			int count=0;
			while(low <= high) {
				int mid = low + ((high - low) >> 1);
				
				if(nums[mid] == target) {
						count =mid;
						if(first) high=mid-1;
						else low= mid+1;
				}
				else if(nums[mid] > target) high=mid - 1;
				else low =mid +1;
			}
			return count;
		
	}
	
	
	public static void main(String[] args) {
		int nums[]= {2,4,10,10,10,18,20};
		
		BinarySearch bs= new BinarySearch();
		System.out.println(bs.solve(nums, 10));
	}

}
