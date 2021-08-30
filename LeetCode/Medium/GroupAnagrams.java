import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GroupAnagrams {
	void groupAnagrams(String [] strs) {
		
		Map<String, ArrayList<String>> map= new HashMap<>();
		for(String s:strs) {
			char ch[]= new char[26];
			for(char c:s.toCharArray()) ch[c - 'a']++;
			String encodedKey= String.valueOf(ch);
			System.out.println(encodedKey);
			if(!map.containsKey(encodedKey)) map.put(encodedKey, new ArrayList<>());
			map.get(encodedKey).add(s);
			
		}
		for(Map.Entry<String, ArrayList<String>> it: map.entrySet())
			System.out.println( it.getValue());
        
	}
	public static void main(String[] args) {
		String strs[]= {"eat","tea","tan","ate","nat","bat"};
		GroupAnagrams obj= new GroupAnagrams();
		obj.groupAnagrams(strs);
	}

}
