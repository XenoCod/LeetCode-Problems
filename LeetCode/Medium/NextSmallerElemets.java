import java.util.ArrayDeque;
import java.util.Stack;

public class NextSmallerElemets {
    static int [] nextSmaller(int nums[]){
        ArrayDeque<Integer> st= new ArrayDeque<>();
        int n= nums.length;
        int res[]= new int[n];
        for(int i= n-1; i>=0 ; i--){
            while(!st.isEmpty() && nums[i] < st.peek()) st.pop();
            if(!st.isEmpty()) res[i]=st.peek();
            else res[i]=-1;
            st.push(nums[i]);
        }
        return res;
    }
    public static void main(String[] args) {
//        int nums[]={4, 8, 5, 2, 25};
        int nums[]={13, 7, 6,12};
        nums= nextSmaller(nums);
        for(int i:nums) System.out.print(i+ " ");
//        i/p           o/p
//        4      -->   2
//        8      -->   5
//        5      -->   2
//        2      -->   -1
//        25     -->   -1

//[]
//        13, 7, 6, 12
//        Element        NSE
//        13      -->    7
//        7       -->    6
//        6       -->    -1
//        12     -->     -1

    }
}
