
public class ReverseWordInString {
	String reverseWords(String s) {
        char[] a = s.toCharArray();
        int n = a.length;
        
        // step 1. reverse the whole string
        reverse(a, 0, n - 1);
        System.out.println(new String(a));
        // step 2. reverse each word
        reverseWords(a, n);
        System.out.println(new String(a));
//        System.out.println(s+"2ns");
        // step 3. clean up spaces
//        System.out.println(cleanSpaces(a,n));
        return cleanSpaces(a, n);
        
        
	}
	
	
	
	
	void reverseWords(char[] a, int n) {
	    int i = 0, j = 0;
	      
	    while (i < n) {
	      while (i < j || i < n && a[i] == ' ') i++; // skip spaces
	      while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
	      reverse(a, i, j - 1);                      // reverse the word
	    }
	  }
	  
	
	String cleanSpaces(char[] a, int n) {
	    int i = 0, j = 0;
	      
	    while (j < n) {
	      while (j < n && a[j] == ' ') j++;             // skip spaces
	      while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
	      while (j < n && a[j] == ' ') j++;             // skip spaces
	      if (j < n) a[i++] = ' ';                      // keep only one space
	    }
	    System.out.println(new String(a)+"h");
	  
	    return new String(a).substring(0, i);
	  }
	
	
	
	private void reverse(char[] a, int i, int j) {
	    while (i < j) {
	      char t = a[i];
	      a[i++] = a[j];
	      a[j--] = t;
	    }
	  }
	
	public static void main(String[] args) {
		String s="  hello world  ";
		ReverseWordInString obj= new ReverseWordInString();
		System.out.println(obj.reverseWords(s));
	}

}
