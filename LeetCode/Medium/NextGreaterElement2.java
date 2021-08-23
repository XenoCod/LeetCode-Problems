import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class NextGreaterElement2 {

    static int [] nextGreater(int nums[]){
        /* We start traversing fromt the back and since it has asked as cirular array problem we use i % n
        and traversing from 2n-1 instead of n-1;
         */
        ArrayDeque<Integer> st= new ArrayDeque<>();
        int n= nums.length;
        int res[]= new int [n];
        for(int i=(2 * n)-1; i>=0; i--){
            //Remove all the element in the stack which are less than the current nums element
            while(!st.isEmpty() && nums[i % n] >= st.peek()) st.pop();
            if(i < n){
                //checking if the index right now is inseide the scope of the single array not in cirular array
                if(!st.isEmpty()) res[i % n]= st.peek();
                else res[i % n]= -1;

            }
            st.push(nums[i % n]);
        }
return res;
    }
    public static void main(String[] args) {
        int [] nums = {3, 10, 4, 2, 1,2,6,1,7,2,9};
        nums= nextGreater(nums);
        for(int i:nums) System.out.print(i+" ");
    }
}
