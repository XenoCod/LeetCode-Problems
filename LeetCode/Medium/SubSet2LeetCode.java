import java.util.ArrayList;
import java.util.Arrays;

public class SubSet2LeetCode {
    static ArrayList<ArrayList<Integer>> getSubSets(int arr[]){
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> res= new ArrayList<>();
        solve(res, new ArrayList<Integer>(), arr, 0);
        return res;
    }
    private static void solve(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int nums[], int pos){
        if(pos <= nums.length) res.add(new ArrayList<>(temp));
        for(int i=pos; i< nums.length; i++){
            if(i > pos && nums[i]== nums[i-1]) continue;; //skipping the duplicates
            temp.add(nums[i]);
            solve(res, temp, nums, i+1);
            temp.remove(temp.size()-1);


        }
    }
    public static void main(String[] args) {
        int arr[]= {1,2,2,3};
        ArrayList<ArrayList<Integer>> res= getSubSets(arr);
        for(ArrayList <Integer> i: res)
            System.out.println(i);
    }
}
