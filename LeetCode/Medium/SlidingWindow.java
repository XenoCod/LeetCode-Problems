import java.util.ArrayList;

public class SlidingWindow {
	
	//We will keep two pointer start and end in the front and move till the length of window (end - start +1 <size) 
	//When it becomes ==size we compare it with the max value store and move our two pointers
	
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
	
	
	//First neegtive  integer ine evry window size of k
	
	void firstNegetive(int A[], int K) {
		int i=0,j=0, N= A.length;
        ArrayList<Integer> temp = new ArrayList<>();
        int[] ans = new int[N-K+1];
        while(j < N){
            if(A[j] < 0)
                temp.add(A[j]);    
            if(j-i+1 == K){
                if(temp.size() == 0)
                    ans[i] = 0;
                else if(A[i] == temp.get(0))
                    ans[i] = temp.remove(0);
                else
                    ans[i] = temp.get(0);
                i++;
            }
            j++;
        }
//        return ans;
        for(int l:ans) System.out.print(l+" ");
	}
	
	
	public static void main(String[] args) {
		int nums[]= {4,7,1,3,5,2,9,1,5};
		int size=3;
		
		int negs[]= {12,-1,3,-3,9,5,-7,11,-4,2,-8,-9,-1,12,4,13};
//		int size=3;
		SlidingWindow obj= new SlidingWindow();
//		System.out.println(obj.findMaxSubArray(nums, size));
		obj.firstNegetive(negs, size);
	}

}
