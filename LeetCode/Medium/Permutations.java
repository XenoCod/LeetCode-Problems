import java.util.ArrayList;

public class Permutations {
    static ArrayList<ArrayList<Integer>> getPermutes(int nums[]){
        ArrayList<ArrayList<Integer>> res= new ArrayList<>();
        solve(res, new ArrayList<>(), nums, 0);
        return res;
    }
    private static void solve(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int nums[], int pos){
        if(pos==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=pos; i< nums.length; i++){
            temp.add(nums[i]);
            swap(nums, pos, i);
            solve(res, temp, nums, pos+1);
            temp.remove(temp.size()-1);
            swap(nums, pos, i);
        }
    }
    private static void swap(int nums[], int a, int b){
        int temp= nums[a];
        nums[a]= nums[b];
        nums[b]= temp;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3};
        ArrayList<ArrayList<Integer>> res= getPermutes(arr);
//        for(ArrayList <Integer> i: res)
            System.out.println(res);
    }
}
