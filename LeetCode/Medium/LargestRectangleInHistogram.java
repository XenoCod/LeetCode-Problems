import java.util.Stack;

public class LargestRectangleInHistogram {
    static int maxRectanagle(int nums[]){
        int n= nums.length;
        int leftSmaller[]= new int [n];
        int rightSmaller[]= new int [n];
        int maxArea=0;
        Stack<Integer> st= new Stack<>();
        for(int i=0; i< n; i++){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]) st.pop();
            if(st.isEmpty()) leftSmaller[i]= 0;
            else leftSmaller[i]= st.peek() +1;
            st.push(i);
        }

        while(!st.isEmpty()) st.pop();

        for(int i= n-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            if(st.isEmpty()) rightSmaller[i]= n-1;
            else rightSmaller[i]= st.peek()-1;
            st.push(i);
        }
        for(int i=0; i< n;i++){
            maxArea= Math.max(maxArea, nums[i] * (rightSmaller[i] - leftSmaller[i] + 1 ));

        }
        return maxArea;
    }
    public static void main(String[] args) {
        int heights[]= {2,1,5,6,2,3};
//        int heights[]= {2,4};
        System.out.println(maxRectanagle(heights));
    }
}
