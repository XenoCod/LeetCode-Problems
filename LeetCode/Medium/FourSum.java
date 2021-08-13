import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    static List<List<Integer>> getFourSum(int nums[], int target){
        int n= nums.length;
        List<List<Integer>> res= new ArrayList<>();
        if(nums==null || n<4) return res;
        Arrays.sort(nums);
        for( int i =0;i < n-3; i++){
            if(nums[i]+ nums[i+1] + nums[i+2] + nums[i+3] > target) break; //sum  too big
            if(nums[i] + nums[n-1]+ nums[n-2]+ nums[n-3] < target) continue;//summ too small
            if(i>0 && nums[i]== nums[i-1]) continue;//checking duplicates
            for(int j=i+1; j<n-2; j++){
                if(nums[i] + nums[j]+ nums[j+1] + nums[j+2] > target) break;//too big
                if(nums[i]+ nums[j]+ nums[n-1]+ nums[n-2] < target) continue;//too small
                if(nums[j]==nums[j-1] && j> i+1) continue;//checking duplicates
                int low=j+1, high= n-1;
                while(low < high){
                    int sum= nums[i]+ nums[j]+ nums[low] + nums[high];
                    if(sum == target){
                        res.add( Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while( low< high && nums[low]== nums[low+1]) low++;//checking dhplicates
                        while( low< high && nums[high]== nums[high-1]) high--;//checking duplicates
                        low++;
                        high--;
                    }
                    else if(sum< target) low++;
                    else high--;
                }

            }
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[]={1,0,-1,0,-2,2};
        int target=0;
        System.out.println(getFourSum(arr, target));
    }
}
