import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum2 {
    static ArrayList<ArrayList<Integer>> getCombinations(int arr[], int target){
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        solve(res, new ArrayList<>(), arr, target, 0 );
        return res;
    }
    private static void solve(ArrayList<ArrayList<Integer>>res, ArrayList<Integer> temp, int nums[], int target, int pos){
        if(target< 0) return;
        else if(target == 0 && !res.contains(temp)) res.add(new ArrayList<>(temp));
        else{
            for(int i=pos; i<nums.length; i++){
                if(i> pos && nums[i]== nums[i-1]) continue;
                temp.add(nums[i]);
                solve(res, temp, nums, target - nums[i], i+1);
                temp.remove(temp.size()-1);
            }
        }

    }
    public static void main(String[] args) {
        int arr[]={10,1,2,7,6,1,5};
        int target= 8;
        ArrayList<ArrayList<Integer>> res= getCombinations(arr, target);
        for(ArrayList<Integer> i: res)
            System.out.println(i);
    }
}
