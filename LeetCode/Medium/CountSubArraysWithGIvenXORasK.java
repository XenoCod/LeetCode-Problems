import java.util.HashMap;

public class CountSubArraysWithGIvenXORasK {
    static int getSubArrayCount(int arr[], int target){
        int xorr=0, count=0;
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i:arr){
            xorr= xorr^ i;
            if(map.get(xorr ^ target)!=null) count+=map.get(xorr ^ target);
            if(xorr==target) count++;
            map.put(xorr, map.getOrDefault(xorr, 0)+1);
        }
        return  count;
    }
    public static void main(String[] args) {
        int arr[]={5, 6, 7, 8, 9};
        int target=5;
        System.out.println(getSubArrayCount(arr, target));
    }
}
