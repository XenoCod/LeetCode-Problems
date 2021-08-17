import java.util.ArrayList;

public class PalindromePartioning {
    static ArrayList<ArrayList<String>> getPalindrome(String s){
        ArrayList<ArrayList<String>> res= new ArrayList<>();
        solve(res, new ArrayList<>(), s, 0);
        return res;

    }
    private static void solve(ArrayList<ArrayList<String>> res, ArrayList<String> temp, String s, int pos) {
        if(pos == s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=pos; i<s.length(); i++){
            if(isPal(s, pos,i)){
                temp.add(s.substring(pos, i+1));
                solve(res, temp, s, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    private static boolean isPal(String s, int l, int r){
        while(l<r)
            if(s.charAt(l++)!= s.charAt(r--)) return false;
        return true;
    }
    public static void main(String[] args) {
        String s="racecar";
        ArrayList<ArrayList<String>> res= getPalindrome(s);
        for(ArrayList<String> i: res)
            System.out.println(i);
    }
}
