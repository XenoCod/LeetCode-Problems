import java.util.ArrayList;

public class PartitionLabels {
    static ArrayList<Integer> getPartions(String s){
        ArrayList<Integer> res= new ArrayList<>();
        int last_seen[]= new int [26];
        int start=0, end=0;
        for(int i=0; i< s.length(); i++)
            last_seen[s.charAt(i) - 'a']=i;
        for(int i=0; i<s.length(); i++){
            end= Math.max(end, last_seen[s.charAt(i) - 'a']);
            if(end == i) {
                res.add(end - start + 1);
                start = end + 1;
            }

        }
        return res;
    }
    public static void main(String[] args) {
        String s="ababcbacadefegdehijhklij";
        System.out.println(getPartions(s));
    }
}
