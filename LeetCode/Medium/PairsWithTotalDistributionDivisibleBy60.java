public class PairsWithTotalDistributionDivisibleBy60 {
    static int getPairs(int nums[]){
        int res=0;
        /* WE would be storing all the rems and checking whether the rems repeated
        if it repeats then the same reminder would make a pair
        we would be only iterate from 1 to 29 (60 /2) to avoid duplication
         */
        int rems[]= new int [60];
        for(int t:nums) rems[t % 60]++;
        //Special case for 0 and 30 because they make a self pair of (0, 0) and (30, 30) which are
        //diviisble by 60
        res+= rems[0] * (rems[0] -1)/2;
        res+= rems[30] * (rems[30] -1)/2;//(N * N-1) /2
        for(int i=1; i< 30; i++)
            res+= rems[i] * rems[60 - i];
        return res;


    }
    public static void main(String[] args) {
        int nums[]= {30,20,150,100,40};
        System.out.println(getPairs(nums));
    }
}
