import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TransferQueue;

public class CombinationSUm {
    static ArrayList<ArrayList<Integer>> getCombination(int arr[], int target){
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> res= new ArrayList<>();
        solve(res, new ArrayList<Integer>(), arr, target, 0);
        return res;
    }
    private static void solve(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int nums[], int target, int pos){
       if(target< 0) return;
       else if( target ==0) res.add( new ArrayList<> (temp));
       else{
           for(int i=pos; i<nums.length; i++){
               temp.add(nums[i]);
               solve(res, temp, nums,target- nums[i], i);
               temp.remove(temp.size()-1);
           }
        }
    }

    public static void main(String[] args) {
        int arr[]= {2,3,6,7};
        int target= 7;
        ArrayList<ArrayList<Integer>> res= getCombination(arr, target);
        for(ArrayList <Integer> i: res)
            System.out.println(i);
    }
}
