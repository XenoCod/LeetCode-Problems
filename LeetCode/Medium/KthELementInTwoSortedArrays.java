public class KthELementInTwoSortedArrays {
    static long getKth(int nums1[], int nums2[], int k){
        int n1=nums1.length, n2= nums2.length;
        if(n2< n2) return getKth(nums2, nums1,k);
        int low= Math.max(0, k - n2), high= Math.min(k, n1 );
        while(low <= high){
            int cut1= (low + high) >> 1;
            int cut2= (k - cut1);

            int left1= (cut1 == 0)?Integer.MIN_VALUE: nums1[cut1-1];
            int left2= (cut2 == 0)?Integer.MIN_VALUE: nums2[cut2-1];
            int right1=(cut1 == n1)?Integer.MAX_VALUE: nums1[cut1];
            int right2=(cut2 == n2)?Integer.MAX_VALUE: nums2[cut2];

            if(left1 <= right2 && left2 <= right1){
                return Math.max(left1, left2);
            }
            else if( left1 > right2) high= cut1 -1;
            else low = cut1 +1;

        }
        return 1;
    }
    public static void main(String[] args) {
        int arr1[] = {2, 3, 6, 7, 9};
        int arr2[] = {1, 4, 8, 10};
       int k = 5;
        System.out.println(getKth(arr1, arr2, k));
    }

}
