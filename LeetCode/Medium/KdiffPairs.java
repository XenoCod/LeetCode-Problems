import java.util.HashMap;
import java.util.Map;

public class KdiffPairs {
	static int getPairs(int nums[], int k) {
		 HashMap<Integer, Integer> map= new HashMap<>();
	        int count=0;
	        //We just check on if k==0 then the same values is repeating or not
	       //If diif is bigger we check whether k + diff is already present or not
	        for(int i:nums) map.put(i, map.getOrDefault(i, 0)+1);
	        for(Map.Entry<Integer, Integer> it: map.entrySet()) {
	        	if(k == 0) {
	        		if(it.getValue()>=2)
	        			count++;
	        	}
	        	else {
	        		if(map.containsKey(it.getKey() + k) )
	        			count++;
	        	}
	        }
	        return count;
	}
	public static void main(String[] args) {
		int nums[]= {1,2,3, 4, 5};
		int k=3;
		System.out.println(getPairs(nums, k));
	}

}
