import java.util.Stack;

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
	
	
	
	// Sort a stack
	
	 private void sortStack(Stack<Integer> st) {
		 if(st.size() ==1) return;
		 int temp= st.pop();
		 sortStack(st);
		 insertStack(st, temp);
	 }
	 
	 
	 private void insertStack(Stack<Integer> s, int temp ) {
		 if(s.size()==0||s.peek()<=temp) {
				s.push(temp);
				return;
			}
			int val = s.peek();
			s.pop();
			insertStack(s,temp);
			s.push(val);
	 }
	
	
	
	private void builtStack(Stack<Integer>st, int nums[]) {
		for(int i:nums) st.push(i);
	}
	
	private void printStack(Stack<Integer> st) {
		while(!st.isEmpty()) System.out.print(st.pop()+" ");
	}
	

	
	
	public static void main(String[] args) {
		Recursion obj= new Recursion();
//		obj.printN(20);
		
		int nums[]= {9,4,1,3,5,2,7,6,8,10};
		obj.sort(nums, nums.length);
//		for(int i:nums) System.out.print(i+" ");
		
		//Sort a stack
		Stack<Integer> st= new Stack<>();
		obj.builtStack(st, nums);
		obj.sortStack(st);
		obj.printStack(st);
		
	}

}
