import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SlidingWindow {
	
	//We will keep two pointer start and end in the front and move till the length of window (end - start +1 <size) 
	//When it becomes ==size we compare it with the max value store and move our two pointers
	
	int findMaxSubArray(int nums[], int size) {
		int sum=0, max= Integer.MIN_VALUE;
		
		int start=0, end=0;
		
		while(end < nums.length) {
			sum+= nums[end];
			if(end- start + 1< size) end++;
			else if(end - start + 1 == size) {
				max= Math.max(max, sum);
				sum= sum- nums[start];
				start++;
				end++;
			}
		}
		return max;
	}
	
	
	//First neegtive  integer ine evry window size of k
	
	void firstNegetive(int A[], int K) {
		int i=0,j=0, N= A.length;
        ArrayList<Integer> temp = new ArrayList<>();
        int[] ans = new int[N-K+1];
        while(j < N){
            if(A[j] < 0)
                temp.add(A[j]);    
            if(j-i+1 == K){
                if(temp.size() == 0)
                    ans[i] = 0;
                else if(A[i] == temp.get(0))
                    ans[i] = temp.remove(0);
                else
                    ans[i] = temp.get(0);
                i++;
            }
            j++;
        }
//        return ans;
        for(int l:ans) System.out.print(l+" ");
	}
	
	
	
	//COunt occurence
	void countAnagrams(String s1, String s2) {
			ArrayList<Integer> list= new ArrayList<>();
			HashMap<Character, Integer> map= new HashMap<>();
			//We map all the charcater of target string
			for(char c:s2.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
			
			int counter= map.size();
			int start=0, end=0;
			
			while(end < s1.length()) {
				char c= s1.charAt(end);
				if(map.containsKey(c)) {
					map.put(c, map.get(c)-1 );
					if(map.get(c) == 0)
						counter--;
				}
				end++;
				
				//if counter ==0 that means we find an anagram 
				while(counter == 0) {
					char ch= s1.charAt(start);
					if(map.containsKey(ch)) {
						map.put(ch, map.getOrDefault(ch, 0) + 1);
						if(map.get(ch) > 0) 
							counter++;
					}
					
					if(end - start == s2.length()) {
						list.add(start);
					}
					start++;
					
				}
				
				
			}
			System.out.println(list);
			
			
		 	
	        
	}
	
	
	private void smallestSubArrayProduct(int nums[], int k) {
		int count=0;
		
		int start=0, end=0;
		long prod=1;
		while(end < nums.length) {
			prod*= nums[end];
			while(start <= end && prod >= k  ) {
					prod= prod / nums[start];
					start++;
				}
				count+= end - start +1;
				end++;
			
		}
		System.out.println( "ans =>"+count);
	}
	
	
	void longestUniqueSubstring(String s, int k) {
		Map<Character, Integer> map= new HashMap<>();
		int start=0, end=0,res= -1;
		while(end < s.length()) {
			int counter= map.size();
			map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
			if(counter < k ) {
				end++;
			}
			else if(counter ==  k) {
				res= Math.max(end - start + 1, res);
				end++;
			}
			else if(counter > k) {
				while(counter > k) {
					map.put(s.charAt(start), map.get(s.charAt(start))-1);
					if(map.get(s.charAt(start)) == 0)
						counter--;
					start++;
				}
				end++;
			}
			
		}
		System.out.println(res);
	}
	
	
	
//	longest Substring With At most Two Distinct Characters
	private void longestSubstringWithAtmostTwoDistinctCharacters(String s) {
//		abaacbebebe
		int start=0, end=0, res=-1;
		HashMap<Character, Integer> map= new HashMap<>();
		while(end <s.length()) {
			int counter =map.size();
			map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
			if(counter < 2) {
				end++;
			}
			else if(counter== 2) {
				res= Math.max(end - start + 1, res);
				end++;
			}
			else if(counter > 2) {
				while(counter > 2) {
					map.put(s.charAt(start), map.get(s.charAt(start))-1);
					if(map.get(s.charAt(start)) ==0)
						counter--;
					start++;
					
				}
				end++;
			}
			
		}
		System.out.println(res);
		
	}
	
	
	
	public static void main(String[] args) {
		
		SlidingWindow obj= new SlidingWindow();
		
		//Find all max subarray with size 
		int nums[]= {4,7,1,3,5,2,9,1,5};
		int size=3;
		
		//find all first Negetives in an array
		int negs[]= {12,-1,3,-3,9,5,-7,11,-4,2,-8,-9,-1,12,4,13};
//		obj.firstNegetive(negs, size);
		
		
		//Count occurences of anagrams
		String s1="abcjhjfbcaklsdjljnscablskjdacb";
		String s2="abc";
//		obj.countAnagrams(s1, s2);
		
		
//		System.out.println(obj.findMaxSubArray(nums, size));
		
		
		//Variable Sliding window
		
		/*
		 * while(end < size){
		 * calculations
		 * if(condition < size) end++;
		 
		 
		 * else if(condtion == size){
		 * make an answer from the calculation
		 * end++;
		 * }
		 * 
		 * else if(condition > k){
		 * remove from the start untol condition or sum < k
		 * while(condtion >k){
		 * condition-= nums[start];
		 * start++;
		 * }
		 * end++;
		 * }
		 * */
		//Find the subarray product less than k
		int arr[]= {5,7,2,4,1,8,2,7,5};
//		obj.smallestSubArrayProduct(arr, 16);
		
		//Longest SUbstring with k unique character
		String s="abaacbebebe";
		obj.longestUniqueSubstring(s, 3);
		
		String str="abaccab";
		obj.longestSubstringWithAtmostTwoDistinctCharacters(str);
		
		
	}

}
