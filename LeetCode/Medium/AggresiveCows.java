import java.util.Arrays;

public class AggresiveCows {
    static int getCows(int stalls[], int cows){
        Arrays.sort(stalls);
        int low= stalls[0], high= stalls[stalls.length-1] - stalls[0],res=0;
        while(low <= high){
            int mid= (low + high) >> 1;
            if(isFeasible(stalls, cows, mid)){
                res= mid;
                low = mid+1;
            }
            else high= mid-1;
        }
        return res;
    }
    private static  boolean isFeasible(int arr[], int cows, int mid){
        int count=1, coord= arr[0];
        for(int i=1; i< arr.length; i++){
            if(arr[i] - coord >= mid){
                count++;
                coord= arr[i];
            }
            if(count== cows) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int stalls[]= {1, 2, 8, 4, 9};
        int cows=3;
        System.out.println(getCows(stalls, cows));
    }
}
