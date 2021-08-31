
public class BinarySearch {
	int solve(int nums[], int target) {
		
		int first= help(nums, target, true);
		int last= help(nums, target, false);
//		System.out.println(first+ " "+ last);
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
	
	private int ceil(int nums[], int target) {
		int low=0, high=nums.length, res=-1;
		while(low <= high) {
			int mid= low + ((high - low) >> 1);
			if(nums[mid] == target) return mid;
			else if(nums[mid] > target) {
				res=nums[mid];
				high=mid - 1;
			}
			else low= mid+1;
		}
		return res;
	}
	
	private int floor(int nums[], int target) {
		int low=0, high=nums.length,res=-1;
		while(low <= high) {
			int mid= low +((high - low) >> 1);
			if(nums[mid] == target) return nums[mid];
			else if(nums[mid] > target) high= mid -1;
			else {
				res=nums[mid];
				low= mid+1;
			}
		}
		return res;
	}
	
	
	private int firstOcc(int nums[], int target) {
		int low=0, high=1,res=-1;
		while(low <= high ) {
			if(nums[low] <= target && nums[high] >= target) {
				int mid= low + ((high - low) >> 1);
				if(nums[mid] == target) {
					res=mid;
					high= mid-1;
				}
				else if(nums[mid] > target) high= mid-1;
				else low= mid+1;
				
			}
			else {
				int temp= high;
				high=2*high;
				low= temp;
				
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int nums[]= {2,4,10,10,10,18,20};
		int infiniteNums[]= {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		
		BinarySearch bs= new BinarySearch();
		System.out.println(bs.solve(nums, 10));
		
		System.out.println(bs.ceil(nums, 11)  );
		System.out.println(bs.floor(nums, 3));
		System.out.println(bs.firstOcc(infiniteNums,1));
	}

}
