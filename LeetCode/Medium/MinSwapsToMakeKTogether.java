
public class MinSwapsToMakeKTogether {
	public static int minSwap (int nums[], int n, int k) {
        //Complete the function
        int low=0, high= n-1, res=0;
        
       while(low < high){
           if(nums[low] <= k && nums[high] <= k){
             low++;
           }
           else if(nums[low] >k && nums[high]<=k){
               swap(nums, low, high);
               high--;
               
           }
           else if(nums[low]<=k && nums[high] > k){
               swap(nums, high, low);
               low++;
               res++;
           }
           else{
               low++;
               high--;
           }
       }
       return res;
    
    }
	private static void swap(int nums[], int low, int high){
        int temp= nums[low];
        nums[low]= nums[high];
        nums[high]= temp;
    }
	public static void main(String[] args) {
		int nums[]= {10,12,20,20,5 ,19 ,19 ,12 ,1 ,20 ,1};
		int k=1;
		System.out.println(minSwap(nums,nums.length, k));
	}

}
