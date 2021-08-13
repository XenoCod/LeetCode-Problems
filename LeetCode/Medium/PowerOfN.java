public class PowerOfN {
    static double powerOfN(double x, int n){
        long num= n; double ans=1;
        if(num<0) num=-1 * num;
        while(num>0){
            if(num%2==1){
                ans = ans * x;
                num--;
            }
            else{
                x= x * x;
                num= num/2;
            }
        }
        return (n<0) ? (double) 1/(double) ans: ans;
    }
    public static void main(String[] args) {
        double x= 2.00000;
        int n=10;
        System.out.println(powerOfN(x, n));

    }
}
