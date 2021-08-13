import java.util.ArrayList;

public class MajorityInAnArrayMoreThanNBy3times {
    static ArrayList<Integer> getMajortiy(int arr[]){
        //As in array there cant be more than 2 element which can be present more than n/3 so we take 2 counter and 2 varibale to store...Its basically extensiond of Moore VOting algo with 2 pointer and counters
        int num1=-1, num2=-1, count1=0, count2=0;
        for(int i:arr){
            if(i==num1) count1++;
            else if(i ==num2) count2++;
            else if(count1==0){
                num1=i;
                count1=1;
            }
            else if(count2==0){
                num2=i;
                count2=1;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1=0; count2=0;
        for(int i:arr){
            if(i==num1) count1++;
            if(i==num2) count2++;
        }
        ArrayList<Integer>res=  new ArrayList<>();
        if(count1>arr.length/3) res.add(num1);
        if(count2>arr.length/3) res.add(num2);
        return res;

    }
    public static void main(String[] args) {
//        int arr[]= {3,2,3};
        int arr[] ={1,6,7,8,7,6,9,7,7,6,3,6,7,6,-1,6};
        System.out.println(getMajortiy(arr));
    }
}
