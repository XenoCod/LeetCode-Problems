import java.util.Arrays;

public class MinPlatforms {
    static int minPlatforms(int arr[], int dept[]){
        int i=1, j=0, res=0, platforms=1;
        Arrays.sort(arr);
        Arrays.sort(dept);
        while(i < arr.length && j< dept.length){
            if(arr[i]<= dept[j]){
                platforms++;
                i++;
            }
            else{
                platforms--;
                j++;
            }
            res= Math.max(platforms, res);
        }
        return res;
    }
    public static void main(String[] args) {
        int arrival[] = {900, 940, 950, 1100, 1500, 1800};
        int departure[] = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(minPlatforms(arrival, departure));
    }
}
