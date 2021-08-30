import java.util.ArrayList;
import java.util.Stack;

public class SimplifyString {
	String simplify(String s) {
		Stack<String> st= new Stack<>();
		String strs[]=s.split("/" );
		for(int i=0; i<strs.length;i++) {
			if(!st.empty() && strs[i].equals("..")) st.pop();
			if(!strs[i].equals(".") && !strs[i].equals("") && !strs[i].equals("..")) st.push(strs[i]);
		}
//		while(!st.empty()) System.out.println(st.pop());
		ArrayList<String> res=new ArrayList<String>(st);
		return "/"+String.join("/", res);
		
	}
	public static void main(String[] args) {
		String s="/a/./b/../../c/";
		SimplifyString obj= new SimplifyString();
		System.out.println(obj.simplify(s));
	}
}
