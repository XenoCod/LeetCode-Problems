import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ThreeSUM {
    static List<List<Integer>> getThreeSum(int nums[]){
        int n=nums.length;
        List<List<Integer>> res= new ArrayList<>();
        if(nums == null || n<3) return res;
        for(int i=0;i<n-2;i++){
            if(nums[i]+ nums[i+1]+ nums[i+2] > 0) break;//To big
            if(nums[i] + nums[n-1]+ nums[n-2] < 0) continue;//Too small
            if(i>0 && nums[i]== nums[i-1]) continue;//Checking duplicates

            int low=i+1, high= n-1;
            while(low< high){
                int sum= nums[i]+ nums[low]+ nums[high];
                if(sum==0){
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while(low< high && nums[low]==nums[low+1]) low++;//avoiding duplicates
                    while(low< high && nums[high]== nums[high-1]) high--;//avoiding duplicates
                    low++;
                    high--;
                }
                else if(sum>0) high--;
                else low++;

            }

        }
        return res;
    }
    public static void main(String[] args) {
        int arr[]= {-1,0,1,2,-1,-4};
        System.out.println(getThreeSum(arr));
    }
}
