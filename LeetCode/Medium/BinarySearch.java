
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
		
		//We are givem an infinite binary array and we have to find the first occurence of the target
		try {
				int low=0, high=1,res=-1;
				while(low <= high ) {
					if(nums[low] <= target && nums[high] >= target) {
						return help(nums, target, true);
						
					}
					else {
						int temp= high;
						high=2*high;
						low= temp;
						
					}
				}
				return res;
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Not in Array");
			return -1;
		}
	}
	
	
	
	//Minnummum absolute diff of the key
	private int absDif(int absDiff[], int key) {
		return  key - floor(absDiff, key) ;
		//Minnumm abs diff will always the differnece between the prevoius smaller element and the current key
	}
	
	//Find peak element in biottonic array
	private int findPeak(int nums[]) {
		if(nums.length==1) return 0;
		if(nums[0] > nums[1]) return 0;
		int n=nums.length;
		if(nums[n-1] >nums[n-2]) return n-1;
		//checking for the remaining array
		int low=1, high=n-2;
		while(low <=high) {
			int mid = low + ((high - low) >> 1);
			if(nums[mid] > nums[mid -1] && nums[mid] >nums[mid +1]) return mid;
			else if(nums[mid-1] > nums[mid]) high= mid-1;
			else low= mid+1;
		}
		return -1;
	}
	
	//SImple binary search
	private int bSearch(int nums[], int target, int l, int h) {
		int low=l, high=h;
		while(low <= high) {
			int mid= low + ((high - low ) >> 1);
			if(nums[mid] == target) return mid;
			else if(nums[mid] < target) high= mid-1;
			else low= mid+1;
		}
		return -1;
	}
	
	
	private int biotonicSearch(int nums[], int target) {
		int index=findPeak(nums);
		int first=bSearch(nums, target, 0, index-1);
		int second= bSearch(nums, target, index, nums.length-1);
		System.out.println(first+ " "+second);
		return (first != -1)?first: second;
		
		
	}
	
	
	
	//Search in sorted rotated array with duplicates
	private boolean searchSortedRotatedArray2(int nums[], int target) {
		int low=0, high=nums.length-1;
        while(low <= high){
            int mid= low + (high - low) /2;
            if(nums[mid] ==  target) return true;
            if(nums[low] <= nums[mid]){
                if(nums[low]<= target && target<= nums[mid])  high= mid-1;
                else                                          low=mid+1;
                
            }
            else{
                if(nums[mid]<= target && target<= nums[high]) low= mid+1;
                else                                          high=mid-1;
            }
        }
        return false;
       
	}
	
	public static void main(String[] args) {
		int nums[]= {2,4,10,10,10,18,20};
		int infiniteNums[]= {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0, 0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		int absDiff[]= {1,3,8,10,15};
		int bio[]= {1,3,8,12,4,2};
		int dups[]= {2,5,6,0,0,1,2};
		
		
		
		BinarySearch bs= new BinarySearch();
		
		
		System.out.println(bs.solve(nums, 10));
		System.out.println(bs.ceil(nums, 11)  );
		System.out.println(bs.floor(nums, 3));
		System.out.println(bs.firstOcc(infiniteNums,2));
		System.out.println(bs.absDif(absDiff, 12));
		System.out.println(bs.biotonicSearch(bio, 2 ));
		System.out.println(bs.searchSortedRotatedArray2(dups, 0));
	}

}
