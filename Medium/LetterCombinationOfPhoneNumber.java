import java.util.ArrayList;
import java.util.HashMap;

public class LetterCombinationOfPhoneNumber {
    static ArrayList<String> getCominations(String digits){
        ArrayList<String> res= new ArrayList<>();
        HashMap<Character, String> map= new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");ṇ
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtrack(res, new StringBuilder(), 0, map, digits);
        return res;

    }
    private static void backtrack(ArrayList<String> res, StringBuilder sb, int i, HashMap<Character, String> map, String digits){
        if(sb.length()==digits.length()){
            res.add(sb.toString());
            return;
        }
        String curr= map.get(digits.charAt(i));
        for(int j=0;j < curr.length(); j++){
            sb.append(curr.charAt(j));
            backtrack(res, sb, i+1, map, digits);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static void main(String[] args) {
        String digits = "234";
        ArrayList<String> res= getCominations(digits);
        System.out.println(res);
    }
}
