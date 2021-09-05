
public class Recursion {
	void printN(int n) {
		if(n==0) {
			return;
		}
		
		printN(n-1);
		System.out.print(n+" ");
//		return;

	}
	
	
	
	//Sorting array using recursion
	void sort(int nums[], int n) {
		if(n == 0) return;
		sort(nums, n-1);
		insert(nums, n-1);
	}
	
	void insert(int nums[], int n) {
		if(n == 0 || nums[n] >= nums[n-1]) return;
		else {
			int temp= nums[n];
			nums[n]= nums[n-1];
			nums[n-1] = temp;
			insert(nums, n-1);
		}
	}
	
	
	public static void main(String[] args) {
		Recursion obj= new Recursion();
//		obj.printN(20);
		
		int nums[]= {9,4,1,3,5,2,7,6,8,10};
		obj.sort(nums, nums.length);
		for(int i:nums) System.out.print(i+" ");
	}

}
