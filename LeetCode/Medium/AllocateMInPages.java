public class AllocateMInPages {
    static int allocate(int nums[], int n){
        int low=Integer.MAX_VALUE, high= 0;
        for(int i: nums){
            low= Math.min(low, i);
            high+=i;
        }
        int res=0;
        while( low <= high){
            int mid= (low + high) >> 1;
            if(isFeasible(nums, n, mid)){
                res=mid;
                high= mid -1;
            }
            else low= mid+1;

        }
        return res;
    }
    private static boolean isFeasible(int nums[], int n, int mid){
        int sum=0;
        int count=1;
        for(int i: nums){
            if(i > mid) return  false;
            if(sum + i>mid){
                count++;
                sum+=i;
            }
            else sum+=i;
        }
        return count <= n;
    }
    public static void main(String[] args) {
       int  A []= {12, 34, 67, 90};
        int B = 2;
        System.out.println(allocate(A, B));
    }
}
