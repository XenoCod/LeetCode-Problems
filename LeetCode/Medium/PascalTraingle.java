import java.util.ArrayList;

public class PascalTraingle {
    static ArrayList<ArrayList<Integer>> pascalT(int n){
        ArrayList<ArrayList<Integer>> res= new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> temp= new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i)
                    temp.add(1);
                else{
                    int a=res.get(i-1).get(j-1);
                    int b= res.get(i-1).get(j);
                    temp.add(a+b);

                }
            }
            res.add(temp);
        }
        return res;
    }
    public static void main(String[] args) {
        int n=6;
        ArrayList<ArrayList<Integer>> res=pascalT(n);
        for(ArrayList<Integer> i:res)
            System.out.println(i);
    }
}
